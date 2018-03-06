package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullAutoRight extends CommandGroup {

    public FullAutoRight() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'R') {
				addSequential(new RightToRightSwitchAuto());
			} else if (gameData.charAt(1) == 'R'){
				addSequential(new RightToRightScaleAuto());
			} else {
				addSequential(new RightToLeftBetweenSwitchAuto());
			}
		}
    }
}
