// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  public static final kSparkMax {
    public static final int MOTOR_ID = 4;
    public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE =
                                      CANSparkMaxLowLevel.MotorType.kBrushless;
    public static final int CURRENT_LIMIT = 35;
    public static final int OPEN_LOOP_RAMP_RATE = 0;
    public static final boolean INVERTED = true;
    public static final float SPEED = 0.5;
  }
}
