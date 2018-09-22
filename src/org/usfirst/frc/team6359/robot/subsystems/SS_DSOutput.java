package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.OI;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SS_DSOutput extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void rumble1(boolean right, boolean left, double amplitude) {

		RumbleType rightSide, leftSide;
		rightSide = GenericHID.RumbleType.kRightRumble;
		leftSide = GenericHID.RumbleType.kLeftRumble;

		if (right) {
			OI.controller1.setRumble(rightSide, amplitude);
		} else {
			OI.controller1.setRumble(rightSide, 0);
		}

		if (left) {
			OI.controller1.setRumble(leftSide, amplitude);
		} else {
			OI.controller1.setRumble(leftSide, 0);
		}

	}

	public void rumble2(boolean right, boolean left, double amplitude) {

		RumbleType rightSide, leftSide;
		rightSide = GenericHID.RumbleType.kRightRumble;
		leftSide = GenericHID.RumbleType.kLeftRumble;

		if (right) {
			OI.joystick.setRumble(rightSide, amplitude);
		} else {
			OI.joystick.setRumble(rightSide, 0);
		}

		if (left) {
			OI.joystick.setRumble(leftSide, amplitude);
		} else {
			OI.joystick.setRumble(leftSide, 0);
		}
	}

	public void gear(int gear, double gearVal, String gearNumber) {

		SmartDashboard.putString(null, gearNumber);

		/*
		 * System.out.println("gearVal: " + gearVal);
		 * System.out.println("gearNumber: " + gearNumber);
		 * System.out.println("gear: " + gear);
		 */
	}
}
