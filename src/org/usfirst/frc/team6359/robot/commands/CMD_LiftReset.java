package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftReset extends Command {

    private double speed = 0;
	public CMD_LiftReset() {
        requires(Robot.lift);
    }

    protected void initialize() {
    	Robot.lift.disable();
    }

    protected void execute() {
    	if (speed < 0.5)
    		speed += 0.02;
    	
    	Robot.lift.Lift(speed);
    }

    protected boolean isFinished() {
        return Robot.sensors.liftLimitLow();
    }

    protected void end() {
    	Robot.lift.Lift(0);
    	Robot.lift.resetEnc();
    	Robot.lift.enable();
    	Robot.lift.liftPos = 0;
    }

    protected void interrupted() {
    }
}
