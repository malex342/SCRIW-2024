// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//this whole file works fine. no issues here. /gen 
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.math.MathUtil;
import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.OperatorConstants.JOYSTICK_PORT;

import frc.robot.RobotContainer;


public class DriveSystem extends SubsystemBase {

  private  CANSparkMax frontLeft;
  private  CANSparkMax rearLeft;
  private  CANSparkMax frontRight;
  private  CANSparkMax rearRight;
  private MecanumDrive mecanumDrive;

  private Joystick joy;

  /** Creates a new DriveSystem. */
  public DriveSystem() {

    frontLeft = new CANSparkMax(FRONTLEFT, MotorType.kBrushless);
    rearLeft = new CANSparkMax(REARLEFT, MotorType.kBrushless);
    frontRight = new CANSparkMax(FRONTRIGHT, MotorType.kBrushless);
    rearRight = new CANSparkMax(REARRIGHT, MotorType.kBrushless);
    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    joy = new Joystick(JOYSTICK_PORT);
    frontRight.setInverted(true);
    rearRight.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void drive(double xVelocity, double yVelocity, double rotationVelocity) {
    mecanumDrive.driveCartesian(yVelocity, xVelocity, rotationVelocity);
  }
  public void stopDrive() {
    frontLeft.stopMotor();
    frontRight.stopMotor();
    rearLeft.stopMotor();
    rearRight.stopMotor();
  }

public DriveSystem DriveSystem() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'DriveSystem'");
}
}

