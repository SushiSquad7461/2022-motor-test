// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class falcon extends SubsystemBase {
    TalonFX testFalcon;
    
    PIDController falconController;
    SimpleMotorFeedforward fForward;
    /** Creates a new ExampleSubsystem. */
    public falcon() {
        testFalcon = new TalonFX(Constants.kFalcon.MOTOR_ID);
        
        //config
        testFalcon.setInverted(Constants.kFalcon.COUNTERCLOCKWISE);
        testFalcon.configSupplyCurrentLimit(Constants.kFalcon.CURRENT_LIMIT);
        testFalcon.configVoltageCompSaturation(12, 100);
        testFalcon.enableVoltageCompensation(true);
        testFalcon.configClosedloopRamp(0.2);
        testFalcon.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 100);

        //config PID
        testFalcon.config_kP(0, Constants.kFalcon.integratedkP, 100);
        testFalcon.config_kI(0, Constants.kFalcon.integratedkI, 100);
        testFalcon.config_kD(0, Constants.kFalcon.integratedkD, 100);
        
        falconController = new PIDController(Constants.kFalcon.kP, Constants.kFalcon.kI, Constants.kFalcon.kD);
        fForward = new SimpleMotorFeedforward(Constants.kFalcon.kS, Constants.kFalcon.kV);

        falconController.setSetpoint(testFalcon.getSelectedSensorPosition());
    }

    public void setMotor(double goal) {
        SmartDashboard.putNumber("integrated goal", goal);
        testFalcon.set(ControlMode.Position, goal, DemandType.Neutral, fForward.calculate(goal));
    }

    public void runMotor(double value) {
        testFalcon.set(ControlMode.PercentOutput, value);
    }

    public void useOutput(double output, double setpoint) {
        double feedForward = fForward.calculate(setpoint);
        double input;
        if(feedForward + output > 0.1) {
            input = 0.1;
        } else if(feedForward + output < -0.1) {
            input = -0.1;
        } else {
            input = feedForward + output;
        }
        testFalcon.set(ControlMode.PercentOutput, feedForward + output);
        SmartDashboard.putNumber("pid output", input);
    }

    public void setGoal(double goal) {
        falconController.setSetpoint(goal);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("motor output", testFalcon.getMotorOutputPercent());
        SmartDashboard.putNumber("motor position", testFalcon.getSelectedSensorPosition());
        SmartDashboard.putNumber("motor velocity", testFalcon.getSelectedSensorVelocity());
        //SmartDashboard.putNumber("controller setpoint", falconController.getSetpoint());

        // pid output
        /*
        double output = falconController.calculate(testFalcon.getSelectedSensorPosition());
        useOutput(output, falconController.getSetpoint()); */
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
