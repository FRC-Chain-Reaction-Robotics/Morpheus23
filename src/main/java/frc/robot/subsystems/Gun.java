package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import frc.robot.Constants;

public class Gun extends SubsystemBase
{
    VictorSPX soleSpx = new VictorSPX(Constants.Pneumatics.GUN_SOLENOID_ID);
    VictorSPX compSpx = new VictorSPX(Constants.Pneumatics.COMPRESSOR2_CONTROLLER_ID);
    PneumaticsControlModule pcm = new PneumaticsControlModule(Constants.Pneumatics.PCM_ID); //TODO: Add other motor controller powered compressor as mirroring
    
    /**
     * Creates a Gun subsystem that manages the operation and firing of the pneumatics system of Morpheus
     */
    public Gun()
    {
        // Initializes the system to a closed state
        set(false);
        // Second compressor run by RunCommand, which constantly excecutes, mirroring the state of the other compressor
        new RunCommand(() -> {
            if (pcm.getCompressor()) compSpx.set(VictorSPXControlMode.PercentOutput, Constants.Pneumatics.MAX_COMPRESSOR_PERCENT);
            else compSpx.set(VictorSPXControlMode.PercentOutput, 0);
        });
    }

    public void set(boolean on)
    {
        soleSpx.set(VictorSPXControlMode.PercentOutput, on?Constants.Pneumatics.MAX_SOLENOID_PERCENT:0.0);
    }
}