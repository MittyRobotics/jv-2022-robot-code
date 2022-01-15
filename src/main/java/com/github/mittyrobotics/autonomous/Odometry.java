package com.github.mittyrobotics.autonomous;

import com.github.mittyrobotics.autonomous.pathfollowing.Angle;
import com.github.mittyrobotics.autonomous.pathfollowing.Vector2D;

public class Odometry {
    private Vector2D deltaPosition = new Vector2D(0, 0);
    private Angle robotRotation = new Angle(0);
    private double lastLeftEncoder = 0;
    private double lastRightEncoder = 0;
    private double calibrateGyroVal = 0;

    private static Odometry instance = new Odometry();

    private Vector2D robotVector = new Vector2D();

    public static Odometry getInstance(){
        return instance;
    }

    public void update(double leftEncoder, double rightEncoder, double gyro){
        //Get robot rotation
        robotRotation = new Angle(gyro - calibrateGyroVal);

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
        deltaPosition = new Vector2D(deltaX, deltaY);

        robotVector = robotVector.add(deltaPosition);
    }

    public void zeroEncoders(double leftEncoder, double rightEncoder){
        lastLeftEncoder = leftEncoder;
        lastRightEncoder = rightEncoder;
    }

    public void zeroHeading(double gyro){
        setHeading(0, gyro);
    }

    public void setHeading(double heading, double gyro) {
        calibrateGyroVal = gyro - heading;
    }

    public void zeroPosition(){
        this.robotVector = new Vector2D(0, 0);
    }

    public Vector2D getDeltaPosition(){
        return deltaPosition;
    }

    public Angle getRobotRotation(){
        return robotRotation;
    }

    public Vector2D getRobotVector() {
        return robotVector;
    }
}