package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftDecrement extends Command {

	 public CMD_LiftDecrement() {
	        requires(Robot.lift);
	    }

	    protected void initialize() {
	    	Robot.lift.decrement();
	    }
	    
	    protected boolean isFinished() {
	        return true;
	    }
}
