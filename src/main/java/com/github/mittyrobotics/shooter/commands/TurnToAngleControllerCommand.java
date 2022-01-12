package com.github.mittyrobotics.shooter.commands;

import com.github.mittyrobotics.autonomous.pathfollowing.Angle;
import com.github.mittyrobotics.shooter.ShooterSubsystem;
import com.github.mittyrobotics.util.OI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToAngleControllerCommand extends CommandBase {
    private Angle theta;

    public TurnToAngleControllerCommand() {
        setName("Turn To Angle");
        addRequirements(ShooterSubsystem.getInstance());
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        theta = new Angle(OI.getInstance().CONTROLLINGJOYSTICK+VALUE);
        ShooterSubsystem.getInstance().turnRadians(theta);
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
