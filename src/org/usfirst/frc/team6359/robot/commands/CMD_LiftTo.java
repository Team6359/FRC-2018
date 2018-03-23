package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftTo extends Command {

	int index;

	public CMD_LiftTo(int index) {
		this.index = index;
	}

	protected void initialize() {
		Robot.lift.liftTo(index);
		Robot.lift.liftPos = index;
	}

	protected boolean isFinished() {
		return true;
	}

}
