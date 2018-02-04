package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_IntakeOpen extends Command {

    public CMD_IntakeOpen() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      	Robot.intake.Set_Position(0);
      	System.out.println("CMD_IntakeOpen");
    }

   // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    
}
