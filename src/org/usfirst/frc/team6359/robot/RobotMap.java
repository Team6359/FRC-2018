package org.usfirst.frc.team6359.robot;

import edu.wpi.first.wpilibj.DigitalSource;

public class RobotMap {
	
	/*
	 Left Stick X: 0
	 Left Stick Y: 1
	 Left Trigger: 2
	 Right Trigger: 3
	 Right Stick X: 4
	 Right Stick Y: 5
	 
	 A: 1
	 B: 2
	 X: 3
	 Y: 4
	 Left Bumper: 5
	 Left Bumper: 6
	 Back: 7
	 Start: 8
	 Left Stick Click: 9
	 Right Stick Click: 10
	*/
	
	//VictorSPX
	public static int BR = 1;
	public static int CR = 2;
	public static int BL = 3;
	public static int CL = 4;
	
	//Victor
	public static int H1 = 1;
	public static int FL = 2;
	public static int FR = 3;
	
	public static int intakeLeft = 4;
	public static int intakeRight = 5;
	
	public static int liftWheelLeft = 9;
	public static int liftWheelRight = 10;
	
	public static int liftMotor1 = 11;
	public static int liftMotor2 = 12;
	
	public static DigitalSource rEncoder1;
	public static DigitalSource rEncoder2;
	public static DigitalSource lEncoder1;
	public static DigitalSource lEncoder2;

	public static double cpiLift = 271.63;
	//Inches * cpiLift
	public static double liftSetPointFloor = 0;
	public static double liftSetPointDrive = 2 * cpiLift;
	public static double liftSetPointSwitch = 24 * cpiLift;
	public static double liftSetPointScaleLow = 60 * cpiLift;
	public static double liftSetPointScaleNeutral = 70 * cpiLift;
	public static double liftSetPointScaleHigh = 84 * cpiLift;
}
