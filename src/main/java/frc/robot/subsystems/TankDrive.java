// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  VictorSPX frontRight_SPX = new VictorSPX(Constants.Drive.FRONT_RIGHT_ID);
  VictorSPX frontLeft_SPX = new VictorSPX(Constants.Drive.FRONT_LEFT_ID);
  VictorSPX backRight_SPX = new VictorSPX(Constants.Drive.BACK_RIGHT_ID);
  VictorSPX backLeft_SPX = new VictorSPX(Constants.Drive.BACK_LEFT_ID);
  DifferentialDrive drive;

  public TankDrive() {
    drive = new DifferentialDrive(
      (double power) -> {
        frontLeft_SPX.set(VictorSPXControlMode.PercentOutput, power);
        backLeft_SPX.set(VictorSPXControlMode.PercentOutput, power);
      }, (double power) -> {
        frontRight_SPX.set(VictorSPXControlMode.PercentOutput, power);
        backRight_SPX.set(VictorSPXControlMode.PercentOutput, power);
      });

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive (double powerLeft, double powerRight) {
    drive.tankDrive(powerLeft, powerRight);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
