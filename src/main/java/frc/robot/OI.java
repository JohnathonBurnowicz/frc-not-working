// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.sql.Driver;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.auto.AutoSequenceCommandGroup;
import frc.robot.controllers.DriverController;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.subsystems.drive.DiffDriveSubsystem;
import frc.robot.subsystems.endEffector.IntakeHeightSubsystem;
import frc.robot.subsystems.endEffector.IntakeSubsystem;
import frc.robot.subsystems.endEffector.ShooterSubsystem;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class OI


{
    private final static OI INSTANCE = new OI();
    private static final GenericHID DriverControllerPort = null;

    /**
     * Returns the Singleton instance of this RobotContainer. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class.
     */
    @SuppressWarnings("WeakerAccess")
    public static OI getInstance() {
        return INSTANCE;
    }
    // The robot's subsystems and commands are defined here...

    public final DiffDriveSubsystem diffDriveSubsystem = new DiffDriveSubsystem();
    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    private final Command autoCommand = new DriveCommand(diffDriveSubsystem); 
    private final DriveCommand driveCommand = new DriveCommand(diffDriveSubsystem);
    private final  Pneumatics pneumaticsCommand = new Pneumatics();

    //private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
    //private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    //private final IntakeHeightSubsystem intakeHeightSubsystem = new IntakeHeightSubsystem();
    //private final Command autoCommand = new AutoSequenceCommandGroup(diffDriveSubsystem, intakeSubsystem, shooterSubsystem);
    //private final ClimbCommand climbCommand = new ClimbCommand(climberSubsystem);
   // private final LimelightVisionSubsystem LimelightVisionSubsystem = new PhotonVisionSubsystem();
    //private final HomingCommand homingCommand = new HomingCommand(photonVisionSubsystem, diffDriveSubsystem);
    //private final homing2 homing2 = new homing2(diffDriveSubsystem, photonVisionSubsystem);


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    OI()
    {
     //   Public enum OperatorMode{OPERATE, LOG};
     //   private final XboxController driver = new XboxController(DRIVER);
     //   private final XboxController operator = new XboxController(OPERATOR);
        // Configure the button bindings
        configureButtonBindings();
        
        diffDriveSubsystem.setDefaultCommand(driveCommand);
       //*NEW frc.robot.subsystems.PneumaticSubsystem.ReverseSolenoid(5, true);
       // *NEW frc.robot.subsystems.PneumaticSubsystem.ForwardSolenoid(4, true);
       //***Berk*** PneumaticSubsystem.setDefaultCommand((Command) PneumaticSubsystem);
    
        //climberSubsystem.setDefaultCommand(climbCommand);
    }
    
    
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        // Add button to command mappings here.
        // See https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html

        //JoystickButton driveXbutton = new JoystickButton(getDriverJoystick(), XboxController.Button.kX.value);
        //driveXbutton.whileHeld(new homing2(diffDriveSubsystem, photonVisionSubsystem));

        // While A is held, run only Intake slowly
      /*  JoystickButton opAButton = new JoystickButton(getOperatorJoystick(), XboxController.Button.kA.value);
        opAButton.whileActiveContinuous(new IntakeOneCommand(intakeSubsystem));
        */

        //JoystickButton driveXbutton = new JoystickButton(getDriverJoystick(),XboxController.Button.kX.value);
        //driveXbutton.whileHeld(new PneumaticCommand());
        JoystickButton driverAButton = new JoystickButton(DriverControllerPort, RobotMap.BUTTON_A);
        driverAButton.whenPressed((Command) new PneumaticsUp());
        //JoystickButton opAButton = new JoystickButton(getOperatorJoystick(), XboxController.Button.kA.value);
        JoystickButton driverBButton = new JoystickButton(DriverControllerPort, RobotMap.BUTTON_B);
        driverBButton.whenPressed((Command) new PneumaticsDown());
       ///opAButton.whileActiveContinuous(new PneumaticSubsystem(intakeSubsystem));
        // While A and X are held, run Intake and Shooter slowly
        //JoystickButton opXButton = new JoystickButton(getOperatorJoystick(), XboxController.Button.kX.value);
        
        JoystickButton opLeftAxis = new JoystickButton(getOperatorJoystick(), XboxController.Axis.kLeftTrigger.value);
        JoystickButton opRightAxis = new JoystickButton(getOperatorJoystick(), XboxController.Axis.kRightTrigger.value);
       
        //opXButton.and(opAButton).whileActiveContinuous(new IntakeCommand(intakeSubsystem, shooterSubsystem));

        // While B is held, run Intake and Shooter slowly in reverse
        JoystickButton opBButton = new JoystickButton(getOperatorJoystick(), XboxController.Button.kB.value);
        //opBButton.whenPressed((Command) new PneumaticSubsystem());
        //opBButton.whileHeld(new ReverseIntakeCommand(intakeSubsystem, shooterSubsystem));

        // While X is held and A is not, run Shooter at full speed
        

        // When the right bumper is pressed, jerk the robot
    //  JoystickButton opRightBumper = new JoystickButton(getDriverJoystick(), XboxController.Button.kRightBumper.value);
    //  opRightBumper.whenPressed(new JerkFwdCommand(diffDriveSubsystem).withTimeout(0.055));
        
       // JoystickButton driveAbutton = new JoystickButton(getDriverJoystick(), XboxController.Button.kA.value);
        //JoystickButton driveBbutton = new JoystickButton(getDriverJoystick(), XboxController.Button.kB.value);
        // driveAbutton.whenPressed(new PneumaticsCommand())
   
        //driveAbutton.whileActiveContinuous(new IntakeHeightDownCommand(intakeHeightSubsystem));
        //driveBbutton.whileActiveContinuous(new IntakeHeightUpCommand(intakeHeightSubsystem));

        JoystickButton opLeftBumper = new JoystickButton(getOperatorJoystick(), XboxController.Button.kLeftBumper.value);
        //opLeftBumper.whenPressed(new setSolenoid(PneumaticSubsystem).withTimeout(0.09));
        //opLeftBumper.whenPressed(new IntakeOneCommand(intakeSubsystem, true).withTimeout(1.0));

        JoystickButton opStart = new JoystickButton(getOperatorJoystick(), XboxController.Button.kStart.value);
        JoystickButton opBack = new JoystickButton(getOperatorJoystick(), XboxController.Button.kBack.value);

//Shooter Code

// When left trigger is pressed left shooter motor spin
opLeftAxis.whenActive(new ShooterCommand(shooterSubsystem));

// When right trigger is pressed right shooter motor spin
opRightAxis.whenActive(new ShooterCommand(shooterSubsystem));

        //opStart.whileActiveContinuous(new ClimbUpCommand(climberSubsystem));
        //opBack.whileActiveContinuous(new ClimbDownCommand(climberSubsystem));
   
        
    }
XboxController DriverController = new XboxController(RobotMap.BUTTON_A);

    public XboxController getDriverJoystick() {
        return new XboxController(0);
    }


    public XboxController getOperatorJoystick() {
        return new XboxController(1);
    }
    
    public boolean GetDriverAButton(){
        return DriverController.getAButton();
    }
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        return autoCommand;
    }

    public Command getTeleopCommand() {
        return driveCommand;
    
    }
}

    
    

