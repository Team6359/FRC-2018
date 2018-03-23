package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToLeftScaleThenLeftSwitchAuto extends CommandGroup {

    public RightToLeftScaleThenLeftSwitchAuto() {
    	 addSequential(new LeftToRightScaleAuto());
         addSequential(new CMD_LiftTo(0));
         addSequential(new CMD_DriveForward(-3 * 12));
         addSequential(new CMD_TurnDegrees(90));
         addSequential(new CMD_DriveForward(5 * 12));
         addSequential(new CMD_TurnDegrees(45));
         addSequential(new CMD_Intake());
         addSequential(new CMD_DriveForward(3 * 12));
         addSequential(new CMD_StopIntake());
         addSequential(new CMD_LiftIncrement());
         addSequential(new CMD_LiftIncrement());
         addSequential(new CMD_LiftOuttake());
    }
}
