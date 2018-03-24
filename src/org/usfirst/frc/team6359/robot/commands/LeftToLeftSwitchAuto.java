package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftSwitchAuto extends CommandGroup {

    public LeftToLeftSwitchAuto() {
    	addSequential(new CMD_LiftIncrement()); // Set to drive position
		addSequential(new CMD_DriveForward(170 - (Robot.LENGTH * 3 / 2))); // Position halfway along the switch plate
		addSequential(new CMD_LiftIncrement()); // Lift to switch position
		addSequential(new CMD_TurnDegrees(90)); // Turn towards switch
		addSequential(new CMD_DriveForMillis(0.5, 1000));
		addSequential(new CMD_LiftOuttake()); // Release cubes
    }
}
