package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		solenoidLeft = new Solenoid(1);
		solenoidRight = new Solenoid(2);

		intakeLeft = new Victor(RobotMap.intakeLeft);
		intakeRight = new Victor(RobotMap.intakeRight);
		
		intakeRight.setInverted(false);
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
		//System.out.println("RB" + rB);
		
		if (rB){
			intakeClose();
			intakeWheels(0.3);
		}else if (!rB){
			intakeOpen();
			intakeWheels(0);
		}
		
	}
	
	
	public void intakeClose(){
		Set_Position(0);
		System.out.println("Intake Close");
	}
	
	public void intakeOpen(){
		Set_Position(1);
		System.out.println("Intake Open");
	}

	public void Set_Position(int pos) {
		// 0: open, 1: closed
		solenoidLeft.set(pos == 0);
		solenoidRight.set(pos != 0);
		
		SmartDashboard.putNumber("SolenoidLeft", pos);
		System.out.println(pos);
	}
	
	public boolean getRB(){
		return rB;
	}


	public void initDefaultCommand() {
	}

	public void intakeWheels(double speed) {
		intakeLeft.set(speed);
		intakeRight.set(speed);
		SmartDashboard.putNumber("Intake Speed", speed);
	}
	
}
