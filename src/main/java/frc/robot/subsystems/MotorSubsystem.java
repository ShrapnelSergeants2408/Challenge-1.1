package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// challenge code
public class MotorSubsystem extends SubsystemBase {
    // private static final int id = 20;
    private final WPI_TalonSRX motor; // 20 = ID
    public MotorSubsystem(){
        motor =  new WPI_TalonSRX(20); // 20 = ID
        motor.setNeutralMode(NeutralMode.Brake);
    }
    public void startMotor() { motor.set(0.5);}
    public void stopMotor(){motor.set(0.0);}
    
    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Motor Running",Math.abs(motor.get()) > 0.01);
    }
}

