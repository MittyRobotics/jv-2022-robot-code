package com.github.mittyrobotics.autonomous;

import com.github.mittyrobotics.autonomous.pathfollowing.Angle;
import com.github.mittyrobotics.autonomous.pathfollowing.Point2D;
import com.github.mittyrobotics.autonomous.pathfollowing.Pose2D;
import com.github.mittyrobotics.autonomous.pathfollowing.Vector2D;

public class Odometry {
    private Pose2D robotPose = new Pose2D(0, 0, 0);
    private Point2D deltaPosition = new Point2D(0, 0);
    private double lastLeftEncoder = 0;
    private double lastRightEncoder = 0;
    private double calibrateGyroVal = 0;

    private static Odometry instance = new Odometry();

    public static Odometry getInstance() {
        return instance;
    }

    public void update(double leftEncoder, double rightEncoder, double gyro){
        //Get robot rotation
        Angle robotRotation = new Angle(gyro - calibrateGyroVal);

        //Get delta left and right encoder pos
        double deltaLeftPos = leftEncoder - lastLeftEncoder;
        double deltaRightPos = rightEncoder - lastRightEncoder;

        //Get average delta encoder pos in inches
        double deltaEncoder = (deltaLeftPos + deltaRightPos) / 2;

        //Get x and y values from heading and delta pos
        double deltaX = deltaEncoder * robotRotation.cos();
        double deltaY = deltaEncoder * robotRotation.sin();

        //Set last encoder positions
        lastLeftEncoder = leftEncoder;
        lastRightEncoder = rightEncoder;

        //Get delta position
        deltaPosition = new Point2D(deltaX, deltaY);

        robotPose = new Pose2D(robotPose.getPosition().add(deltaPosition), robotRotation);
    }

    public void zeroEncoders(double leftEncoder, double rightEncoder){
        lastLeftEncoder = leftEncoder;
        lastRightEncoder = rightEncoder;
    }

    public void setHeading(double heading, double gyro) {
        calibrateGyroVal = gyro - heading;
    }

    public void setPose(Pose2D curPose, double gyro){
        this.robotPose = curPose;
        setHeading(curPose.getAngle().getRadians(), gyro);
    }

    public Angle getRobotRotation(){
        return robotPose.getAngle();
    }

    public Point2D getRobotVector() {
        return robotPose.getPosition();
    }

    public Pose2D getRobotPose() { return robotPose; }
}