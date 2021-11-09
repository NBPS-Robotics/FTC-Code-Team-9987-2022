package org.firstinspires.ftc.teamcode.Robot;

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
    public static double kP_arm = 0.07;
    public static double kD_arm = 0.01;
    public static double kI_arm = 0;
    public static double kF_arm = 0.0001;

    //Elbow Motor PIDF
    public static double kP_elbow = 0.03;
    public static double kD_elbow = 0.001;
    public static double kI_elbow = 0;
    public static double kF_elbow = 0.0008;

}
