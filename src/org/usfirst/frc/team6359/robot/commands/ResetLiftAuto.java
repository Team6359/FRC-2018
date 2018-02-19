package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ResetLiftAuto extends CommandGroup {

    public ResetLiftAuto() {
    	addSequential(new CMD_LiftReset());
    }
}
