package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToRightBetweenSwitchAuto extends CommandGroup {

    public LeftToRightBetweenSwitchAuto() {
		addSequential(new CMD_LiftIncrement()); // Set to drive position
		addSequential(new CMD_DriveForward(196 + Robot.LENGTH + 18)); // Drive away from wall
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_DriveForward(60)); // Drive across to switch
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_LiftIncrement()); // Move lift up
		addSequential(new CMD_LiftIncrement()); // Lift increment higher to allow "launching"
    	addSequential(new CMD_LiftOuttake()); // Release cube
    }
}
