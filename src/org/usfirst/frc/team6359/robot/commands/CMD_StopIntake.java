package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CMD_StopIntake extends Command {

    public CMD_StopIntake() {
        requires(Robot.lift);
        requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.autoIntake = false;
    	Robot.intake.intakeOpen();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
