package com.github.mittyrobotics.autonomous.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.github.mittyrobotics.autonomous.AutonomousConstants;
import com.github.mittyrobotics.autonomous.Odometry;
import com.github.mittyrobotics.autonomous.pathfollowing.DifferentialDriveState;
import com.github.mittyrobotics.autonomous.pathfollowing.Path;
import com.github.mittyrobotics.autonomous.pathfollowing.Pose2D;
import com.github.mittyrobotics.autonomous.pathfollowing.RamsetePath;
import com.github.mittyrobotics.drivetrain.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RamsetePFCommand extends CommandBase {
    private RamsetePath trajectory;
    private double lastTime;
    private final double TRACKWIDTH = AutonomousConstants.TRACKWIDTH;
    private double b, Z, end_threshold, adjust_threshold;
    private boolean reverse;

    public RamsetePFCommand(RamsetePath trajectory, double b, double Z, double end_threshold, double adjust_threshold, boolean reverse) {
        addRequirements(DrivetrainSubsystem.getInstance());
        this.b = b;
        this.Z = Z;
        this.end_threshold = end_threshold;
        this.adjust_threshold = adjust_threshold;
        this.trajectory = trajectory;
        this.reverse = reverse;
    }

    public RamsetePFCommand(RamsetePath trajectory, double b, double Z, boolean reverse) {
        this(trajectory, b, Z, 1 * Path.TO_METERS, 5 * Path.TO_METERS, reverse);
    }

    @Override
    public void initialize() {
        lastTime = Timer.getFPGATimestamp();
        DrivetrainSubsystem.getInstance().setMode(NeutralMode.Brake);

    }

    @Override
    public void execute() {
        double dt = Timer.getFPGATimestamp() - lastTime;


        Pose2D robotPose = Odometry.getInstance().getRobotPose();
        robotPose.getAngle().add((reverse ? Math.PI : 0));

//      update(Pose2D robotPose, double dt, double end_threshold, double adjust_threshold, int newtonsSteps, double b, double Z, double trackwidth) {
        DifferentialDriveState dds = trajectory.update(robotPose, dt, end_threshold, adjust_threshold, 50, b, Z, TRACKWIDTH);

        if(reverse) {
            DrivetrainSubsystem.getInstance().tankVelocity(-dds.getRightVelocity(), -dds.getLeftVelocity());
        } else {
            DrivetrainSubsystem.getInstance().tankVelocity(dds.getLeftVelocity(), dds.getRightVelocity());
        }

        lastTime = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().overrideSetMotor(0, 0);
    }

    @Override
    public boolean isFinished() {
        Pose2D robotPose = Odometry.getInstance().getRobotPose();
        robotPose.getAngle().add((reverse ? Math.PI : 0));

        return trajectory.isFinished(robotPose, end_threshold);
    }
}
