/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class indexMove extends Command { 

  boolean isFinished;

  public indexMove() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean indArry[] = Robot.armSub.getSwitch();

    if(indArry[3] == true)
    {
      //Robot.driveSub.moveBalls(0.1);
      if(indArry[3])
      {
        //Robot.driveSub.moveBalls(0);
        SmartDashboard.putBoolean("4th Spot Full?", indArry[3]);
      }
    }

    if(indArry[2] == true)
    {
      //Robot.driveSub.moveBalls(0.1);
      if(indArry[2])
      {
        //Robot.driveSub.moveBalls(0);
        SmartDashboard.putBoolean("3rd Spot Full?", indArry[2]);
      }

    }

    if(indArry[1] == true)
    {
      //Robot.driveSub.moveBalls(0.1);
      if(indArry[1])
      {
        //Robot.driveSub.moveBalls(0);
        SmartDashboard.putBoolean("2nd Spot Full?", indArry[1]);
      }

    }

    if(indArry[0] == true)
    {
      //Robot.driveSub.moveBalls(0.1);
      if(indArry[0])
      {
        //Robot.driveSub.moveBalls(0);
        SmartDashboard.putBoolean("1st Spot Full?", indArry[0]);
      }

    }

    if(indArry[0] == true || indArry[1] == true || indArry[2] == true || indArry[3] == true || indArry[4] == true)
    {
      SmartDashboard.putString("Are All Spots Full:", "Yes, all spots ared full!");
      isFinished = true;
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.driveSub.moveBalls(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
