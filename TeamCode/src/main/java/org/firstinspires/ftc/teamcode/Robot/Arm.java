package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    //initialize the intake motor object
    public static DcMotor mArm;
    public static DcMotor mArm2;
    public static int initialPose;
    public static int currentPose;
    /**
     * This function initializes all components of the Arm subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        mArm = hardwareMap.dcMotor.get("mArm"); //arm motor assignment
        mArm2 = hardwareMap.dcMotor.get("mArm2"); //arm motor assignment
        mArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mArm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mArm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        initialPose = mArm.getCurrentPosition();
    }
    /**
     * This function stops the intake from running.
     */
    public static void stop(){
        mArm.setPower(0); //set the intake motor to power 0
        mArm2.setPower(0); //set the intake motor to power 0
    }
    /**
     * This function runs the intake at a set power.
     * @param value power at which the intake will run
     */
    public static void move(double value){
        mArm.setPower(value);
    }
    /**
     * This function runs the intake INWARDS ONLY at a set power.
     * @param value power at which the intake will run INWARDS
     */
    public static void moveUp(double value){
        move(-value);
    }
    /**
     * This function runs the intake OUTWARDS ONLY at a set power.
     * @param value power at which the intake will run OUTWARDS
     */
    public static void moveDown(double value){
        move(value);
    }

    public static void step(double value){
        mArm2.setPower(value);
    }

    public static void moveEncoder(){
        mArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mArm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mArm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        currentPose = mArm.getCurrentPosition();
        if(currentPose != initialPose){
            mArm2.setTargetPosition(currentPose-initialPose);
            mArm2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            mArm2.setPower(0.6);
            while (mArm2.isBusy()) {

            }
            mArm2.setPower(0);
            mArm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
