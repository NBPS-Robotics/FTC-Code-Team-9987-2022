package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    //initialize the intake motor object
    static DcMotor mArm;
    static DcMotor mElbow;
    static int armPose = 0;
    static int elbowPose = 0;

    static PIDFController armPid = new PIDFController(Constants.KP_arm, Constants.KI_arm, Constants.KD_arm, Constants.KF_arm);
    static PIDFController elbowPid = new PIDFController(Constants.KP_elbow, Constants.KI_elbow, Constants.KD_elbow, Constants.KF_elbow);
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
        armPose = 0;
        elbowPose = 0;
        setArm(0);
        setElbow(0);
    }

    public static void update(Telemetry telemetry){
        correctArm();
        correctElbow();
        telemetry.addData("Arm", Arm.getArmPose());
        telemetry.addData("Elbow", Arm.getElbowPose());
    }
    /**
     * This function stops the intake from running.
     */
    public static void stop(){
        mArm.setPower(0); //set the intake motor to power 0
        mElbow.setPower(0); //set the intake motor to power 0
    }
    /**
     * This function runs the intake INWARDS ONLY at a set power.
     * @param  targetPose at which the intake will run INWARDS
     */
    public static void setArm(int targetPose){
        armPose += targetPose;
        //if(armPose< -1000) elbowPose = armPose;
        //else elbowPose = -armPose - 2000;
    }
    /**
     * This function runs the intake OUTWARDS ONLY at a set power.
     * @param targetPose power at which the intake will run OUTWARDS
     */
    public static void setElbow(int targetPose){
        elbowPose += targetPose;
    }

    public static void pickUp(){
        armPose = -20;
        elbowPose = -5;
    }

    public static void score(){
        armPose = -2650;
        elbowPose = 650;
    }
    public static int getArmPose(){
        return mArm.getCurrentPosition();
    }

    public static int getElbowPose(){
        return (int) (mElbow.getCurrentPosition()*Constants.CPR_multiplier);
    }


    public static void correctArm(){
        mArm.setPower(armPid.calculate(getArmPose(),armPose));
    }

    public static void correctElbow(){
        mElbow.setPower(elbowPid.calculate(getElbowPose(),elbowPose));
    }

}
