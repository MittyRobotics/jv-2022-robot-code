package com.github.mittyrobotics.autonomous.pathfollowing;

public class PurePursuitController {
    public static path.DifferentialDriveState purePursuit(double tangentRadius, double linearVelocity, boolean turnRight, double trackwidth) {
        path.DifferentialDriveState dds = new path.DifferentialDriveState(trackwidth);
        dds.updateFromLinearVelocityAndRadius(linearVelocity, tangentRadius, turnRight, trackwidth);
        return dds;
    }
}
