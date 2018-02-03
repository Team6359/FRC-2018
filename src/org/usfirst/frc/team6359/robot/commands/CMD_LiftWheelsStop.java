package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftWheelsStop extends Command {

    public CMD_LiftWheelsStop() {
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.RunWheels(0);
    }

      protected boolean isFinished() {
        return true;
    }
}
