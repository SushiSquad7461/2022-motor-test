// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

public class SparkMaxMotor extends SubsystemBase {

  private final CANSparkMax motor;

  public SparkMaxMotor() {
    motor = new CANSparkMax(Constants.kSparkMax.MOTOR_ID,
                            Constants.kSparkMax.MOTOR_TYPE);

    motor.restoreFactoryDefaults();
    motor.setInverted(Constants.kSparkMax.INVERTED);
    motor.setOpenLoopRampRate(Constants.kSparkMax.OPEN_LOOP_RAMP_RATE);
    motor.setSmartCurrentLimit(Constants.kSparkMax.CURRENT_LIMIT);
    motor.burnFlash();
  }


  public void start() {
    motor.set(Constants.kSparkMax.SPEED);
  }

  @Override
  public void periodic() { }

  @Override
  public void simulationPeriodic() { }
}
