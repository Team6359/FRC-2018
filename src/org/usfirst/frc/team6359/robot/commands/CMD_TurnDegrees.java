package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_TurnDegrees extends Command {
	private boolean finish;
	private double degs, count, spd;

	public CMD_TurnDegrees(double degrees, double speed) {
		requires(Robot.driveTrain);

		spd = speed;
		degs = degrees;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//Robot.sensors.gyro(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//count = Robot.sensors.gyro(false);

		if (degs > 0) {
			if (degs > count) {
				Robot.driveTrain.Drive(spd, -spd, 0);
			} else {
				Robot.driveTrain.Drive(0, 0, 0);
				finish = true;
			}
		} else {
			if (degs < count) {
				Robot.driveTrain.Drive(-spd, spd, 0);

			}
			else{
				Robot.driveTrain.Drive(0, 0, 0);
				finish = true;
			}
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finish;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
