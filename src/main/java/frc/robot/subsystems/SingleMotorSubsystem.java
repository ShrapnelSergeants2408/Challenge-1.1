package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SingleMotorSubsystem extends SubsystemBase
 {
    private final WPI_TalonSRX motor;
    public SingleMotorSubsystem(){
        motor = new WPI_TalonSRX(Constants.TEST_BED_FRONT_LEFT_CAN_ID);
        motor.setNeutralMode(NeutralMode.Brake);
    }

    public void startMotor(){
        motor.set(0.5);
    }
    public void stopMotor() {
        motor.set(0.0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putBoolean("Motor Running", Math.abs(motor.get()) > 0.01);
        
    }
 }