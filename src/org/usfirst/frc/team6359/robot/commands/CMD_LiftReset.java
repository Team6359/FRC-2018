package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftReset extends Command {

    private boolean finished = false;

	public CMD_LiftReset() {
        requires(Robot.lift);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (Robot.sensors.liftLimitLow()) {
    		finished  = true;
    	}
    	Robot.lift.Lift(1);
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    	Robot.lift.Lift(0);
    	Robot.lift.resetEnc();
    }

    protected void interrupted() {
    }
}
