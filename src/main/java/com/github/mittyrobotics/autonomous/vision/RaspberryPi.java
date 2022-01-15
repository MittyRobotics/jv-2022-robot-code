package com.github.mittyrobotics.autonomous.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class RaspberryPi {
    private static RaspberryPi instance = new RaspberryPi();
    private NetworkTable table;

    public void initHardware() {
        table = NetworkTableInstance.getDefault().getTable("rasppi");
    }

    public RaspberryPi getInstance() {
        return instance;
    }
}
