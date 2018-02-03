package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_Sensors extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Encoder encRight = new Encoder(RobotMap.rEncoder1, RobotMap.rEncoder2, true);
	Encoder encLeft = new Encoder(RobotMap.lEncoder1, RobotMap.lEncoder2, true);

	ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public SS_Sensors() {
	}

	public double rightEncoder(boolean reset) {

		if (reset) {
			encRight.reset();
		} else {
		}

		return encRight.getRaw();
	}

	public double leftEncoder(boolean reset) {

		if (reset) {
			encLeft.reset();
		} else {
		}

		return encLeft.getRaw();
	}
	
	public Encoder getEncRight(){
		return encRight;
	}
	
	public Encoder getEncLeft(){
		return encLeft;
	}

/*	public double gyro(boolean reset) {

		if (reset) {
			gyro.reset();
		} else {
		}

		return gyro.getAngle();
	
	}
	*/
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
