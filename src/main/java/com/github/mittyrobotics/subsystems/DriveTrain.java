package com.github.mittyrobotics.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private static DriveTrain instance;

    private CANSparkMax left1, left2, right1, right2;
//    private PIDController controller;


    public static DriveTrain getInstance() {
        if(instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

    public void initHardware() {
        left1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
        left2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
        right1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
        right2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

        left1.restoreFactoryDefaults();
        left2.restoreFactoryDefaults();
        right1.restoreFactoryDefaults();
        right2.restoreFactoryDefaults();

        left1.setInverted(true);
        left2.setInverted(true);

        left1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        left2.setIdleMode(CANSparkMax.IdleMode.kBrake);
        right1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        right2.setIdleMode(CANSparkMax.IdleMode.kBrake);
//
//        left1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
//        right1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
//        resetEncoders();

//        controller = new PIDController(0.1 , 0, 0);
    }
//
//    public void resetEncoders() {
//        left1.setSelectedSensorPosition(0);
//        right1.setSelectedSensorPosition(0);
//    }
//
//    public double getPosition() {
//        return (left1.getSelectedSensorPosition() + right1.getSelectedSensorPosition())/2.;
//    }
//
//    public void positionPID(double setpoint) {
//        double TICKSPERINCH = 500;
//        setpoint = setpoint * TICKSPERINCH;
//
//        controller.setSetpoint(setpoint);
//        double output = controller.calculate(getPosition());
//        setMotors(output, output);
//
//    }

    public void setMotors(double left, double right) {
        left1.set(left);
        left2.set(left);
        right1.set(right);
        right2.set(right);
    }
}
