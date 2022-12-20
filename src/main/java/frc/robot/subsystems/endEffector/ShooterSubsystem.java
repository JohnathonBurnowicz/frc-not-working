package frc.robot.subsystems.endEffector;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {

    private final WPI_TalonSRX LshooterMotor;
    private final WPI_VictorSPX RshooterMotor;
   
    public ShooterSubsystem() {
        LshooterMotor = new WPI_TalonSRX(7);
        LshooterMotor.setInverted(RobotMap.EndEffector.SHOOTER_REVERSED);
        
        
        RshooterMotor = new WPI_VictorSPX(11);
        RshooterMotor.setInverted(RobotMap.EndEffector.SHOOTER_REVERSED);
        //shooterMotor.setNeutralMode(NeutralMode.Coast);
    }

  //  public void runShooter() {
  //      RshooterMotor.set(Constants.EndEffector.DEFAULT_SHOOTER_SPEED);
  //      LshooterMotor.set(Constants.EndEffector.DEFAULT_SHOOTER_SPEED);
   // }

    /**
     * Run Shooter at full speed
     */
    public void runShooter(double speed) {
        //RshooterMotor.set(speed);
        LshooterMotor.setInverted(RobotMap.EndEffector.SHOOTER_REVERSED);
       // LshooterMotor.set(speed);
       RshooterMotor.setInverted(RobotMap.EndEffector.SHOOTER_REVERSED);
    }

    /*public void runSlowShooter() {
        LshooterMotor.set(Constants.EndEffector.DEFAULT_SHOOTER_SLOW_SPEED);
        RshooterMotor.set(Constants.EndEffector.DEFAULT_SHOOTER_SLOW_SPEED);
    }

    public void reverseShooter() {
        RshooterMotor.set(-Constants.EndEffector.DEFAULT_SHOOTER_SLOW_SPEED);
        LshooterMotor.set(-Constants.EndEffector.DEFAULT_SHOOTER_SLOW_SPEED);
    }

    /**
     * Stops the shooter motor with brake mode
     */
    public void stopShooter() {
        //shooterMotor.setNeutralMode(NeutralMode.Brake);
       // LshooterMotor.setInverted(Constants.EndEffector.SHOOTER_REVERSED);
        //RshooterMotor.setInverted(Constants.EndEffector.SHOOTER_REVERSED);
        //shooterMotor.setNeutralMode(NeutralMode.Coast);
    }
}

