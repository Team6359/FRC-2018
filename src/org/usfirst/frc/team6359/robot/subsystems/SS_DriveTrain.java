package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.RobotMap;
import org.usfirst.frc.team6359.robot.commands.MoveController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_DriveTrain extends Subsystem {

	int gear;
	double gearVal;
	String gearNumber;

	double x, y, strafe, leftSpeed, rightSpeed, strafeSpeed = 0, strafeSetPoint;

	public static SpeedController FL, FR, H1;
	public static VictorSPX CL, BL, CR, BR;

	//Encoder lEncoder = Robot.sensors.getEncLeft();
	//Encoder rEncoder = Robot.sensors.getEncRight();

	//PIDController drivePIDLeft = new PIDController(1, 0, 0, lEncoder, null);
	
	int error = 0;

	int kSlotIdx = 0;

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

		// BR.selectProfileSlot(kSlotIdx, 0);
		// BR.config_kF(kSlotIdx, 0.2, 10);
		// BR.config_kP(kSlotIdx, 0.2, 10);
		// BR.config_kI(kSlotIdx, 0, 10);
		// BR.config_kD(kSlotIdx, 0, 10);
		//

	}


	public void ControllerDrive(double leftXAxis, double leftYAxis, double rightXAxis, double rightYAxis) {
		// squares joystick inputs
		y = Math.abs(leftYAxis) * leftYAxis * Math.abs(leftYAxis);
		x = Math.abs(rightXAxis) * rightXAxis * Math.abs(rightXAxis) * -1;
		strafe = Math.abs(leftXAxis) * leftXAxis;

		// Formula for arcade drive
		

		//error = rEncoder - lEncoder;
	
		

		if (Math.abs(leftSpeed - rightSpeed) > 0.1) {
			leftSpeed *= 0.5;
			rightSpeed *= 0.5;
			//Reset proportional controller
			error = 0;
		}
		
		leftSpeed = (y + x) + error;
		rightSpeed = (y - x) - error;
		

		strafeSetPoint = strafe;

		if (Math.abs(strafeSetPoint) > Math.abs(strafeSpeed)) {
			if (strafeSetPoint > 0)
				strafeSpeed += 0.05;
			else
				strafeSpeed -= 0.05;
		} else
			strafeSpeed = strafeSetPoint;

		System.out.println("Strafe Speed: " + strafeSpeed);

		// sends power numbers to Drive method
		Drive(leftSpeed, rightSpeed, -strafeSpeed);

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

	}

	public void initDefaultCommand() {

		// subsystem's default command
		setDefaultCommand(new MoveController());

	}
}
