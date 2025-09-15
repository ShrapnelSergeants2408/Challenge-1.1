package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.SingleMotorSubsystem;

public class StartMotorCommand extends InstantCommand {
    public StartMotorCommand(SingleMotorSubsystem subsystem){
        super(subsystem::startMotor, subsystem); 
        addRequirements(subsystem);
    }
}
