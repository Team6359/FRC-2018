ackage org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftIntake extends Command {

    public CMD_LiftIntake() {
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//.lift.RunWheels(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }
}
