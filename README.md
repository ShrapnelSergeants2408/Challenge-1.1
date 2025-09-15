# Challenge 1.1: Two Button Motor Start/Stop

**Category**: Single Motor Velocity Control

## Robot Base
- **Required Robot**: Any

## Overview
This foundational challenge introduces students to basic motor control using discrete button inputs. Learning to start and stop a motor with separate buttons teaches the fundamentals of command-based programming, subsystem creation, and controller input handling. This simple interaction pattern is the building block for more complex robot behaviors and helps students understand the relationship between user input and actuator response.

## Challenge Description
Create a subsystem that controls a single motor using two separate buttons on a controller. One button should start the motor at a fixed speed when pressed, and a different button should stop the motor when pressed. The motor should continue running until the stop button is pressed, demonstrating latched behavior rather than momentary control.

## Required Hardware

### Competition Robot (Swerve Drive)
- **Motor**: Any available motor (suggest using Coral Subsystem Motor: CAN ID 62)
- **Controller**: Xbox Controller (Port: 0)

### Testbed Robot (Differential Drive)
- **Motor**: Front Left TalonSRX (CAN ID: 20)
- **Controller**: Xbox Controller (Port: 0)

## Implementation Steps
1. Create a new Subsystem class for motor control
2. Add a motor controller instance variable using the appropriate type for your robot
3. Initialize the motor controller in the constructor with proper configuration
4. Create public methods for starting and stopping the motor
5. Create Command classes for start and stop actions
6. Register the subsystem in RobotContainer and bind buttons to commands
7. Add telemetry to display motor status on SmartDashboard

## Success Criteria
- Pressing the start button begins motor operation at a consistent speed
- Motor continues running after the start button is released
- Pressing the stop button immediately stops motor operation
- Motor remains stopped after the stop button is released
- Only one button press is required for each action (no holding required)
- Motor status is displayed on SmartDashboard

## Hints and Troubleshooting
- **For Step 1**: Create a new Java class in the `subsystems` package that extends `SubsystemBase`. Name it something descriptive like `SingleMotorSubsystem`. Use the template: `public class SingleMotorSubsystem extends SubsystemBase { }`
- **For Step 2**: For Competition robot with brushless motor, use `private final CANSparkMax motor;`. For Testbed robot, use `private final WPI_TalonSRX motor;`. Import the correct libraries: `import com.revrobotics.CANSparkMax;` or `import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;`
- **For Step 3**: In the constructor, initialize your motor with the correct CAN ID. Competition example: `motor = new CANSparkMax(62, MotorType.kBrushless);`. Testbed example: `motor = new WPI_TalonSRX(20);`. Set brake mode: `motor.setIdleMode(IdleMode.kBrake);` for SparkMax or `motor.setNeutralMode(NeutralMode.Brake);` for TalonSRX.
- **For Step 4**: Create methods like `public void startMotor() { motor.set(0.5); }` and `public void stopMotor() { motor.set(0.0); }`. Choose an appropriate speed value between 0.0 and 1.0.
- **For Step 5**: Create command classes that extend `InstantCommand`. Example: `public class StartMotorCommand extends InstantCommand { public StartMotorCommand(SingleMotorSubsystem subsystem) { super(subsystem::startMotor, subsystem); } }`
- **For Step 6**: In RobotContainer.java, create an instance of your subsystem in the class variables. In `configureBindings()`, use `driverController.a().onTrue(new StartMotorCommand(motorSubsystem));` and `driverController.b().onTrue(new StopMotorCommand(motorSubsystem));`
- **For Step 7**: Override the `periodic()` method in your subsystem and add `SmartDashboard.putBoolean("Motor Running", Math.abs(motor.get()) > 0.01);`
- **Common Issue**: If commands don't execute, ensure you've called `addRequirements(subsystem)` in your command constructor or used the subsystem parameter in InstantCommand.
- **Common Issue**: If the motor doesn't respond, verify CAN IDs match your robot's configuration and check for error messages in the Driver Station.

## Challenge Extensions
- **Speed Control**: Add multiple start buttons that run the motor at different speeds (25%, 50%, 75%, 100%).
- **Direction Control**: Add separate buttons for forward and reverse operation.
- **Safety Timeout**: Add automatic motor shutoff after 10 seconds of operation.
- **Status Indicators**: Use different colored LEDs or dashboard indicators to show motor state.
- **Emergency Stop**: Add a button that stops the motor and prevents restart until a reset button is pressed.

## Learning Resources
- [WPILib Documentation: Command-Based Programming](https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html)
- [WPILib Documentation: Motors and Motor Controllers](https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/index.html)
- [WPILib Documentation: Basic Commands](https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html)
- [REV SparkMax Documentation](https://docs.revrobotics.com/sparkmax/software-resources/spark-max-api-information)
- [CTRE TalonSRX Documentation](https://docs.ctre-phoenix.com/en/stable/ch13_MC.html)
- [WPILib Example: Motor Control](https://github.com/wpilibsuite/allwpilib/tree/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/motorcontrol)
- [FRC Programming Basics Video Series](https://www.youtube.com/playlist?list=PLmg6C4RB0Ncz3O8BFtqK8B4Q9g5-tD5D5)
- [Chief Delphi Programming Forum](https://www.chiefdelphi.com/c/technical/programming/11)