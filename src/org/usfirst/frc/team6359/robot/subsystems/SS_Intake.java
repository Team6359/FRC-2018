package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SS_Intake extends Subsystem {

	private static Solenoid solenoidLeft;
	private static Solenoid solenoidRight;
	private static SpeedController intakeLeft;
	private static SpeedController intakeRight;
	
	private boolean rB, outtake = false, debounce = false, xDebounce = false, flippersOut = false;

	public SS_Intake() {
		solenoidLeft = new Solenoid(1);
		solenoidRight = new Solenoid(0);

		intakeLeft = new Spark(RobotMap.intakeLeft);
		intakeRight = new Spark(RobotMap.intakeRight);

		intakeRight.setInverted(true);
		intakeLeft.setInverted(true);

	}

	public void Control(boolean rB, boolean back, boolean start, boolean lB, boolean a, boolean x) {
		// if(rB){
		// Set_Position(1);
		// intakeLeft.set(1);
		// intakeRight.set(-1);
		// } else {
		// Set_Position(0);
		// intakeLeft.set(0);
		// intakeRight.set(0);
		// }

		this.rB = rB;
		// System.out.println("RB" + rB);

		if (rB) {
			intakeClose();
			if (!lB)
				intakeWheels(-0.3, -0.3);
			else
				intakeWheels(-0.6, -0.6);
		} else if (!rB && !back && !start && !lB) {
			if (!flippersOut)
				intakeOpen();
			intakeWheels(0, 0);
		}
		
		if (a && !debounce) {
			debounce = true;
			outtake = !outtake;
		}
		
		if (a) {
			Robot.dsOutput.rumble1(!outtake, outtake, 1);
		} else {
			Robot.dsOutput.rumble1(false, false, 0);
		}
		
		if (!a) {
			debounce = false;
		}
		
		if (x && !xDebounce) {
			xDebounce = true;
			flippersOut = !flippersOut;
		}
	
		if (!x)
			xDebounce = false;
		
		if (flippersOut) {
			intakeClose();
		}
			
		if (outtake && lB && !rB) {
			intakeClose();
			intakeWheels(0.4, 0.4);
		}
		
		if (lB) {
			intakeWheels(0.4, 0.4);
		}

		if (back) {
			// intakeClose();
			intakeWheels(0.2,-0);
		} else if (!rB && !start) {
			// intakeOpen();
		}

		if (start) {
			// intakeClose();
			intakeWheels(0.2, -0.2);
		} else if (back) {
			// intakeOpen();
			intakeWheels(-0.2, 0.2);
		}

	}

	public void intakeClose() {
		Set_Position(0);
		System.out.println("Intake Close");
	}

	public void intakeOpen() {
		Set_Position(1);
		System.out.println("Intake Open");
	}

	public void Set_Position(int pos) {
		// 0: open, 1: closed
		solenoidLeft.set(pos == 0);
		solenoidRight.set(pos != 0);

		SmartDashboard.putNumber("SolenoidLeft", pos);
		System.out.println(pos);
	}

	public boolean getRB() {
		return rB;
	}

	public void initDefaultCommand() {
	}

	public void intakeWheels(double speedLeft, double speedRight) {
		intakeLeft.set(speedLeft);
		intakeRight.set(speedRight);
		SmartDashboard.putNumber("Intake Speed Left", speedLeft);
		SmartDashboard.putNumber("Intake Speed Right", speedRight);
	}

}
