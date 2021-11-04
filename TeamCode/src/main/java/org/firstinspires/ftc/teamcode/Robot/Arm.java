package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    //initialize the intake motor object
    public static DcMotor mArm;
    public static DcMotor mElbow;
    public static int currentPose;
    public static int armPose;
    public static int elbowPose;

    /**
     * This function initializes all components of the Arm subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        mArm = hardwareMap.dcMotor.get("mArm"); //arm motor assignment
        mElbow = hardwareMap.dcMotor.get("mElbow"); //arm motor assignment
        mArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mElbow.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mElbow.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    /**
     * This function stops the intake from running.
     */
    public static void stop(){
        mArm.setPower(0); //set the intake motor to power 0
        mElbow.setPower(0); //set the intake motor to power 0
    }
    /**
     * This function runs the intake at a set power.
     * @param value power at which the intake will run
     */
    public static void moveEncoder(int value, double power, DcMotor motor, boolean OpMode){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setTargetPosition(value);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(power);
    }
    /**
     * This function runs the intake INWARDS ONLY at a set power.
     * @param value power at which the intake will run INWARDS
     */
    public static void moveArm(int value, boolean OpMode){
        moveEncoder(value, 1, mArm, OpMode);
        armPose = mArm.getCurrentPosition();
    }
    /**
     * This function runs the intake OUTWARDS ONLY at a set power.
     * @param value power at which the intake will run OUTWARDS
     */
    public static void moveElbow(int value, boolean OpMode){
        moveEncoder(value, 1 , mElbow, OpMode);
        elbowPose = mElbow.getCurrentPosition();
    }

    public static void correctEncoder(int targetPose, double power, DcMotor motor, boolean OpMode){
        currentPose = motor.getCurrentPosition();
        if(currentPose != targetPose & OpMode) {
            motor.setTargetPosition(currentPose - targetPose);
            motor.setPower(power);
        }
            else{
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }

    }

    public static void correctArm(boolean OpMode){
        correctEncoder(armPose, 1, mArm, OpMode);
    }

    public static void correctElbow(boolean OpMode){
        correctEncoder(elbowPose, 1, mElbow, OpMode);
    }

}
