package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Field;
import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToRightScaleAuto extends CommandGroup {

    public LeftToRightScaleAuto() {
    	addSequential(new CMD_LiftReset()); // Reset 0 on lift
		addSequential(new CMD_LiftIncrement()); // Set to drive position
		addSequential(new CMD_DriveForward(261.47 + Robot.LENGTH)); // Drive away from wall
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_DriveForward(Field.LeftToRightScale)); // Drive across field
		addSequential(new CMD_TurnDegrees(-90)); // Turn left
		addSequential(new CMD_DriveForward(72)); // Line up on scale
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_LiftIncrement()); // Increment lift
		addSequential(new CMD_TurnDegrees(-45)); // Turn left
		addSequential(new CMD_LiftOuttake()); // Release cube
    }
}
