package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SS_Lift extends PIDSubsystem {

	public static SpeedController leftWheelMotor, rightWheelMotor, lift1, lift2;
	public static double encVal;

	double tolerance = RobotMap.cpiLift * 3; // 1/4 in tolerance

	boolean manual = false;

	double triggerTolerance = 0.1;

	public static int liftPos = 1; // Start in drive position

	boolean debounce = false;

	public SS_Lift() {

		super("Lift", 0.00005, 0.0, 0.0000);
		setAbsoluteTolerance(tolerance);
		setOutputRange(-1, 1);
		setInputRange(-51219.0, 0);
		leftWheelMotor = new Victor(RobotMap.liftWheelLeft);
		rightWheelMotor = new Victor(RobotMap.liftWheelRight);
		lift1 = new Spark(RobotMap.liftMotor1);
		lift2 = new Spark(RobotMap.liftMotor2);

		leftWheelMotor.setInverted(false);
		rightWheelMotor.setInverted(true);
		lift1.setInverted(false);
		lift2.setInverted(false);

		encVal = Robot.sensors.liftEncoder(true);

		setSetpoint(0);

	}

	public void runWheels(double speed) {
		if (speed < 0 && !Robot.sensors.cubeIntake()) {
			speed = 0;
		}
		leftWheelMotor.set(speed);
		rightWheelMotor.set(speed);

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void Control(double lT, double rT, boolean lB, boolean rB, int DPad, boolean a) {

		encVal = Robot.sensors.liftEncoder(false);
	//	setSetpoint(0);

		double inputSpeed = lT - rT;
		if (rB)
			runWheels(-1);
		else if (lB)
			runWheels(1);
		else
			runWheels(0);

		if (Math.abs(inputSpeed) <= triggerTolerance) {
			enable();
			if (manual)
				setSetpoint(encVal);
		} else {
			disable();
		}

			manual = Math.abs(inputSpeed) > triggerTolerance;
	
			if (manual)
				Lift(inputSpeed);
			else
				Lift(0);
			
		boolean up = DPad == 0;
		boolean down = DPad == 180;
		
		SmartDashboard.putNumber("DPad", DPad);
		if (up && !debounce) {
			increment();
			System.out.println("INCREMENT");
		} else if (down && !debounce) {
			decrement();
			System.out.println("DECREMENT");
		}

		debounce = up || down;

		System.out.println("ENC: " + encVal);
		Robot.sensors.liftEncoder(false);
		Robot.sensors.cubeIntake();

	}

	public void Lift(double speed) {

		boolean liftLimitHigh = Robot.sensors.liftLimitHigh();
		boolean liftLimitLow = Robot.sensors.liftLimitLow();

		if (speed == 0) {
			lift1.set(0);
			lift2.set(0);

		}
		
		if (speed < 0 && !liftLimitHigh) {
			lift1.set(speed * 0.8);
			lift2.set(speed * 0.8);
		} else if (speed < 0) {
			lift1.set(0);
			lift2.set(0);
		}

		if (speed > 0 && !liftLimitLow) {
			lift1.set(speed * 0.65);
			lift2.set(speed * 0.65);
		} else if (speed > 0) {
			lift1.set(0);
			lift2.set(0);
		}

		// System.out.println("LOW " + liftLimitLow);
		// System.out.println("HIGH " + liftLimitHigh);

		SmartDashboard.putNumber("Lift Speed", speed);
		SmartDashboard.putNumber("Lift Enc", encVal);

	}

	public void increment() {
		if (liftPos < 5)
			liftTo(++liftPos);
	}

	public void decrement() {
		if (liftPos > 0) {
			liftTo(--liftPos);
		}
	}

	public void liftTo(int index) {
		SmartDashboard.putNumber("Index", index);
		switch (index) {
		case 0:
			setSetpoint(RobotMap.liftSetPointFloor);
			break;
		case 1:
			setSetpoint(RobotMap.liftSetPointDrive);
			break;
		case 2:
			setSetpoint(RobotMap.liftSetPointSwitch);
			break;
		case 3:
			setSetpoint(RobotMap.liftSetPointScaleLow);
			break;
		case 4:
			setSetpoint(RobotMap.liftSetPointScaleNeutral);
			break;
		case 5:
			setSetpoint(RobotMap.liftSetPointScaleHigh);
			break;
		}
	}

	protected double returnPIDInput() {
		return encVal;
	}

	protected void usePIDOutput(double output) {
		//lift1.set(output);
		//lift2.set(output);
		SmartDashboard.putNumber("PID ", output);
		SmartDashboard.putNumber("Setpoint", getSetpoint());
	}
}
