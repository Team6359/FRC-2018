package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.RobotMap;
import org.usfirst.frc.team6359.robot.commands.CMD_IntakeClose;
import org.usfirst.frc.team6359.robot.commands.CMD_IntakeOpen;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_Intake extends Subsystem {

	private static Solenoid solenoidLeft;
	private static Solenoid solenoidRight;
	private static SpeedController intakeLeft;
	private static SpeedController intakeRight;
	
	private boolean rB;

	public SS_Intake() {
		solenoidLeft = new Solenoid(0);
		solenoidRight = new Solenoid(1);

		intakeLeft = new Victor(RobotMap.intakeLeft);
		intakeRight = new Victor(RobotMap.intakeRight);
		
		intakeRight.setInverted(true);
		intakeLeft.setInverted(false);

	}
	
	public void Control(boolean rB){
//		if(rB){
//			Set_Position(1);
//			intakeLeft.set(1);
//			intakeRight.set(-1);
//		} else {
//			Set_Position(0);
//			intakeLeft.set(0);
//			intakeRight.set(0);
//		}
		
		this.rB = rB;
		
		if (rB){
			new CMD_IntakeClose();
		}else{
			new CMD_IntakeOpen();
		}
		
	}

	public void Set_Position(int pos) {
		// 0: open, 1: closed
		solenoidLeft.set(pos == 0);
		solenoidRight.set(pos != 0);
	}
	
	public boolean getRB(){
		return rB;
	}


	public void initDefaultCommand() {
	}

	public void intakeWheels(int speed) {
		intakeLeft.set(speed);
		intakeRight.set(speed);
	}
	
}
