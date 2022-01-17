package com.github.mittyrobotics.autonomous.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.github.mittyrobotics.autonomous.AutonomousConstants;
import com.github.mittyrobotics.autonomous.Odometry;
import com.github.mittyrobotics.autonomous.pathfollowing.DifferentialDriveState;
import com.github.mittyrobotics.autonomous.pathfollowing.Path;
import com.github.mittyrobotics.autonomous.pathfollowing.Pose2D;
import com.github.mittyrobotics.drivetrain.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PurePursuitPFCommand extends CommandBase {

    private Path trajectory;
    private double lastTime;
    private double LOOKAHEAD, end_threshold, adjust_threshold;
    private final double TRACKWIDTH = AutonomousConstants.TRACKWIDTH;
    private boolean reverse;

    public PurePursuitPFCommand(Path trajectory, double LOOKAHEAD, double end_threshold, double adjust_threshold, boolean reverse) {
        addRequirements(DrivetrainSubsystem.getInstance());
        this.trajectory = trajectory;
        this.reverse = reverse;
        this.end_threshold = end_threshold;
        this.adjust_threshold = adjust_threshold;
        this.LOOKAHEAD = LOOKAHEAD;
    }

    public PurePursuitPFCommand(Path trajectory, double LOOKAHEAD, boolean reverse) {
        this(trajectory, LOOKAHEAD, 1 * Path.TO_METERS, 3 * Path.TO_METERS, reverse);
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


//      update(Pose2D robotPose, double dt, double lookahead, double end_threshold, double adjust_threshold, int newtonsSteps, double trackwidth)
        DifferentialDriveState dds = trajectory.update(robotPose, dt, LOOKAHEAD, end_threshold, adjust_threshold, 50, TRACKWIDTH);

        if(reverse) {
            DrivetrainSubsystem.getInstance().tankVelocity(-dds.getRightVelocity() * Path.TO_INCHES, -dds.getLeftVelocity() * Path.TO_INCHES);
        } else {
            DrivetrainSubsystem.getInstance().tankVelocity(dds.getLeftVelocity() * Path.TO_INCHES, dds.getRightVelocity() * Path.TO_INCHES);
        }

        lastTime = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {
        DrivetrainSubsystem.getInstance().overrideSetMotor(0, 0);
    }

    @Override
    public boolean isFinished() {
        Pose2D robotPose = new Pose2D(Odometry.getInstance().getRobotVector().getX(), Odometry.getInstance().getRobotVector().getY(), Odometry.getInstance().getRobotRotation().getRadians() + (reverse ? Math.PI : 0));

        return trajectory.isFinished(robotPose, end_threshold);
    }
}