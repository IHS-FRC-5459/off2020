package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/



public class DumbRotate extends Command {
  int direction ;
	double YawTarget = 0.0 ;
  boolean Finished = false ;

    
  
  public DumbRotate(int direction) {
    System.out.println("Auto Turn ctor");
    this.direction = direction ;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSub.ADGyro.reset();
    YawTarget = 90 * direction;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    double intensity;

    double Zangle = Robot.driveSub.ADGyro.getAngle() ;

    //calculate yaw angle remaining
    double AbsYawAngleRemaining = Math.abs(YawTarget - (Robot.driveSub.ADGyro.getAngle()));
    System.out.println("Z:" + Zangle + " Target: " + YawTarget + " Remaining"+AbsYawAngleRemaining);
    //if less than a degree, rotation is done
    if(AbsYawAngleRemaining < 12){
      intensity = 0;
      Finished = true;
      return;
    }
    //if less than 20 degrees, use quater power
    else if(AbsYawAngleRemaining < 500){
      intensity = 0.25;
    }
    //otherwisse use half power
    else{
      intensity = 0.5;
    }
    
    Robot.driveSub.setLeft(-1 * (intensity * direction));
    Robot.driveSub.setRight(intensity * direction);
    //SmartDashboard.putNumber("Gyro Angle", Robot.ADGyro.getAngle());
 
//    Finished = true ;
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
  }
}
