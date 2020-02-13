// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class ArmSub extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private TalonSRX tal5;
private TalonSRX tal6;
private Encoder armRollerEncoder;
private Encoder armConveyorEncoder;
private DigitalInput lim1;
private DigitalInput lim2;
private DigitalInput lim3;
private DigitalInput lim4;
private DigitalInput lim5;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public ArmSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
tal5 = new TalonSRX(5);
//addChild("Tal5",tal5);
tal5.setInverted(false);
        
tal6 = new TalonSRX(6);
//addChild("Tal6",tal6);
tal6.setInverted(false);
        
armRollerEncoder = new Encoder(6, 7, false, EncodingType.k4X);
addChild("ArmRollerEncoder",armRollerEncoder);
armRollerEncoder.setDistancePerPulse(1.0);
armRollerEncoder.setPIDSourceType(PIDSourceType.kRate);
        
armConveyorEncoder = new Encoder(8, 9, false, EncodingType.k4X);
addChild("ArmConveyorEncoder",armConveyorEncoder);
armConveyorEncoder.setDistancePerPulse(1.0);
armConveyorEncoder.setPIDSourceType(PIDSourceType.kRate);
        
lim1 = new DigitalInput(10);
addChild("Lim1",lim1);

        
lim2 = new DigitalInput(11);
addChild("Lim2",lim2);

        
lim3 = new DigitalInput(12);
addChild("Lim3",lim3);

        
lim4 = new DigitalInput(13);
addChild("Lim4",lim4);

        
lim5 = new DigitalInput(14);
addChild("Lim5",lim5);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // gets if the 5 limit switches are pressed (or not) and returns those outputs in a boolean array
    public boolean[] getSwitch()
    {
        boolean[] switches = new boolean[4];
        switches[0] = lim1.get();
        switches[1] = lim2.get();
        switches[2] = lim3.get();
        switches[3] = lim4.get();
        switches[4] = lim5.get();
        return switches;
    }





    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

