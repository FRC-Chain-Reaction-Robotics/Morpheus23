// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  TalonSRX frontRight_SPX = new TalonSRX(Constants.Drive.FRONT_RIGHT_ID);
  TalonSRX frontLeft_SPX = new TalonSRX(Constants.Drive.FRONT_LEFT_ID);
  TalonSRX backRight_SPX = new TalonSRX(Constants.Drive.BACK_RIGHT_ID);
  TalonSRX backLeft_SPX = new TalonSRX(Constants.Drive.BACK_LEFT_ID);
  DifferentialDrive drive;

  public TankDrive() {
    frontLeft_SPX.setInverted(true);
    backLeft_SPX.setInverted(true);
    frontLeft_SPX.configOpenloopRamp(Constants.Drive.SECONDS_TO_RAMP);
    frontRight_SPX.configOpenloopRamp(Constants.Drive.SECONDS_TO_RAMP);
    backLeft_SPX.configOpenloopRamp(Constants.Drive.SECONDS_TO_RAMP);
    backRight_SPX.configOpenloopRamp(Constants.Drive.SECONDS_TO_RAMP);
    drive = new DifferentialDrive(
      (double power) -> {
        frontLeft_SPX.set(TalonSRXControlMode.PercentOutput, power);
        backLeft_SPX.set(TalonSRXControlMode.PercentOutput, power);
      }, (double power) -> {
        frontRight_SPX.set(TalonSRXControlMode.PercentOutput, power);
        backRight_SPX.set(TalonSRXControlMode.PercentOutput, power);
      });

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive (double powerLeft, double powerRight) {
    drive.tankDrive(powerLeft*Constants.Drive.POWER_MODIFIER, powerRight*Constants.Drive.POWER_MODIFIER);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
