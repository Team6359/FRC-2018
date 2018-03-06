package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToSwitchAuto extends CommandGroup {

	public LeftToSwitchAuto() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				// Left Switch
				addSequential(new LeftToLeftSwitchAuto());
			} else {
				// Put right auto code here
				addSequential(new LeftToRightBetweenSwitchAuto());
			}
		}
	}
}
