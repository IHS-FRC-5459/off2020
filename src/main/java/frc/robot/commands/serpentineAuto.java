/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class serpentineAuto extends CommandGroup {
  public boolean sideRight;
  /**
   * Creates a new SerpentineAuto.
   */
  public serpentineAuto(boolean fromRight) {
      fromRight = sideRight;
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    //super();
    addSequential(new DriveStraightEncoder(0.25, 60));

    if(fromRight)
    {
      addSequential(new RotatePID(-90));
      addSequential(new DriveStraightEncoder(0.25, 60));
      addSequential(new RotatePID(90));
    }else{
      addSequential(new RotatePID(90));
      addSequential(new DriveStraightEncoder(0.25, 60));
      addSequential(new RotatePID(-90));

    }

    addSequential(new DriveStraightEncoder(0.25, 60));


  }
}
