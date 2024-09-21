// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    
    // All motor controller IDs
    

    public final class Drive {
        // IDs
        public static final int BACK_LEFT_ID = 6;
        public static final int BACK_RIGHT_ID = 8;
        public static final int FRONT_LEFT_ID = 5;
        public static final int FRONT_RIGHT_ID = 7;
        // Power Limits
        public static final double POWER_MODIFIER = 0.60;
        public static final double SECONDS_TO_RAMP = 2;
    }

    public final class Lift {
        // IDs
        public static final int LIFT_MOTOR_ID = 1;
        // Power Limits
        public static final double LIFT_MAX_PERCENT_POWER = 0.4;
        public static final double SECONDS_TO_RAMP = 2;
    }
    

    public final class Pneumatics {
        // IDs
	    public static final int GUN_SOLENOID_ID = 4;
        public static final int PCM_ID = 0;
        public static final int COMPRESSOR2_CONTROLLER_ID = 3;
        // Power Limits
        public static final double MAX_SOLENOID_PERCENT = 0.8;
        public static final double MAX_COMPRESSOR_CURRENT = 16;
    }
}