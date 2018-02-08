package org.usfirst.frc.team6359.robot;

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
	public static final int H1 = 7;
	public static final int FL = 8;
	public static final int FR = 6;
	public static final int winch = 9;
	
	//Spark
	public static final int intakeLeft = 3;
	public static final int intakeRight = 2;
	
	public static final int liftWheelLeft = 4;
	public static final int liftWheelRight = 5;
	
	public static final int liftMotor1 = 0;
	public static final int liftMotor2 = 1;
	
//	public static DigitalSource rEncoder1;
//	public static DigitalSource rEncoder2;
//	public static DigitalSource lEncoder1;
//	public static DigitalSource lEncoder2;
//	public static DigitalSource liftEncoder1;
//	public static DigitalSource liftEncoder2;

	public static final int rEncoder1 = 0;
	public static final int rEncoder2 = 1;
	public static final int lEncoder1 = 2;
	public static final int lEncoder2 = 3;
	public static final int liftEncoder1 = 4;
	public static final int liftEncoder2 = 5;

	public static double cpiLift = 271.63;
	//Inches * cpiLift
	public static double liftSetPointFloor = 0;
	public static double liftSetPointDrive = 2 * cpiLift;
	public static double liftSetPointSwitch = 24 * cpiLift;
	public static double liftSetPointScaleLow = 60 * cpiLift;
	public static double liftSetPointScaleNeutral = 70 * cpiLift;
	public static double liftSetPointScaleHigh = 84 * cpiLift;
}
