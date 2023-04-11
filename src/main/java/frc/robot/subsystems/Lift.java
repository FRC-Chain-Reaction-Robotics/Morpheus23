package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase
{
    WPI_TalonSRX liftMotor = new WPI_TalonSRX(Constants.LIFT_MOTOR_ID);

    public Lift()
    {
        liftMotor.setInverted(true);
    }
    
    public void set(double power) {
        liftMotor.set(power);
    }
}
