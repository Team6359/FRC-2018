package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftSwitchAuto extends CommandGroup {

    public LeftToLeftSwitchAuto() {
    	addSequential(new CMD_LiftReset());
    	addSequential(new CMD_LiftIncrement());
    	addSequential(new CMD_DriveForward(162));
    	addSequential(new CMD_LiftIncrement());
    	addSequential(new CMD_TurnDegrees(90));
    	addSequential(new CMD_LiftIncrement());
    	addSequential(new CMD_LiftOuttake());
    }
}
