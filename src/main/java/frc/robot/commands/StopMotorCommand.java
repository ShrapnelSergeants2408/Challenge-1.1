package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.MotorSubsystem;

public class StopMotorCommand extends InstantCommand {
    public StopMotorCommand(MotorSubsystem subsystem){
        super(subsystem::stopMotor,subsystem);
    }
}
