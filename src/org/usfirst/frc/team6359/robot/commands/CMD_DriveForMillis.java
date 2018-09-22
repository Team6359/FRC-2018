package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CMD_DriveForMillis extends Command {

	double speed, millis;
	double curSpeed = 0;
	double accelRate = 0.02;
	double startTime;
    public CMD_DriveForMillis(double speed, double millis) {
    	requires(Robot.driveTrain);
    	this.speed = speed;
    	this.millis = millis;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (System.currentTimeMillis() - startTime <= millis) {
    		Robot.driveTrain.Drive(-curSpeed, -curSpeed, 0);
    	}
    	if (curSpeed < speed && speed > 0) {
    		curSpeed += accelRate;
    	}
    	
    	if (curSpeed > speed && speed < 0) {
    		curSpeed -= accelRate;
    	}
    	System.out.println("CURSPEED: " + curSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime > millis;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.Drive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
