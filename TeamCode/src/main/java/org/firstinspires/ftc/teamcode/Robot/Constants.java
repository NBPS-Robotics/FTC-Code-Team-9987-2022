package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.dashboard.config.Config;

@Config
public class Constants {
    /*
    Declare all constants in this class to be used globally
     */

    public static final double baseVoltage = 13.5; //EDIT THIS TO CHANGE THE BASE VOLTAGE
    public static double speed = 1; //Speed Control
    public static double targetShooterPower = 0.46;    //EDIT THIS TO CHANGE THE POWER OF THE SHOOTER
    public static final double targetShotPower = 0.39; //EDIT THIS TO CHANGE THE POWER OF THE SHOOTER FOR THE POWER SHOT
    public static final double turnPower = 0.7; //Turning Power
    public static final double powerConstant = baseVoltage*targetShooterPower;
    public static final double shotConstant = baseVoltage*targetShotPower;
    public static final double powerShotTurn = 5.5;

    //Arm Motor PIDF
    public static double KP_arm = 0.002;
    public static double KD_arm = 0.0001;
    public static double KI_arm = 0.0001;
    public static double KF_arm = 0;

    //Elbow Motor PIDF
    public static double KP_elbow = 0.07;
    public static double KD_elbow = 0.01;
    public static double KI_elbow = 0.0001;
    public static double KF_elbow = 0.0008;

    //ticks per revolution
    public static double armCPR = 4200;
    public static double elbowCPR = 288;
    public static double CPR_multiplier = armCPR/elbowCPR;
}
