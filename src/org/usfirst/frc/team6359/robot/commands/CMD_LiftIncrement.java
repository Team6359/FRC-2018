package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftIncrement extends Command {
	
	double startTime = 0;

    public CMD_LiftIncrement() {
        requires(Robot.lift);
    }

    protected void initialize() {
    	Robot.lift.increment();
    	Robot.lift.enable();
        startTime = System.currentTimeMillis();

    }
    
    protected void execute() {
    	Robot.lift.enable();
    }
    
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime > 1500;
    }

}
