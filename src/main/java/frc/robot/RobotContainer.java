// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.subsystems.*;

//test update

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	Lift atlas = new Lift();
	Gun gun = new Gun();
	TankDrive drive = new TankDrive();

	CommandXboxController controller = new CommandXboxController(0);

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		configureButtonBindings();
	}

	// /**
	//  * Use this method to define your button->command mappings. Buttons can be
	//  * created by instantiating a {@link GenericHID} or one of its subclasses
	//  * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
	//  * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	//  */
	private void configureButtonBindings() {
		// Cache Trigger Objects here so that factory methods are not called every loop (avoids loop overrun)
		Trigger povUpTrigger = controller.povUp();
		Trigger povDownTrigger = controller.povDown();
		Trigger povCenterTrigger = controller.povCenter();

		gun.setDefaultCommand(new RunCommand(() -> gun.compressor(), gun));

		drive.setDefaultCommand(new RunCommand(() -> {
			drive.drive(controller.getLeftY(), controller.getRightY());
		}, drive));

		povUpTrigger.onTrue(new InstantCommand(() -> atlas.set(1))); // Powers lift to go up if pov is up
		povDownTrigger.onTrue(new InstantCommand(() -> atlas.set(-1))); // Powers lift to go down if pov is down
		povCenterTrigger.onTrue(new InstantCommand(() -> atlas.set(0))); // Sets power to 0 if neither up or down is active

		controller.a()
			.onTrue(new InstantCommand(() -> gun.set(true), gun))
			.onFalse(new InstantCommand(() -> gun.set(false), gun));

		controller.b()
			.onTrue(new InstantCommand(() -> gun.toggleCompressor()));
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// An ExampleCommand will run in autonomous
		return null;
	}
}
