/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateToAngle extends Command {
  int direction ;
  double baseIntensity = 0.0;
	double YawTarget = 0.0 ;
  boolean Finished = false ;

  public RotateToAngle(double theYaw, double theIntensity) {
    System.out.println("Rotate Constructor Worked");
    YawTarget = theYaw;
    baseIntensity = theIntensity;

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Robot Init Rotate");
    Robot.driveSub.ADGyro.reset();
    if(YawTarget > 0)
    {
      direction = -1;
    }else{
      direction = 1;
    }
    
  }



  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double intensity;

    double Zangle = Robot.driveSub.ADGyro.getAngle() ;

    //calculate yaw angle remaining

    double AbsYawAngleRemaining = Math.abs(YawTarget - (Robot.driveSub.ADGyro.getAngle()));
    
    
    //if less than a degree, rotation is done
    
    if(AbsYawAngleRemaining < 12){
      Finished = true;
      return;
    }
    //if less than 20 degrees, use quarter power
    else if(AbsYawAngleRemaining < 500){
      intensity = 0.25;
    }
    //otherwisse use half power
    else{
      intensity = 0.5;
    }


    
    Robot.driveSub.setLeft(intensity * direction);
    Robot.driveSub.setRight(-1 * (intensity * direction));
 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSub.setLeft(0);
    Robot.driveSub.setRight(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
