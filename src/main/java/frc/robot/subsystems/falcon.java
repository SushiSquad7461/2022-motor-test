// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class falcon extends SubsystemBase {
    TalonFX testFalcon;
    /*
    PIDController falconController; */
    SimpleMotorFeedforward fForward;
    /** Creates a new ExampleSubsystem. */
    public falcon() {
        testFalcon = new TalonFX(Constants.kFalcon.MOTOR_ID);
        
        //config
        testFalcon.setInverted(Constants.kFalcon.CLOCKWISE);
        testFalcon.configSupplyCurrentLimit(Constants.kFalcon.CURRENT_LIMIT);
        testFalcon.configVoltageCompSaturation(12, 100);
        testFalcon.enableVoltageCompensation(true);
        testFalcon.configClosedloopRamp(0.2);
        testFalcon.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 100);
        
        // falconController = new PIDController(Constants.kFalcon.kP, Constants.kFalcon.kI, Constants.kFalcon.kD);
        fForward = new SimpleMotorFeedforward(Constants.kFalcon.kS, Constants.kFalcon.kV);
    }

    public void setMotor(double goal) {
        testFalcon.set(ControlMode.Position, goal, DemandType.ArbitraryFeedForward, fForward.calculate(goal));
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}