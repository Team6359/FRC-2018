package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftScaleAuto extends CommandGroup {

    public LeftToLeftScaleAuto() {
    	addSequential(new CMD_LiftIncrement()); // Set to drive position
    	addSequential(new CMD_DriveForward(310 + (Robot.LENGTH) - 36)); // Position halfway along the switch plate
    	addSequential(new CMD_TurnDegrees(90)); // Turn towards scale
    	addSequential(new CMD_LiftIncrement()); // Lift to switch position
    	addSequential(new CMD_LiftIncrement()); // Lift to switch position
    	addSequential(new CMD_LiftIncrement()); // Lift to switch position
    	addSequential(new CMD_LiftIncrement()); // Lift to switch position
    	addSequential(new CMD_LiftIncrement()); // Lift to switch position
    	addSequential(new CMD_LiftOuttake()); // Release cubes
    }
}
