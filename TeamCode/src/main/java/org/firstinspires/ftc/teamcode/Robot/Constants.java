package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;

@Config
public class Constants {
    /*
    Declare all constants in this class to be used globally
     */

    public static final double baseVoltage = 13.5; //EDIT THIS TO CHANGE THE BASE VOLTAGE
    public static double speed = 1; //Speed Control
    public static double slowSpeed = 0.4;
    public static double targetSpinnerPower = 0.7;    //EDIT THIS TO CHANGE THE POWER OF THE SHOOTER
    public static final double turnPower = 0.9; //Turning Power
    public static final double spinnerConstant = baseVoltage*targetSpinnerPower;

    public static double armPowerUp = 0.5;
    public static double armPowerDown = 0.7;
    //Arm positions
    public static int arm3 = 2300;
    public static int elbow3 = 650;
    public static int arm2 = 2900;
    public static int elbow2 = 1100;
    public static int arm1 = 3250;
    public static int elbow1 = 1000;
    public static int armCap = 1300;
    public static int elbowCap = 750;
    public static int elbowUp = -1400;

    //Arm Motor PIDF
    public static double KP_arm = 0.002;
    public static double KD_arm = 0.0001;
    public static double KI_arm = 0.0001;
    public static double KF_arm = 0;

    //Elbow Motor PIDF
    public static double KP_elbow = 0.01;
    public static double KD_elbow = 0.003;
    public static double KI_elbow = 0.005;
    public static double KF_elbow = 0.002;

    //Spinner Motor PIDF
    //public static double KP_spinner = 0;
    //public static double KD_spinner = 0;
    //public static double KI_spinner = 0;
    //public static double KF_spinner = 0;

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
