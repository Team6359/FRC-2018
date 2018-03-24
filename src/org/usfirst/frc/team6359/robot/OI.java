package org.usfirst.frc.team6359.robot;

import edu.wpi.first.wpilibj.Joystick;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick controller1;
	public static Joystick controller2;
	
	public OI(){	
		controller1 = new Joystick(0);
		controller2 = new Joystick(1);
	}
}
