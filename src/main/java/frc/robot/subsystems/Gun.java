package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gun extends SubsystemBase
{
    Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.GUN_SOLENOID_ID);
    
    public Gun()
    {
        set(false);
    }

    public void set(boolean on)
    {
        solenoid.set(on);
    }
}