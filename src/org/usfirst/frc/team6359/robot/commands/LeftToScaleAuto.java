package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToScaleAuto extends CommandGroup {

    public LeftToScaleAuto() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(1) == 'L') {
				// Left Switch
				addSequential(new LeftToLeftScaleAuto());
			} else {
				// Put right auto code here
				addSequential(new LeftToRightScaleAuto());
			}
		}
    }
}
