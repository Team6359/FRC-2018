package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullAutoRight extends CommandGroup {

	public FullAutoRight() {
		if (Robot.switchPos == 'R') {
			addSequential(new RightToRightSwitchAuto());
		} else if (Robot.scalePos == 'R') {
			addSequential(new RightToRightScaleAuto());
		} else {
			addSequential(new CrossLineAuto());
		}
	}
}
