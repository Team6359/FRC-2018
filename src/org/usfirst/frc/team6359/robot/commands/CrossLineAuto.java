package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CrossLineAuto extends CommandGroup {

    public CrossLineAuto() {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
    	SmartDashboard.putString("Network table", gameData);
    	addSequential(new CMD_DriveForward(196));    
    	
    }
}
