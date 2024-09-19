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
        public static final int BACK_LEFT_DRIVE_MOTOR_ID = -1;
        public static final int BACK_RIGHT_DRIVE_MOTOR_ID = -1;
        public static final int FRONT_LEFT_DRIVE_MOTOR_ID = -1;
        public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = -1; //TODO: ADD DRIVETRAIN IDS
        // Power Limits
        //TODO: ADD POWER LIMITS & IMPLEMENT THEM
    }

    public final class Lift {
        // IDs
        public static final int LIFT_MOTOR_ID = -1; //TODO: ADD WINCH MOTOR ID
        // Power Limits
        public static final double LIFT_MAX_PERCENT_POWER = 0.4;
    }
    

    public final class Pneumatics {
        // IDs
	    public static final int GUN_SOLENOID_ID = -1; //TODO: ADD SOLENOID ID
        public static final int PCM_ID = -1; //TODO: ADD PCM ID
        public static final int COMPRESSOR2_CONTROLLER_ID = -1; //TODO: ADD ID FOR 2nd COMPRESSOR
        // Power Limits
        public static final double MAX_SOLENOID_PERCENT = 0.1;
        public static final double MAX_SOLENOID_VOLTAGE = 12.0;
        public static final double MAX_COMPRESSOR_PERCENT = -1; //TODO: Determine proper percentage
        public static final double MAX_COMPRESSOR_VOLTAGE = -1; //TODO: Determine proper voltage
    }
}