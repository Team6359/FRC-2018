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
public class CMD_TurnDegrees extends Command {
	
	private PIDSource source;
	PIDController turnController;
	private double degrees;
	private DummyPIDOutput output;
	private double readableOutput;
	
	boolean finished = false;

	public CMD_TurnDegrees(double degrees) {
		requires(Robot.sensors);
		requires(Robot.driveTrain);
		source = Robot.sensors.gyro;
		output = new DummyPIDOutput();
		turnController = new PIDController(0.008, 0, 0, source, output); // Carpet - 0.02, 0, 0.053
		this.degrees = degrees;
	}
	protected void initialize() {
		Robot.sensors.gyro.reset();
		turnController.setSetpoint(degrees);
		turnController.setAbsoluteTolerance(1);
		turnController.setOutputRange(-1, 1);
		turnController.enable();
	}

	protected void execute() {
		readableOutput = output.getOutput();
		Robot.driveTrain.Drive(-readableOutput * 0.5, readableOutput * 0.5, 0);
		finished = turnController.onTarget();
		SmartDashboard.putNumber("Setpoint", turnController.getSetpoint());
		SmartDashboard.putNumber("Gyro", Robot.sensors.gyro(false));
		SmartDashboard.putNumber("LeftSpeedPID", readableOutput);
		SmartDashboard.putNumber("RightSpeedPID", -readableOutput);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
