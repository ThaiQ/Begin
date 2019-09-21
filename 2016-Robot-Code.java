package org.usfirst.frc.team5027.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot { //This is where you make Variable or names for each part you going to use Robot
	RobotDrive Drive;
	//Joystick Variables
	Joystick Joy1; // The first joy stick that is inputed
	Joystick Joy2; // The second joy stick that is inputed
	//Drive Variables
	Victor frontLeftMotor;// Left wheel front
	Victor backLeftMotor;// Left wheel back
	Victor frontRightMotor;// Right wheel front
	Victor backRightMotor; // Right wheel back
	
	//Intake and Shooting Variables
	Victor BottomLeftMotor;//Bottom intake Motor
	Victor TopLeftMotor;//Top intake Motor
	Victor TopRightMotor;//Right intake Motor
	
	Timer autotimer; // Making a Variable for a timer
	int autoLoopCounter;
	//Slot Input
	 final int LFDRIVEPWM = 1;// left front
	 final int LREARPWM = 3;// left back
	 final int RFDRIVEPWM = 2; // right front
	 final int RREARPWM = 4; //right back
	 
	 final int LEFT_BOTTOMPWM = 5;
	 final int LEFT_TOPPWM = 6;
	 final int RIGHT_TOPPWM = 7;

	 
	 public void robotInit() {
		 	//Drive Code
	        frontLeftMotor = new Victor(LFDRIVEPWM); // left front
	        backLeftMotor = new Victor(LREARPWM); // left back
	        frontRightMotor = new Victor(RFDRIVEPWM); //right front
	        backRightMotor = new Victor(RREARPWM); // right back
	        
	        BottomLeftMotor = new Victor(LEFT_BOTTOMPWM);
	        TopLeftMotor = new Victor(LEFT_TOPPWM);
	        TopRightMotor = new Victor(RIGHT_TOPPWM);
	        

	        Drive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
	        Drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
	        Drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	        Drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
	        Drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	        
	        Joy1 = new Joystick(1); // The first joy stick that is inputed
	    	Joy2 = new Joystick(2); // The second joy stick that is inputed
	        
	        
	 }
	 public void autonomousInit() {
	    	autoLoopCounter = 0; //Count down code
	    	autotimer.start(); //Timer Start
	    	autotimer.reset();//Reset Timer
	    }
	
	    public void autonomousPeriodic() { //Auto Mode
	    	System.out.println("Automode");
	    	 if (autotimer.get() <= 5 )
	         {
	         	frontLeftMotor.set(-0.5);
	             backLeftMotor.set(-0.5);
	             frontRightMotor.set(0.5);
	             backRightMotor.set(0.5);
	         }
	         else
	         {
	         	frontLeftMotor.set(-0.0);
	             backLeftMotor.set(-0.0);
	             frontRightMotor.set(0.0);
	             backRightMotor.set(0.0);
	         }
	    	 Timer.delay(0.003);
}
	    public void teleopPeriodic() { //Controller Mode
	    	
	    	System.out.println("In Robot Controls"); //Print In Robot Controls when this function reach
	        
	    	Drive.arcadeDrive(Joy1); // Set first joy stick to arcade mode
	    	
	    	if (Joy1.getRawButton(1)) {
	    		BottomLeftMotor.set(1.0);
	    		TopLeftMotor.set(1.0);
	    		TopRightMotor.set(-1);
	        } else {
	        	BottomLeftMotor.set(0.0);
	        	TopLeftMotor.set(0);
	    		TopRightMotor.set(0);
	        }
	    	if (Joy1.getRawButton(2)) {
	    		BottomLeftMotor.set(0.5);
	    		TopLeftMotor.set(0.5);
	    		TopRightMotor.set(-0.5);
	        } else {
	        	BottomLeftMotor.set(0.0);
	        	TopLeftMotor.set(0);
	    		TopRightMotor.set(0);
	        }
	    	if (Joy1.getRawButton(3)){
	    		BottomLeftMotor.set(-1.0);
	    		TopLeftMotor.set(-1.0);
	    		TopRightMotor.set(1.0);
	    	}
	    	if (Joy1.getRawButton(4)){
	    		BottomLeftMotor.set(-0.5);
	    		TopLeftMotor.set(-0.5);
	    		TopRightMotor.set(0.5);
	    	}
	    }
}