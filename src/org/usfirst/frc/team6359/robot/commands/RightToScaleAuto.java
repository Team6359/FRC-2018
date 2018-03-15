package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToScaleAuto extends CommandGroup {

	public RightToScaleAuto() {
		if (Robot.scalePos == 'L') {
			addSequential(new CrossLineAuto());
		} else {
			addSequential(new RightToRightScaleAuto());
		}
	}
}
