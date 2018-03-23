package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftScaleThenLeftSwitchAuto extends CommandGroup {

    public LeftToLeftScaleThenLeftSwitchAuto() {
    	addSequential(new LeftToLeftScaleAuto());
    	addParallel(new CMD_LiftTo(0));
    	addSequential(new CMD_TurnDegrees(90));
    	addSequential(new CMD_DriveForward(Robot.LENGTH * 4));
    	addSequential(new CMD_TurnDegrees(-45));
    	addSequential(new CMD_DriveForward(5 * 12));
    	addSequential(new CMD_TurnDegrees(45));
    	addSequential(new CMD_Intake());
    	addSequential(new CMD_DriveForward(3 * 12));
    	addParallel(new CMD_StopIntake());
    	addSequential(new CMD_LiftIncrement());
    	addSequential(new CMD_LiftIncrement());
    	addSequential(new CMD_LiftOuttake());
    }
}
