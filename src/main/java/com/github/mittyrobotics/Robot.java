package com.github.mittyrobotics;

import com.github.mittyrobotics.autonomous.vision.Limelight;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  //TODO: Fix shooter theta assignment

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.updateValues();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    Limelight.getInstance().updateLimelightValues();

    SmartDashboard.putNumber("Limelight Pipeline: ", Limelight.getInstance().getPipeline());
  }


  @Override
  public void teleopInit() {

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
