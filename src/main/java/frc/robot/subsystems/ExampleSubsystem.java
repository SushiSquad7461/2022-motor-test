// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class ExampleSubsystem extends SubsystemBase {

  private final CANSparkMax motor;

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor = new CANSparkMax(4
, CANSparkMaxLowLevel.MotorType.kBrushless);

    motor.restoreFactoryDefaults();

    motor.setInverted(true);

    motor.setOpenLoopRampRate(0);

    motor.setSmartCurrentLimit(35);
  
    motor.burnFlash();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void start() {
    motor.set(0.5);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
