package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToScaleAuto extends CommandGroup {

	public LeftToScaleAuto() {
		if (Robot.scalePos == 'L') {
			addSequential(new LeftToLeftScaleAuto());
		} else {
			addSequential(new CrossLineAuto());
		}
	}
}
