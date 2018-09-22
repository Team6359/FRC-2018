package org.usfirst.frc.team6359.robot;

import edu.wpi.first.wpilibj.Joystick;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick controller1;
	public static Joystick joystick;
	
	public OI() {
		controller1 = new Joystick(0);
		joystick = new Joystick(1);
	}
	
	public static boolean usingXBox() {
		for (int i = 0; i < 13; i++) {
			if (controller1.getRawButton(i)) {
				return true;
			}
		}
		for (int i = 0; i < 6; i++) {
			if (controller1.getRawAxis(i) != 0) {
				return true;
			}
		}
		return false;
	}
	
}
