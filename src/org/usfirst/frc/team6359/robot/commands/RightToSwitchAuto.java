package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToSwitchAuto extends CommandGroup {

    public RightToSwitchAuto() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				// Left Switch
				addSequential(new RightToLeftBetweenSwitchAuto());
			} else {
				// Put right auto code here
				addSequential(new RightToRightSwitchAuto());
			}
		}
    }
}
