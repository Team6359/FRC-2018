package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_Hang extends Subsystem {

	static SpeedController winchMotor;
	
    public SS_Hang(){
    	winchMotor = new Victor(RobotMap.winch);
    }
    
    public void Control(boolean x, boolean y){
    	if (y)
    		Hang(-1);
    	else if (x)
    		Hang(1);
    	else
    		Hang(0);
    }
    
    public void Hang(double speed){
    	winchMotor.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

