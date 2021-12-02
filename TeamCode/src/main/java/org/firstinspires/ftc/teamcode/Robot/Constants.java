package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.dashboard.config.Config;

@Config
public class Constants {
    /*
    Declare all constants in this class to be used globally
     */

    public static final double baseVoltage = 13.5; //EDIT THIS TO CHANGE THE BASE VOLTAGE
    public static double speed = 1; //Speed Control
    public static double targetSpinnerPower = 0.48;    //EDIT THIS TO CHANGE THE POWER OF THE SHOOTER
    public static final double turnPower = 0.7; //Turning Power
    public static final double spinnerConstant = baseVoltage*targetSpinnerPower;

    //Arm Motor PIDF
    public static double KP_arm = 0.002;
    public static double KD_arm = 0.0001;
    public static double KI_arm = 0.0001;
    public static double KF_arm = 0;

    //Elbow Motor PIDF
    public static double KP_elbow = 0.003;
    public static double KD_elbow = 0.000;
    public static double KI_elbow = 0.00;
    public static double KF_elbow = 0.0008;

    //Spinner Motor PIDF
    public static double KP_spinner = 0;
    public static double KD_spinner = 0;
    public static double KI_spinner = 0;
    public static double KF_spinner = 0;

    //Spinner Motor PIDF
    public static double KP_claw = 0.005;
    public static double KD_claw = 0;
    public static double KI_claw = 0;
    public static double KF_claw = 0;

    //ticks per revolution
    public static double armCPR = 4200;
    public static double elbowCPR = 288;
    public static double CPR_multiplier = armCPR/elbowCPR;
}
