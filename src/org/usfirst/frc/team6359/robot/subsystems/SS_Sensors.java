package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_Sensors extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	//Encoder encRight = new Encoder(RobotMap.rEncoder1, RobotMap.rEncoder2, true);
	//Encoder encLeft = new Encoder(RobotMap.lEncoder1, RobotMap.lEncoder2, true);
	Encoder encLift;
	DigitalInput limitSwitchHigh;
	DigitalInput limitSwitchLow;
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public SS_Sensors() {
		encLift  = new Encoder(1, 0, false, Encoder.EncodingType.k4X);
		limitSwitchHigh = new DigitalInput(4);
		limitSwitchLow = new DigitalInput(5);
	}
//	public double rightEncoder(boolean reset) {
//		if (reset) {
//			encRight.reset();
//		}
//		return encRight.getRaw();
//	}
//
//	public double leftEncoder(boolean reset) {
//		if (reset) {
//			encLeft.reset();
//		}
//		return encLeft.getRaw();
//	}
//	
	public double liftEncoder(boolean reset) {
		if (reset) {
			encLift.reset();
		}
		System.out.println("ENC: " + encLift.getRaw());
		return encLift.getRaw();
	}

	public boolean liftLimitHigh() {
	//	System.out.println("LIMIT SWITCH HIGH: " + limitSwitchHigh.get());
		return !limitSwitchHigh.get();
	}
	
	public boolean liftLimitLow() {
	//	System.out.println("LIMIT SWITCH LOW: " + limitSwitchLow.get());
		return !limitSwitchLow.get();
	}
	public double gyro(boolean reset) {
		if (reset) {
			gyro.reset();
		}
		return gyro.getAngle();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
