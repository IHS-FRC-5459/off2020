/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveStraightEncoder extends Command {

  double targetDistance;
	double currentDistance;
	boolean finished;
  double targetIntensity;

  public DriveStraightEncoder(double intensity, double inches) {
    targetIntensity = intensity;
    targetDistance = inches;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSub.ADGyro.reset();
    Robot.driveSub.resetRightEncoder();
    System.out.println("going to forwardBlind");
    
    finished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {



    double yaw = Robot.driveSub.ADGyro.getAngle();
    

    
    double yawIntensity = yaw / 100;



    //double averageDistance = ((Robot.drive.getLeftEncoder() + Robot.drive.getRightEncoder()) / 2);
    
    //assume 180 ticks for 1 rotation
    //for 3 feet, wheel diameter is 4 in
    //2.86 rotations
    
    double distanceRemaining = targetDistance - (Robot.driveSub.getRightEncoderDistance()/14.3);
    double debugDist = Robot.driveSub.getRightEncoderDistance();


    

    Robot.driveSub.setLeft(targetIntensity - yawIntensity);
    Robot.driveSub.setRight(targetIntensity + yawIntensity);
     if (distanceRemaining < 0)
     {
       finished = true;
     }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("drive to is finished");
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
