// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import java.util.Random;

public class SparkMaxMotor extends SubsystemBase {

  private final CANSparkMax motor;
  private int count = -1;

  public SparkMaxMotor() {
    motor = new CANSparkMax(Constants.kSparkMax.MOTOR_ID,
                            Constants.kSparkMax.MOTOR_TYPE);

    motor.restoreFactoryDefaults();
    motor.setInverted(Constants.kSparkMax.INVERTED);
    motor.setOpenLoopRampRate(Constants.kSparkMax.OPEN_LOOP_RAMP_RATE);
    motor.setSmartCurrentLimit(Constants.kSparkMax.CURRENT_LIMIT);
    motor.burnFlash();
  }

  public void start() { run(Constants.kSparkMax.SPEED);}
  public void stop() { run(0); }

  public void reverse() { run(-Constants.kSparkMax.SPEED); }

  public void haveStroke() { count = 0 ;}
  public void stopStroke() { count = -1; }

  public void run(double speed) {
    // Cant throw exceptions? Please help
    if (speed > 1 || speed < -1)
      return;
    motor.set(speed);
  }

  @Override
  public void periodic() { 
    if (count != -1 && count % 100 == 0) {
      Random rand = new Random();
      motor.set(rand.nextDouble(1));
    }
  }

  @Override
  public void simulationPeriodic() { }
}
