package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToSwitchAuto extends CommandGroup {

	public CenterToSwitchAuto() {
		if (Robot.switchPos == 'L') {
			addSequential(new CenterToLeftSwitchAuto());	
		}else if (Robot.switchPos == 'R'){
			addSequential(new CenterToRightSwitchAuto());	
		}
	}
}
