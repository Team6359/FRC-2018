package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullAutoLeft extends CommandGroup {

    public FullAutoLeft() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				// Left Switch
				addSequential(new LeftToLeftSwitchAuto());
			} else if (gameData.charAt(1) == 'L'){
				// Put right auto code here
				addSequential(new LeftToLeftScaleAuto());
			} else {
				addSequential(new LeftToRightBetweenSwitchAuto());
			}
		}
    }
}
