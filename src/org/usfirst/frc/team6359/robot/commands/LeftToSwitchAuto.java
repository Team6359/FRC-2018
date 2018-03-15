package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToSwitchAuto extends CommandGroup {

	public LeftToSwitchAuto() {
		if (Robot.switchPos == 'L') {
			addSequential(new LeftToLeftSwitchAuto());
		} else{
			addSequential(new CrossLineAuto());
		}
	}
}
