package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftScaleAuto extends CommandGroup {

    public LeftToLeftScaleAuto() {
        addSequential(new CMD_LiftReset()); // Reset 0 on lift
        addSequential(new CMD_LiftIncrement()); // Lift to drive position
        addSequential(new CMD_DriveForward(298 - Robot.LENGTH)); // Go to where the front of the bumper is lined up with the scale
        addSequential(new CMD_LiftIncrement()); // Lift to switch position
        addSequential(new CMD_LiftIncrement()); // Lift to low scale position
        addSequential(new CMD_LiftIncrement()); // Lift to mid scale position
        addSequential(new CMD_LiftIncrement()); // Lift to high scale position
        addSequential(new CMD_TurnDegrees(90)); // Turn to side
        addSequential(new CMD_DriveForward(24)); // Line up on scale
        addSequential(new CMD_TurnDegrees(-90)); // Turn to scale
        addSequential(new CMD_LiftOuttake()); // Release cube
    }
}
