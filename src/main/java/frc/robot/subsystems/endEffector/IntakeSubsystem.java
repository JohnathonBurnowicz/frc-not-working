package frc.robot.subsystems.endEffector;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {

    private WPI_TalonSRX intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new WPI_TalonSRX(RobotMap.EndEffector.INTAKE_MOTOR_PORT);
        intakeMotor.setInverted(RobotMap.EndEffector.INTAKE_REVERSED);
        // Intake will not brake stop, it will coast to a stop
        intakeMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void runIntake(double speed) {
        intakeMotor.set(speed);
    }

    public void runIntake() {
        intakeMotor.set(RobotMap.EndEffector.DEFAULT_INTAKE_SPEED);
    }

    public void reverseIntake() {
        intakeMotor.set(RobotMap.EndEffector.DEFAULT_INTAKE_REVERSE_SPEED);
    }

    /**
     * Stops the intake motor with coast mode
     */
    public void stopIntake() {
        intakeMotor.set(0);
    }
}

