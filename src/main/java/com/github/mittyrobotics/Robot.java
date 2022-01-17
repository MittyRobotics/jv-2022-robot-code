package com.github.mittyrobotics;

import com.github.mittyrobotics.autonomous.Odometry;
import com.github.mittyrobotics.autonomous.commands.*;
import com.github.mittyrobotics.autonomous.pathfollowing.*;
import com.github.mittyrobotics.autonomous.vision.Limelight;
import com.github.mittyrobotics.drivetrain.DrivetrainSubsystem;
import com.github.mittyrobotics.drivetrain.commands.ManualTankDriveCommand;
import com.github.mittyrobotics.util.Gyro;
import com.github.mittyrobotics.util.SubsystemManager;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {
    @Override
    public void robotInit() {
        SubsystemManager.getInstance().addSubsystems(
                DrivetrainSubsystem.getInstance()
        );
        SubsystemManager.getInstance().initHardware();

        Gyro.getInstance().initHardware();
        Gyro.getInstance().calibrate();
        Gyro.getInstance().reset();

        Odometry.getInstance().zeroEncoders(DrivetrainSubsystem.getInstance().getLeftPosition(), DrivetrainSubsystem.getInstance().getRightPosition());
        Odometry.getInstance().setPose(new Pose2D(0, 0, 0), Gyro.getInstance().getAngleRadians());
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        SubsystemManager.getInstance().updateDashboard();
        SmartDashboard.updateValues();

        Odometry.getInstance().update(DrivetrainSubsystem.getInstance().getLeftPosition() * Path.TO_METERS, DrivetrainSubsystem.getInstance().getRightPosition() * Path.TO_METERS, Gyro.getInstance().getAngleRadians());
    }

    @Override
    public void autonomousInit() {
        DrivetrainSubsystem.getInstance().resetEncoder();
        Gyro.getInstance().reset();
        Odometry.getInstance().zeroEncoders(DrivetrainSubsystem.getInstance().getLeftPosition(), DrivetrainSubsystem.getInstance().getRightPosition());
        Odometry.getInstance().setPose(new Pose2D(0, 0, 0), Gyro.getInstance().getAngleRadians());

        QuinticHermiteSpline spline = new QuinticHermiteSpline(
                new Pose2D(0, 0, 0),
                new Pose2D(120 * Path.TO_METERS, 50 * Path.TO_METERS, 0)
        );

//        Path path = new Path(spline,
//                80 * Path.TO_METERS, 80 * Path.TO_METERS,
//                100 * Path.TO_METERS, 160 * Path.TO_METERS,
//                0 * Path.TO_METERS, 0 * Path.TO_METERS
//        );
//
//
//        PurePursuitPFCommand pathCommand = new PurePursuitPFCommand(path, 15 * Path.TO_METERS, 2 * Path.TO_METERS, 5 * Path.TO_METERS, false);
//
//        pathCommand.schedule();

        RamsetePath path = new RamsetePath(spline,
                100 * Path.TO_METERS, 100 * Path.TO_METERS,
                100 * Path.TO_METERS, 10000 * Path.TO_METERS,
                0 * Path.TO_METERS, 0 * Path.TO_METERS
        );


        RamsetePFCommand pathCommand = new RamsetePFCommand(path, 5, 0.2, 3 * Path.TO_METERS, 100000, false);

        pathCommand.schedule();
    }

    @Override
    public void autonomousPeriodic() {
        Limelight.getInstance().updateLimelightValues();

        SmartDashboard.putNumber("Limelight Pipeline: ", Limelight.getInstance().getPipeline());

    }

    @Override
    public void teleopInit() {
        DrivetrainSubsystem.getInstance().setDefaultCommand(new ManualTankDriveCommand());

    }


    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void disabledInit() {
        DrivetrainSubsystem.getInstance().coast();
    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {

    }
}
