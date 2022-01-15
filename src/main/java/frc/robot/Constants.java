// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMaxLowLevel;

public final class Constants {
  public static final class kSparkMax {
    public static final int MOTOR_ID = 4;
    public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE =
                                      CANSparkMaxLowLevel.MotorType.kBrushless;
    public static final int CURRENT_LIMIT = 35;
    public static final int OPEN_LOOP_RAMP_RATE = 0;
    public static final boolean INVERTED = true;
    public static final double SPEED = 0.5;
  }
  public static final class kFalcon {
    public static final int MOTOR_ID = 4;
    // public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE =
    //                                   CANSparkMaxLowLevel.MotorType.kBrushless;
    public static final int CURRENT_LIMIT = 35;
    public static final int OPEN_LOOP_RAMP_RATE = 0;
    public static final boolean INVERTED = true;
    public static final double SPEED = 0.5;
  }
  public static final class kHood {
    public static final int LEFT_MOTOR_ID = -1;
    public static final int RIGHT_MOTOR_ID = -1;
    public static final int KICKER = -1;

    // public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE =
    //                                   CANSparkMaxLowLevel.MotorType.kBrushless;
    public static final int CURRENT_LIMIT = 35;
    public static final int OPEN_LOOP_RAMP_RATE = 0;
    public static final boolean INVERTED = true;
    public static final double SPEED = 0.5;
    public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE =
    CANSparkMaxLowLevel.MotorType.kBrushless;
  }
}
