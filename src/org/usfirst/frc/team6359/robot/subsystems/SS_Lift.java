package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SS_Lift extends PIDSubsystem {

	public static SpeedController leftWheelMotor, rightWheelMotor, lift1, lift2;
	public static double encVal;

	double tolerance = RobotMap.cpiLift; // 1/4 in tolerance

	boolean manual = false;

	double triggerTolerance = 0.5;
	public double autoScale = 1;

	public int liftPos = 0; // Start in drive position

	boolean debounce = false;

	public SS_Lift() {

		super("Lift", 0.002, 0.0, 0.0001);
		setAbsoluteTolerance(tolerance);
		setOutputRange(-1, 1);
		leftWheelMotor = new Spark(RobotMap.liftWheelLeft);
		rightWheelMotor = new Spark(RobotMap.liftWheelRight);
		lift1 = new Spark(RobotMap.liftMotor1);
		lift2 = new Spark(RobotMap.liftMotor2);

		leftWheelMotor.setInverted(false);
		rightWheelMotor.setInverted(true);
		lift1.setInverted(false);
		lift2.setInverted(false);

		encVal = Robot.sensors.liftEncoder(true);

		setSetpoint(0);

	}

	public void runWheels(double speedLeft, double speedRight) {
//		if ((speedLeft > 0 || speedRight > 0) && !Robot.sensors.cubeIntake()) {
//			speedLeft = 0;
//			speedRight = 0;
//		}
		leftWheelMotor.set(speedLeft);
		rightWheelMotor.set(speedRight);

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void Control(double lT, double rT, boolean lB, boolean rB, int DPad, boolean a, boolean back,
			boolean start) {
	//	Robot.bypassLimits = SmartDashboard.getBoolean("Limit Overide", false);
		

		
		// setSetpoint(0);

		if (Robot.sensors.liftLimitLow()) {
			Robot.sensors.liftEncoder(true); // Reset to zero at bottom
			setSetpoint(0);
			liftPos = 0;
			disable();
		}else {
			enable();
		}

		double inputSpeed = lT - rT;
		if (rB)
			runWheels(1, 1);
		else if (lB)
			runWheels(-1, -1);
		else
			runWheels(0, 0);

		if (back)
			runWheels(1, -0.5);
		
		if (start)
			runWheels(-0.5, 1);

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

		boolean up = DPad == 0;
		boolean right = DPad == 90;
		boolean down = DPad == 180;
		boolean left = DPad == 270;

		SmartDashboard.putNumber("DPad", DPad);
		if (up && !debounce) {
			increment();
			System.out.println("INCREMENT");
		} else if (down && !debounce) {
			decrement();
			System.out.println("DECREMENT");
		} else if (right && !debounce) {
			liftPos = 4;
			liftTo(4);
		} else if (left && !debounce) {
			liftPos = 0;
			liftTo(0);
		}

		debounce = up || down;

		System.out.println("ENC: " + encVal);
		Robot.sensors.liftEncoder(false);
		Robot.sensors.cubeIntake();

		

	}
	
	public void resetEnc() {
		Robot.sensors.liftEncoder(true);
	}

	public void Lift(double speed) {

		boolean liftLimitHigh = Robot.sensors.liftLimitHigh();
		boolean liftLimitLow = Robot.sensors.liftLimitLow();
		encVal = Robot.sensors.liftEncoder(false);
		if (Robot.bypassLimits) {
			liftLimitHigh = false;
			liftLimitLow = false;
		}

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

		if (getPIDController().isEnabled()) {
			if (getSetpoint() <= encVal) {
				// Going up
				getPIDController().setPID(0.001, 0.0, 0.000);
			} else {
				// Going down
				getPIDController().setPID(0.001, 0.0, 0.001);
			}
		}
		
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
		Lift(output * autoScale);
		Lift(output * autoScale);
		SmartDashboard.putNumber("PID ", output);
		SmartDashboard.putNumber("Setpoint", getSetpoint());
	}
}