package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.SingleMotorSubsystem;

public class StopMotorCommand extends InstantCommand {
    public StopMotorCommand(SingleMotorSubsystem subsystem){
        super(subsystem::stopMotor, subsystem); 
        addRequirements(subsystem);
    }
}
