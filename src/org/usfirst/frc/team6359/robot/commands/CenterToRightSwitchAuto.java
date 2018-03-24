package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToRightSwitchAuto extends CommandGroup {

    public CenterToRightSwitchAuto() {
		addSequential(new CMD_DriveForMillis(1, 1000)); // Move away from wall
		addSequential(new CMD_TurnDegrees(90)); // Turn left
		addSequential(new CMD_DriveForward(70)); // Go past the switch plus 2 inches
		addSequential(new CMD_TurnDegrees(-90)); // Turn Right
		addSequential(new CMD_LiftIncrement()); // Lift up
		addSequential(new CMD_LiftIncrement()); // Lift up
		addSequential(new CMD_DriveForMillis(1, 3000)); // Drive up to switch
		addSequential(new CMD_LiftOuttake()); // Lift up
    }
}
