// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class SingleMotorSubsystem extends SubsystemBase {
  /** Creates a new SingleMotor. */
  private final WPI_TALONSRX motor = new WPI_TalonSRX(MotorConstants.TESTBED_TALONSRX_CAN_ID);
  public SingleMotorSubsystem() {
    motor.setNeutralMode(NeutralMode.Brake);
    stopMotor();
  }

  public void startMotor(){
    lastSet = MotorConstants.DEFAULT_MOTOR_SPEED;
    motor.set(lastSet);
  }

  public void stopMotor(){
    lastSet = 0.0;
    motor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Motor Running", Math.abs(lastSet) > 0.01);
    SmartDashboard.putNumber("Motor Output", lastSet);
  }
}
