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
public class SS_Hang extends Subsystem {

	static SpeedController winchMotor;
	Solenoid bac1;
	Solenoid bac2;
	
	boolean debounce = false;
	boolean bacUp = false;
	
    public SS_Hang(){
    	winchMotor = new Victor(RobotMap.winch);
    	bac1 = new Solenoid(RobotMap.bac1);
    	bac2 = new Solenoid(RobotMap.bac2);
    }
    
    public void Control(boolean b, boolean y){
    	if (b) {
    		Hang(1);
    	} else {
    		Hang(0);
    	}
    	
    	if (y && !debounce) {
    		bacUp = !bacUp;
    		debounce = true;
    	}
    	
    	if (!y) {
    		debounce = false;
    	}
    	
    	
    }
    
    public void Hang(double speed){
    	winchMotor.set(speed);
    	SmartDashboard.putNumber("Hang Speed", speed);
    	bac1.set(bacUp);
    	bac2.set(!bacUp);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

