package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftOuttake extends Command {

	private double timer = 0;
    public CMD_LiftOuttake() {
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    protected void execute() {
    	if (timer < 50) {
    		Robot.lift.runWheels(-1,-1);
    		timer++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer >= 50;
    }
}
