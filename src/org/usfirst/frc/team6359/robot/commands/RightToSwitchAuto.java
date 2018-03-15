package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToSwitchAuto extends CommandGroup {

	public RightToSwitchAuto() {
		if (Robot.switchPos == 'R') {
			addSequential(new RightToRightSwitchAuto());
		} else{
			addSequential(new CrossLineAuto());
		}
	}
}
