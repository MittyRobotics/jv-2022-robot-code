package com.github.mittyrobotics.shooter.commands;

import com.github.mittyrobotics.autonomous.pathfollowing.Angle;
import com.github.mittyrobotics.shooter.ShooterSubsystem;
import com.github.mittyrobotics.util.Gyro;
import com.github.mittyrobotics.util.OI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToAngleCommand extends CommandBase {

    public TurnToAngleCommand() {
        setName("Turn To Angle");
        addRequirements(ShooterSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        Angle theta = new Angle(OI.getInstance().CONTROLLINGJOYSTICK+VALUE + Gyro.getInstance().getAngle());
        ShooterSubsystem.getInstance().turnToAngle(theta);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
