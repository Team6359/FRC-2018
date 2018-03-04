package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToRightSwitchAuto extends CommandGroup {

    public RightToRightSwitchAuto() {
    	addSequential(new CMD_LiftReset()); // Reset 0 on lift
    	addSequential(new CMD_LiftIncrement()); // Set to drive position
    	addSequential(new CMD_DriveForward(261.47 - (Robot.LENGTH / 2))); // Position halfway along the switch plate
    	addSequential(new CMD_LiftIncrement()); // Lift to switch position
    	addSequential(new CMD_TurnDegrees(-90)); // Turn towards switch
    	addSequential(new CMD_LiftIncrement()); // Lift increment higher to allow "launching"
    	addSequential(new CMD_LiftOuttake()); // Release cubes
    }
}
