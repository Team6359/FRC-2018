package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class TestAuto extends CommandGroup {

    public TestAuto() {
    	addSequential(new CMD_DriveForward(24));
    	addSequential(new CMD_TurnDegrees(-25));
    	addSequential(new CMD_DriveForward(128));
    }
}
