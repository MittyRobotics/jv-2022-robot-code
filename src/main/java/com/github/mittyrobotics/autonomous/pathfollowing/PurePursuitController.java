package com.github.mittyrobotics.autonomous.pathfollowing;

public class PurePursuitController {
    public static DifferentialDriveState purePursuit(double tangentRadius, double linearVelocity, boolean turnRight, double trackwidth) {
        DifferentialDriveState dds = new DifferentialDriveState();
        dds.updateFromLinearVelocityAndRadius(linearVelocity, tangentRadius, turnRight, trackwidth);
        return dds;
    }
}
