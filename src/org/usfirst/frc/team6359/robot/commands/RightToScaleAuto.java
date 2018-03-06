package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToScaleAuto extends CommandGroup {

    public RightToScaleAuto() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(1) == 'L') {
				// Left Switch
				addSequential(new RightToLeftScaleAuto());
			} else {
				// Put right auto code here
				addSequential(new RightToRightScaleAuto());
			}
		}
    }
}
