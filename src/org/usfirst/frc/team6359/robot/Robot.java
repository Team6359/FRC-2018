
package org.usfirst.frc.team6359.robot;

import org.usfirst.frc.team6359.robot.commands.CMD_IntakeClose;
import org.usfirst.frc.team6359.robot.commands.ResetLiftAuto;
import org.usfirst.frc.team6359.robot.subsystems.SS_DSOutput;
import org.usfirst.frc.team6359.robot.subsystems.SS_DriveTrain;
import org.usfirst.frc.team6359.robot.subsystems.SS_Hang;
import org.usfirst.frc.team6359.robot.subsystems.SS_Intake;
import org.usfirst.frc.team6359.robot.subsystems.SS_Lift;
import org.usfirst.frc.team6359.robot.subsystems.SS_Sensors;

import edu.wpi.first.wpilibj.CameraServer;
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

	Command autonomousCommand;
	Command driveStraight;
	public static Command intakeClose;
	public static boolean bypassLimits = false;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
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
		
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		chooser.addDefault("Reset Lift Auto", new ResetLiftAuto());
		SmartDashboard.putData("Auto mode", chooser);
		
	
	}

	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

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
