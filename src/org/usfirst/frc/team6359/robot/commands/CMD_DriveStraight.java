package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_DriveStraight extends Command{
	
	@SuppressWarnings("unused")
	private double cpi, _distance, spd;
	private boolean finish;
	

	public CMD_DriveStraight(double Distance, double Speed) {

		cpi = 330/12;
		_distance = Distance * cpi;
		spd = Speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//Robot.sensors.rightEncoder(true);
		//Robot.sensors.leftEncoder(true);

		finish = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double lEncoder = Robot.sensors.leftEncoder(false);
		double rEncoder = Robot.sensors.rightEncoder(false);

		double turn = lEncoder - rEncoder;
		turn *= .005;

		double _count = Robot.sensors.rightEncoder(false);
		double pControl = _count / _distance;

		if (_distance < 0) {
			if (_count > _distance) {
				Robot.driveTrain.Drive(-1 * spd * (1 - pControl), -(spd + turn) * (1 - pControl), 0);
			} else {
				Robot.driveTrain.Drive(0, 0, 0);
				finish = true;
			}

		}

		if (_distance > 0) {
			if (_count < _distance) {
				Robot.driveTrain.Drive((spd)* (1 - pControl), (spd)* (1 - pControl), 0);
			} else {
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
