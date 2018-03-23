package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_Intake extends Command {

	public CMD_Intake() {
		requires(Robot.lift);
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.autoIntake = true;
		Robot.intake.intakeClose();
	}

	protected void execute() {
		if (Robot.autoIntake) {
			Robot.lift.runWheels(1, 1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.autoIntake;
	}

	protected void end() {
		Robot.lift.runWheels(0, 0);
		Robot.intake.intakeOpen();
	}
}
