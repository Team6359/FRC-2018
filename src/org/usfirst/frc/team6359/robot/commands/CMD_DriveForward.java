package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.subsystems.DummyPIDOutput;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CMD_DriveForward extends Command {

	private PIDSource source;
	PIDController driveController;
	private double dist;
	private DummyPIDOutput output;
	private double readableOutput;
	private double accelScale = 0.0;
	private double maxScale = 0.5;
	private double accelRate = 0.01; // 0.04

	public CMD_DriveForward(double dist) {
		this.dist = dist * (700/96);
		requires(Robot.driveTrain);
		requires(Robot.sensors);
		Robot.sensors.encRight.setReverseDirection(true);
		source = Robot.sensors.encRight;
		output = new DummyPIDOutput();
		driveController = new PIDController(0.001, 0.0005, 0, source, output); //Carpet - 0.003, 0, 0.0001
		accelScale = 0;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.autoRunning = true;
		Robot.sensors.encRight.reset();
		driveController.setSetpoint(dist);
		driveController.setAbsoluteTolerance((700/96) * 12);
		driveController.setOutputRange(-1, 1);
		driveController.enable();
		Robot.sensors.gyro(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		readableOutput = output.getOutput();
		Robot.driveTrain.Drive(-readableOutput * accelScale + (Robot.sensors.gyro(false)/90),
				-readableOutput * accelScale - (Robot.sensors.gyro(false)/90), 0);
		SmartDashboard.putNumber("Drive Setpoint", driveController.getSetpoint());
		SmartDashboard.putNumber("LeftSpeedPID", readableOutput);
		SmartDashboard.putNumber("RightSpeedPID", readableOutput);
		SmartDashboard.putNumber("Right Encoder", source.pidGet());
		if (accelScale < maxScale)
			accelScale += accelRate;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return driveController.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.autoRunning = false;
		driveController.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
