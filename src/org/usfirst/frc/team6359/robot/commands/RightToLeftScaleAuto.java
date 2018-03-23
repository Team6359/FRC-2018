package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToLeftScaleAuto extends CommandGroup {

    public RightToLeftScaleAuto() {
    	addSequential(new CMD_LiftReset()); // Reset 0 on lift
		addSequential(new CMD_LiftIncrement()); // Set to drive position
		addSequential(new CMD_DriveForward(228.5 - Robot.LENGTH)); // Drive away from wall
		addSequential(new CMD_TurnDegrees(-90)); // Turn left
		addSequential(new CMD_DriveForward(264)); // Drive across field
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_DriveForward(72)); // Line up on scale
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_LiftOuttake()); // Release cube
    }
}
