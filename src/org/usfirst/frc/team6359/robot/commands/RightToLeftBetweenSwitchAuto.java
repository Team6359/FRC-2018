package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToLeftBetweenSwitchAuto extends CommandGroup {

    public RightToLeftBetweenSwitchAuto() {
    	addSequential(new CMD_LiftReset()); // Reset 0 on lift
		addSequential(new CMD_LiftIncrement()); // Set to drive position
		addSequential(new CMD_DriveForward(261.47 + Robot.LENGTH)); // Drive away from wall
		addSequential(new CMD_TurnDegrees(-90)); // Turn left
		addSequential(new CMD_DriveForward(60)); // Drive across to switch
		addSequential(new CMD_TurnDegrees(-90)); // Turn left
		addSequential(new CMD_LiftIncrement()); // Move lift up
		addSequential(new CMD_LiftIncrement()); // Lift increment higher to allow "launching"
    	addSequential(new CMD_LiftOuttake()); // Release cube
    }
}
