package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.RobotMap;
import org.usfirst.frc.team6359.robot.commands.CMD_LiftDecrement;
import org.usfirst.frc.team6359.robot.commands.CMD_LiftIncrement;
import org.usfirst.frc.team6359.robot.commands.CMD_LiftIntake;
import org.usfirst.frc.team6359.robot.commands.CMD_LiftOuttake;
import org.usfirst.frc.team6359.robot.commands.CMD_LiftTo;
import org.usfirst.frc.team6359.robot.commands.CMD_LiftWheelsStop;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class SS_Lift extends PIDSubsystem {

	public static SpeedController leftWheelMotor, rightWheelMotor, lift1, lift2;
	public static Encoder enc;

	double tolerance = RobotMap.cpiLift / 4; // 1/4 in tolerance

	boolean manual = false;

	double triggerTolerance = 0.1;

	public static int liftPos = 1; // Start in drive position

	boolean debounce = false;

	public SS_Lift() {

		super("Lift", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(tolerance);

		leftWheelMotor = new Victor(RobotMap.liftWheelLeft);
		rightWheelMotor = new Victor(RobotMap.liftWheelRight);
		lift1 = new Victor(RobotMap.liftMotor1);
		lift2 = new Victor(RobotMap.liftMotor2);

		leftWheelMotor.setInverted(false);
		rightWheelMotor.setInverted(true);
		lift1.setInverted(false);
		lift2.setInverted(false);

	}

	public void RunWheels(double speed) {
		leftWheelMotor.set(speed);
		rightWheelMotor.set(speed);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void Control(double lT, double rT, boolean lB, boolean rB, boolean up, boolean down) {
		double inputSpeed = rT - lT;
		if (rB)
			new CMD_LiftIntake();
		else if (lB)
			new CMD_LiftOuttake();
		else
			new CMD_LiftWheelsStop();

		if (Math.abs(inputSpeed) <= triggerTolerance) {
			enable();
			if (manual)
				setSetpoint(enc.getRaw());
		} else {
			disable();
		}

		manual = Math.abs(inputSpeed) > triggerTolerance;

		if (manual)
			Lift(inputSpeed);

		if (up && !debounce) {
			new CMD_LiftIncrement();
		} else if (down && !debounce) {
			new CMD_LiftDecrement();
		}

		debounce = up || down;

	}

	public void Lift(double speed) {
		lift1.set(speed);
		lift2.set(speed);
	}

	public void increment() {
		if (liftPos < 5)
			new CMD_LiftTo(++liftPos);
	}

	public void decrement() {
		if (liftPos > 0) {
			new CMD_LiftTo(--liftPos);
		}
	}

	protected double returnPIDInput() {
		return enc.getRaw();
	}

	protected void usePIDOutput(double output) {
		lift1.set(output);
		lift2.set(output);
	}
}
