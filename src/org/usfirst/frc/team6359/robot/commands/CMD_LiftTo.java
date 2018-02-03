package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMD_LiftTo extends Command {

	int index;

	public CMD_LiftTo(int index) {
		this.index = index;
	}

	protected void initialize() {
		switch (index) {
		case 0:
			new CMD_SetLiftSetPoint(RobotMap.liftSetPointFloor);
			break;
		case 1:
			new CMD_SetLiftSetPoint(RobotMap.liftSetPointDrive);
			break;
		case 2:
			new CMD_SetLiftSetPoint(RobotMap.liftSetPointSwitch);
			break;
		case 3:
			new CMD_SetLiftSetPoint(RobotMap.liftSetPointScaleLow);
			break;
		case 4:
			new CMD_SetLiftSetPoint(RobotMap.liftSetPointScaleNeutral);
			break;
		case 5:
			new CMD_SetLiftSetPoint(RobotMap.liftSetPointScaleHigh);
			break;
		}
	}

	protected boolean isFinished() {
		return true;
	}

}
