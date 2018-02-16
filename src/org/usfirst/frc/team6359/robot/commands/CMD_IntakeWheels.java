package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_IntakeWheels extends Command {

	boolean rB, finished = false;
	
    public CMD_IntakeWheels() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	rB = Robot.intake.getRB();
    	if (!rB)
    		finished = true;
    	
    	//Robot.intake.intakeWheels(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    //	Robot.intake.intakeWheels(0);
    	new CMD_IntakeOpen();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
