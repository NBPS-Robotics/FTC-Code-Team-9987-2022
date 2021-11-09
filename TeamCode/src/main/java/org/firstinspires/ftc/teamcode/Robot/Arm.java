package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    //initialize the intake motor object
    static DcMotor mArm;
    static DcMotor mElbow;
    static int armPose = 0;
    static int elbowPose = 0;

    static PIDFController armPid = new PIDFController(Constants.kP_arm, Constants.kI_arm, Constants.kD_arm, Constants.kF_arm);
    static PIDFController elbowPid = new PIDFController(Constants.kP_elbow, Constants.kI_elbow, Constants.kD_elbow, Constants.kF_elbow);
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
     * This function runs the intake INWARDS ONLY at a set power.
     * @param value power at which the intake will run INWARDS
     */
    public static void setArm(int targetPose){
        armPose += targetPose;
    }
    /**
     * This function runs the intake OUTWARDS ONLY at a set power.
     * @param value power at which the intake will run OUTWARDS
     */
    public static void setElbow(int targetPose){
        elbowPose += targetPose;
    }

    public static void correctArm(){
        mArm.setPower(armPid.calculate(mArm.getCurrentPosition(),armPose));
    }

    public static void correctElbow(){
        mElbow.setPower(elbowPid.calculate(mElbow.getCurrentPosition(),elbowPose));
    }

}
