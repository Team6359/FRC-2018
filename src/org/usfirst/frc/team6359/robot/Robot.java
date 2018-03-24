
package org.usfirst.frc.team6359.robot;

import org.usfirst.frc.team6359.robot.commands.CMD_IntakeClose;
import org.usfirst.frc.team6359.robot.commands.CenterToLeftSwitchAuto;
import org.usfirst.frc.team6359.robot.commands.CenterToRightSwitchAuto;
import org.usfirst.frc.team6359.robot.commands.CrossLineAuto;
import org.usfirst.frc.team6359.robot.commands.LeftToLeftScaleAuto;
import org.usfirst.frc.team6359.robot.commands.LeftToLeftSwitchAuto;
import org.usfirst.frc.team6359.robot.commands.RightToRightScaleAuto;
import org.usfirst.frc.team6359.robot.commands.RightToRightSwitchAuto;
import org.usfirst.frc.team6359.robot.subsystems.SS_DSOutput;
import org.usfirst.frc.team6359.robot.subsystems.SS_DriveTrain;
import org.usfirst.frc.team6359.robot.subsystems.SS_Hang;
import org.usfirst.frc.team6359.robot.subsystems.SS_Intake;
import org.usfirst.frc.team6359.robot.subsystems.SS_Lift;
import org.usfirst.frc.team6359.robot.subsystems.SS_Sensors;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static SS_DriveTrain driveTrain;
	public static SS_DSOutput dsOutput;
	public static SS_Sensors sensors;
	public static SS_Intake intake;
	public static SS_Lift lift;
	public static SS_Hang hang;
	public static final double LENGTH = 34;
	public static boolean autoIntake = false;

	public static char switchPos;
	public static char scalePos;

	Command autonomousCommand;
	Command driveStraight;
	public static Command intakeClose;
	public static boolean bypassLimits = false;
	SendableChooser<Integer> chooser = new SendableChooser<>();

	public void robotInit() {
		oi = new OI();
		driveTrain = new SS_DriveTrain();
		dsOutput = new SS_DSOutput();
		sensors = new SS_Sensors();
		intake = new SS_Intake();
		lift = new SS_Lift();
		hang = new SS_Hang();

		intakeClose = new CMD_IntakeClose();

		System.out.println("Robot Init");
		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().startAutomaticCapture();

		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		chooser.addDefault("Cross AutoLine", 0);
		chooser.addObject("LeftToSwitchAuto", 1);
		chooser.addObject("RightToSwitchAuto", 2);
		chooser.addObject("CenterToSwitchAuto", 3);
		chooser.addObject("LeftToScaleAuto", 4);
		chooser.addObject("RightToScaleAuto", 5);
		chooser.addObject("FullAutoLeftPrefSwitch", 6);
		chooser.addObject("FullAutoRightPrefSwitch", 7);
		chooser.addObject("FullAutoLeftPrefScale", 8);
		chooser.addObject("FullAutoRightPrefScale", 9);

		SmartDashboard.putData("Auto mode", chooser);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		String gameData;
		{
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		}
		if (gameData != null) {
			switchPos = gameData.charAt(0);
			scalePos = gameData.charAt(1);

			int choice = chooser.getSelected();
			
			switch(choice) {
			case 0:
				autonomousCommand = new CrossLineAuto();
				break;
			case 1:
				if (switchPos == 'L') {
					autonomousCommand = new LeftToLeftSwitchAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 2:
				if (switchPos == 'R') {
					autonomousCommand = new RightToRightSwitchAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 3:
				if (switchPos == 'L') {
					autonomousCommand = new CenterToLeftSwitchAuto();
				} else if (switchPos == 'R') {
					autonomousCommand = new CenterToRightSwitchAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 4:
				if (scalePos == 'L') {
					autonomousCommand = new LeftToLeftScaleAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 5:
				if (scalePos == 'R') {
					autonomousCommand = new RightToRightScaleAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 6:
				if (switchPos == 'L') {
					autonomousCommand = new LeftToLeftSwitchAuto();
				} else if (scalePos == 'L') {
					autonomousCommand = new LeftToLeftScaleAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 7:
				if (switchPos == 'R') {
					autonomousCommand = new RightToRightSwitchAuto();
				} else if (scalePos == 'R') {
					autonomousCommand = new RightToRightScaleAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 8:
				if (scalePos == 'L') {
					autonomousCommand = new LeftToLeftScaleAuto();
				} else if (switchPos == 'L') {
					autonomousCommand = new LeftToLeftSwitchAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			case 9:
				if (scalePos == 'R') {
					autonomousCommand = new RightToRightScaleAuto();
				} else if (switchPos == 'R') {
					autonomousCommand = new RightToRightSwitchAuto();
				} else {
					autonomousCommand = new CrossLineAuto();
				}
				break;
			}

//			if (choice == 0) {
//				autonomousCommand = new CrossLineAuto();
//			} else if (choice == 1) {
//				if (switchPos == 'L') {
//					autonomousCommand = new LeftToLeftSwitchAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			} else if (choice == 2) {
//				if (switchPos == 'R') {
//					autonomousCommand = new RightToRightSwitchAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			} else if (choice == 3) {
//				if (switchPos == 'L') {
//					autonomousCommand = new CenterToLeftSwitchAuto();
//				} else if (switchPos == 'R') {
//					autonomousCommand = new CenterToRightSwitchAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			} else if (choice == 4) {
//				if (scalePos == 'L') {
//					autonomousCommand = new LeftToLeftScaleAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			} else if (choice == 5) {
//				if (scalePos == 'R') {
//					autonomousCommand = new RightToRightScaleAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			} else if (choice == 6) {
//				if (switchPos == 'L') {
//					autonomousCommand = new LeftToLeftSwitchAuto();
//				} else if (scalePos == 'L') {
//					autonomousCommand = new LeftToLeftScaleAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			} else if (choice == 7) {
//				if (switchPos == 'R') {
//					autonomousCommand = new RightToRightSwitchAuto();
//				} else if (scalePos == 'R') {
//					autonomousCommand = new RightToRightScaleAuto();
//				} else {
//					autonomousCommand = new CrossLineAuto();
//				}
//			}
	
		}
		//
			// schedule the autonomous command (example)
			if (autonomousCommand != null)
				autonomousCommand.start();

	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@SuppressWarnings("deprecation")
	public void testPeriodic() {
		LiveWindow.run();
	}
}
