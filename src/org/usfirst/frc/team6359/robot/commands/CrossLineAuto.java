package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLineAuto extends CommandGroup {

    public CrossLineAuto() {
    	addSequential(new CMD_DriveStraight(120, 1));
    }
}
