package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.RobotMap;
import org.usfirst.frc.team6359.robot.commands.MoveController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SS_DriveTrain extends Subsystem {

	int gear;
	double gearVal;
	String gearNumber;

	double x, y, strafe, leftSpeed, rightSpeed, strafeSpeed = 0, strafeSetPoint, error;

	public static SpeedController FL, FR, H1;
	public static VictorSPX CL, BL, CR, BR;

	double pTurnScl = 0.5;

	double lEncoder;
	double rEncoder;

	double curSpeedLeft = 0;
	double curSpeedRight = 0;

	public boolean autoRunning = false;

	public SS_DriveTrain() {

		FL = new Victor(RobotMap.FL);
		FR = new Victor(RobotMap.FR);
		H1 = new Victor(RobotMap.H1);
		BR = new VictorSPX(RobotMap.BR);
		CR = new VictorSPX(RobotMap.CR);
		BL = new VictorSPX(RobotMap.BL);
		CL = new VictorSPX(RobotMap.CL);

		System.out.println("DriveTrain");

		FR.setInverted(true);
		CR.setInverted(true);
		BR.setInverted(true);
		FL.setInverted(false);
		CL.setInverted(false);
		BL.setInverted(false);
		H1.setInverted(false);

		// lEncoder = Robot.sensors.leftEncoder(true);
		// rEncoder = Robot.sensors.rightEncoder(true);

	}

	public void ControllerDrive(double leftXAxis, double leftYAxis, double rightXAxis, double rightYAxis) {
		// cubes joystick inputs
		y = Math.pow(leftYAxis, 3);
		x = Math.pow(-rightXAxis, 3);
		strafe = Math.abs(leftXAxis) * leftXAxis;

		// error = (rEncoder - lEncoder) * pTurnScl;

		if (Math.abs(leftSpeed - rightSpeed) > 0.1) {
			leftSpeed *= 0.5;
			rightSpeed *= 0.5;
			// Reset proportional controller
			// error = 0;
		}
		error = 0;
		leftSpeed = (y + x) + error;
		rightSpeed = (y - x) - error;
		// curLeftSpeed = 0, leftSpeed = -1
		// if ((leftSpeed > curSpeedLeft && leftSpeed >= 0)){
		// curSpeedLeft += leftSpeed / 75;
		// } else if ((leftSpeed < curSpeedLeft && leftSpeed <= 0)){
		// curSpeedLeft -= leftSpeed / 75;
		// }
		//
		// if ((rightSpeed > curSpeedRight && rightSpeed >= 0)){
		// curSpeedRight += rightSpeed / 75;
		// } else if ((rightSpeed < curSpeedRight && rightSpeed <= 0)){
		// curSpeedRight -= rightSpeed / 75;
		// }
		//
		// if ((leftSpeed < 0.1 && curSpeedLeft > 0) || (leftSpeed > -0.1 &&
		// curSpeedLeft < 0)){
		// curSpeedLeft = 0;
		// }
		//
		// if ((rightSpeed < 0.1 && curSpeedRight > 0) || (rightSpeed > -0.1 &&
		// curSpeedRight < 0)){
		// curSpeedRight = 0;
		// }
		if ((curSpeedLeft < leftSpeed && curSpeedLeft >= 0) || (curSpeedLeft > leftSpeed && curSpeedLeft <= 0))
			curSpeedLeft += leftSpeed / 75;
		if ((curSpeedRight < rightSpeed && curSpeedRight >= 0) || (curSpeedRight > rightSpeed && curSpeedRight <= 0))
			curSpeedRight += rightSpeed / 75;
		if ((leftSpeed < curSpeedLeft && curSpeedLeft >= 0) || (leftSpeed > curSpeedLeft && curSpeedLeft <= 0))
			curSpeedLeft -= leftSpeed / 75;
		if ((rightSpeed < curSpeedRight && curSpeedRight >= 0) || (rightSpeed > curSpeedRight && curSpeedRight <= 0))
			curSpeedRight -= rightSpeed / 75;
		
		
		if (Math.abs(leftSpeed) < 0.1) {
			curSpeedLeft = 0;
		}
		if (Math.abs(rightSpeed) < 0.1) {
			curSpeedRight = 0;
		}
		strafeSetPoint = strafe;

		if (Math.abs(strafeSetPoint) > Math.abs(strafeSpeed)) {
			if (strafeSetPoint > 0)
				strafeSpeed += 0.05;
			else
				strafeSpeed -= 0.05;
		} else
			strafeSpeed = strafeSetPoint;

		// System.out.println("Strafe Speed: " + strafeSpeed);

		// sends power numbers to Drive method
		// if (!autoRunning)
		Drive(leftSpeed, rightSpeed, -strafeSpeed);
		// Drive(0, 0, 0);
		System.out.println(autoRunning);
		Robot.sensors.leftEncoder(false);
		Robot.sensors.rightEncoder(false);
	}

	public void Drive(double leftSpeed, double rightSpeed, double strafe) {

		// VictorSPX
		CL.set(ControlMode.PercentOutput, leftSpeed);
		BL.set(ControlMode.PercentOutput, leftSpeed);
		CR.set(ControlMode.PercentOutput, rightSpeed);
		BR.set(ControlMode.PercentOutput, rightSpeed);

		H1.set(strafe);
		FL.set(leftSpeed);
		FR.set(rightSpeed);

		SmartDashboard.putNumber("Drive Left Speed", leftSpeed);
		SmartDashboard.putNumber("Drive Right Speed", rightSpeed);
		SmartDashboard.putNumber("Drive Strafe Speed", strafe);
		SmartDashboard.putNumber("curSpeedRight", curSpeedRight);

	}

	public void initDefaultCommand() {

		// subsystem's default command
		setDefaultCommand(new MoveController());

	}
}