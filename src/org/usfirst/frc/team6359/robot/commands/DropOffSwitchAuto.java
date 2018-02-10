package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropOffSwitchAuto extends CommandGroup {

    public DropOffSwitchAuto() {    	
    	//CHANGE
    	addSequential(new CMD_DriveStraight(148, 1));
    	addSequential(new CMD_LiftIncrement());
    	addSequential(new CMD_LiftOuttake());
    }
}
 