package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase
{
    VictorSPX liftMotor = new VictorSPX(Constants.Lift.LIFT_MOTOR_ID);

    public Lift()
    {
        liftMotor.setInverted(true);
    }
    
    /**
     * Allows for control of the power of the motor based on a [-1, 1] scale
     */
    public void set(double power) {
        // Filters out large power values and scales power based on LIFT_MAX_PERCENT_POWER, allowing for a joystick or other double input to be logged
        if (power > 1) 
            power = Constants.Lift.LIFT_MAX_PERCENT_POWER;
        else if (power < -1) 
            power = Constants.Lift.LIFT_MAX_PERCENT_POWER;
        else 
            power *= Constants.Lift.LIFT_MAX_PERCENT_POWER;
        liftMotor.set(VictorSPXControlMode.PercentOutput, power);
    }
}
