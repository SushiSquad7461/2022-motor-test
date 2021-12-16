// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.revrobotics.CANSparkMaxLowLevel;

public final class Constants {
  public static final class kFalcon {
    public static final int MOTOR_ID = 0;
    // public static final CANSparkMaxLowLevel.MotorType MOTOR_TYPE =
    //                                   CANSparkMaxLowLevel.MotorType.kBrushless;
    //public static final int CURRENT_LIMIT = 35;
    public static final int OPEN_LOOP_RAMP_RATE = 0;
    public static final boolean INVERTED = true;
    public static final double SPEED = 0.5;

    // PID Constants
    public static final double kP = 0.000142;
    public static final double kI = 0.0;
    public static final double kD = 0.0;

    // integrated constants
    public static final double integratedkP = 0.01;
    public static final double integratedkI = 0.0;
    public static final double integratedkD = 0.0;

    // FF Constants
    public static final double kS = 0.0;
    public static final double kV = 0.0;

    // inversion state
    public static final TalonFXInvertType CLOCKWISE = TalonFXInvertType.Clockwise;
    public static final TalonFXInvertType COUNTERCLOCKWISE = TalonFXInvertType.CounterClockwise;
    public static final SupplyCurrentLimitConfiguration CURRENT_LIMIT = 
      new SupplyCurrentLimitConfiguration(true, 35, 0, 0);
  }
}
