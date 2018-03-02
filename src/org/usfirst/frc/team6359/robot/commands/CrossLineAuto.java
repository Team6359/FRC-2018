package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLineAuto extends CommandGroup {

    public CrossLineAuto() {
    	addSequential(new CMD_DriveStraight(24, 0.5));
    	//addSequential(new CMD_TurnDegrees(360));
    
    }
}
