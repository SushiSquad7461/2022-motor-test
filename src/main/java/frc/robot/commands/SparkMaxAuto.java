// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SparkMaxMotor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SparkMaxAuto extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final SparkMaxMotor motor;

  public SparkMaxAuto(SparkMaxMotor subsystem) {
    motor = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() { motor.start(); }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() { return false; }
}
