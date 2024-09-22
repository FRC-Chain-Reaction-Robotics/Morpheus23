package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import frc.robot.Constants;

public class Gun extends SubsystemBase
{
    VictorSPX soleSpx = new VictorSPX(Constants.Pneumatics.GUN_SOLENOID_ID);
    TalonSRX compSpx = new TalonSRX(Constants.Pneumatics.COMPRESSOR2_CONTROLLER_ID);
    PneumaticsControlModule pcm = new PneumaticsControlModule(Constants.Pneumatics.PCM_ID); //TODO: Add other motor controller powered compressor as mirroring
    
    /**
     * Creates a Gun subsystem that manages the operation and firing of the pneumatics system of Morpheus
     */
    public Gun()
    {
        compSpx.configContinuousCurrentLimit((int)Constants.Pneumatics.MAX_COMPRESSOR_CURRENT);
        compSpx.enableCurrentLimit(true);
        // Initializes the system to a closed state
        set(false);
    }
    public void set(boolean on)
    {
        soleSpx.set(VictorSPXControlMode.PercentOutput, on?Constants.Pneumatics.MAX_SOLENOID_PERCENT:0.0);
    }

    public void compressor() {
        compSpx.set(TalonSRXControlMode.PercentOutput, pcm.getCompressor()?1.0:0.0);
    }
}