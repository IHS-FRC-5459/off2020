/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class RollerSub extends Subsystem {
  private TalonSRX tal5;
  private Encoder armRollerEncoder;
  
  public RollerSub(){
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  tal5 = new TalonSRX(5);
  //addChild("Tal5",tal5);
  tal5.setInverted(false);

  armRollerEncoder = new Encoder(6, 7, false, EncodingType.k4X);
  addChild("ArmRollerEncoder",armRollerEncoder);
  armRollerEncoder.setDistancePerPulse(1.0);
  armRollerEncoder.setPIDSourceType(PIDSourceType.kRate);


  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
    public void setRoller(double power){
      tal5.set(ControlMode.PercentOutput, power);
  }
}
