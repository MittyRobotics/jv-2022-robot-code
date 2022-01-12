package com.github.mittyrobotics.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    private static  ShooterSubsystem instance;

    private ShooterSubsystem () {
        setName("Shooter");
    }

    public static ShooterSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterSubsystem();
        }
        return instance;
    }

    /**
     * HARDWARE HERE
     */

    public void initHardware() {

    }

    public void updateDashboard() {

    }
}
