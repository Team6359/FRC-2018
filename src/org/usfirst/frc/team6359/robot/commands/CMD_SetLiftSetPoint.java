package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_SetLiftSetPoint extends Command {
	
	double setPoint;

    public CMD_SetLiftSetPoint(double setPoint) {
    	requires(Robot.lift);
    	this.setPoint = setPoint;
    }

    protected void initialize() {
    	Robot.lift.enable();
    	Robot.lift.setSetpoint(setPoint);
    }

    protected boolean isFinished() {
        return Robot.lift.onTarget();
    }

}
