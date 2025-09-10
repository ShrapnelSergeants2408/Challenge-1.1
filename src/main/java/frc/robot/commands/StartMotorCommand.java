package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.MotorSubsystem;

public class StartMotorCommand extends InstantCommand {
    public StartMotorCommand(MotorSubsystem subsystem){
        super(subsystem::startMotor, subsystem);
    }
}
