package com.github.mittyrobotics.commands;

import com.github.mittyrobotics.OI;
import com.github.mittyrobotics.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
    public TankDrive() {
        addRequirements(DriveTrain.getInstance());
    }

    @Override
    public void initialize() {
        DriveTrain.getInstance().setMotors(0, 0);
    }

    @Override
    public void execute() {
        double percent = 0.5;
        double deadzone = 0.1;
        double left = OI.getInstance().getController().getLeftY() * percent;
        double right = OI.getInstance().getController().getRightY() * percent;
        if(Math.abs(left) < deadzone) {
            left = 0;
        }
        if(Math.abs(right) < deadzone) {
            right = 0;
        }
        DriveTrain.getInstance().setMotors(left, right);
    }

    @Override
    public void end(boolean interrupted) {
        DriveTrain.getInstance().setMotors(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
