package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToLeftSwtichAuto extends CommandGroup {

	public CenterToLeftSwtichAuto() {
		addSequential(new CMD_LiftReset()); // Reset 0 lift
		addSequential(new CMD_LiftIncrement()); // Move lift up to drive position
		addSequential(new CMD_DriveForward(Robot.LENGTH)); // Move away from wall
		addSequential(new CMD_TurnDegrees(-90)); // Turn left
		addSequential(new CMD_DriveForward(82.75 + Robot.LENGTH / 2 + 2)); // Go past the switch plus 2 inches
		addSequential(new CMD_TurnDegrees(90)); // Turn Right
		addSequential(new CMD_DriveForward(Robot.LENGTH / 2)); // Drive up to switch
		addSequential(new CMD_LiftIncrement()); // Lift up
		addSequential(new CMD_LiftIncrement()); // Lift up to "launch" cube
		addSequential(new CMD_LiftOuttake()); // Lift up
		addSequential(new CMD_DriveForward(-Robot.LENGTH / 2)); // Move away from switch
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_DriveForward(-30)); // Move backwards
		addSequential(new CMD_TurnDegrees(90)); // Turn right
		addSequential(new CMD_DriveForward(-60)); // Cross auto line backwards
	}
}
