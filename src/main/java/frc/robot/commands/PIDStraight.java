/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;


public class PIDStraight extends PIDCommand {
  double dist;
  public PIDStraight(double theDist) {

    super("PIDStraight", 1.0, 0.0, 0.0, 0.02);
    getPIDController().setContinuous(false);
    getPIDController().setAbsoluteTolerance(0.5);
    getPIDController().setSetpoint(theDist);
    getPIDController().setOutputRange(-0.25, 0.25);
    dist = theDist;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveSub);
  }



  
  @Override
  protected double returnPIDInput() {
      // Return your input value for the PID loop
      // e.g. a sensor, like a potentiometer:
      // yourPot.getAverageVoltage() / kYourMaxVoltage;

      // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
      
      double distTraveled = Robot.driveSub.getRightEncoderDistance()/18.849;
      return distTraveled;

      //may be getting wrong thing, check later

      // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
  }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

  
    }

  @Override
  protected void usePIDOutput(double output) {
      // Use output to drive your system, like a motor
      // e.g. yourMotor.set(output);

      double yaw = Robot.driveSub.ADGyro.getAngle();
    
      
  
      
      double yawIntensity = yaw / 100;

      System.out.println("Yaw:" + yaw + " Intensity: " + yawIntensity);



      Robot.driveSub.setRight(output - yawIntensity);
      Robot.driveSub.setLeft(output + yawIntensity);
      // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT

      // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
  }



  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSub.resetLeftEncoder();
    Robot.driveSub.resetRightEncoder();
    Robot.driveSub.ADGyro.reset();

    
  }



  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    double RemainingDistance = dist - (Robot.driveSub.getRightEncoderDistance());
    System.out.println(RemainingDistance + "Remaining Distance");
    if(RemainingDistance <= 0)
    {
      System.out.println("finished move forward");
      return true;
    }else{
      System.out.println("has moved:" + (Robot.driveSub.getRightEncoderDistance()) + "in");

      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    getPIDController().disable();
    Robot.driveSub.setRight(0);
    Robot.driveSub.setLeft(0);
    Robot.driveSub.ADGyro.reset();
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
