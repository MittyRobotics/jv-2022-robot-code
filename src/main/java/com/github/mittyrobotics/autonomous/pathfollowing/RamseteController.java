package com.github.mittyrobotics.autonomous.pathfollowing;

public class RamseteController {

    public static double ex, ey, et, k, rvel, rAngVel;
    public static Angle t, td;

    public static DifferentialDriveState ramsete(Pose2D curPose, Pose2D desiredPose, double desiredVelocity, double desiredAngularVelocity, double b, double Z, double trackwidth) {
        //https://file.tavsys.net/control/controls-engineering-in-frc.pdf

        //b > 0, 0 < Z < 1, larger b -> faster convergence, larger Z -> more dampening

        k = 2*Z*Math.sqrt(desiredAngularVelocity*desiredAngularVelocity + b * desiredVelocity * desiredVelocity);

        t = curPose.getAngle();
        td = desiredPose.getAngle();
        double x = curPose.getPosition().getX();
        double xd = desiredPose.getPosition().getX();
        double y = curPose.getPosition().getY();
        double yd = desiredPose.getPosition().getY();

        ex = t.cos() * (xd - x) + t.sin() * (yd - y);
        ey = t.sin() * (x - xd) + t.cos() * (yd - y);
        et = td.getAngleBetween(t);

        rvel = desiredVelocity * Math.cos(et) + k * ex;
        rAngVel = desiredAngularVelocity + k * et + b * desiredVelocity * sinc(et) * ey;

        DifferentialDriveState dds = new DifferentialDriveState(trackwidth);

        dds.updateFromLinearAndAngularVelocity(rvel, rAngVel, trackwidth);
        return dds;
    }

    public static double sinc(double e) {
        if(e == 0) return 1;
        return Math.sin(e)/e;
    }
}
