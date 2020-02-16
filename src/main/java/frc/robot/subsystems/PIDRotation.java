/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Add your docs here.
 */
public class PIDRotation extends PIDSubsystem {

    public PIDRotation(double p, double i, double d)
    {
        super(p,i,d);
    }

    @Override 
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub
        
    }

    @Override 
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }


}
