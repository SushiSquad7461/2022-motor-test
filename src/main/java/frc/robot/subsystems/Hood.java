// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

public class Hood extends SubsystemBase {

  private final CANSparkMax left;
  private final CANSparkMax right;

  public Hood() {
    left = new CANSparkMax(Constants.kHood.LEFT_MOTOR_ID,
                            Constants.kHood.MOTOR_TYPE);

    right = new CANSparkMax(Constants.kHood.RIGHT_MOTOR_ID,
                            Constants.kHood.MOTOR_TYPE);

    left.restoreFactoryDefaults();
    left.setInverted(Constants.kHood.INVERTED);
    left.setOpenLoopRampRate(Constants.kHood.OPEN_LOOP_RAMP_RATE);
    left.setSmartCurrentLimit(Constants.kHood.CURRENT_LIMIT);
    left.burnFlash();

    right.restoreFactoryDefaults();
    right.setInverted(!Constants.kHood.INVERTED);
    right.setOpenLoopRampRate(Constants.kHood.OPEN_LOOP_RAMP_RATE);
    right.setSmartCurrentLimit(Constants.kHood.CURRENT_LIMIT);
    right.burnFlash();
  }

  public void start() { run(Constants.kHood.SPEED);}
  public void stop() { run(0); }

  public void reverse() { run(-Constants.kHood.SPEED); }

  public void run(double speed) {
    // Cant throw exceptions? Please help
    if (speed > 1 || speed < -1)
      return;
    left.set(speed);
    right.set(speed);
  }

  @Override
  public void periodic() { 

  }

  @Override
  public void simulationPeriodic() { }
}
