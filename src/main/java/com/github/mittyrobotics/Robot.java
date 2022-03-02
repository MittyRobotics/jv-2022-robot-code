package com.github.mittyrobotics;

import com.github.mittyrobotics.commands.TankDrive;
import com.github.mittyrobotics.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    @Override
    public void robotInit() {
        DriveTrain.getInstance().initHardware();
        OI.getInstance().initOI();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        DriveTrain.getInstance().setDefaultCommand(new TankDrive());
    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void disabledInit() {
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
