package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
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

        mElbow.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mElbow.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armPose = 0;
        elbowPose = 0;
        setArm(0);
        setElbow(0);
    }

    public static void update(){
        correctArm();
        correctElbow();
        Robot.tele.addData("Arm", Arm.getArmPose());
        Robot.tele.addData("Elbow", Arm.getElbowPose());
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
        armPose = -100;
        elbowPose = 0;
    }

    public static void capElement(){
        armPose = Constants.armCap;
        elbowPose = Constants.elbowCap;
    }
    public static void scoreTop(){
        armPose = Constants.arm3;
        elbowPose = Constants.elbow3;
    }
    public static void scoreMiddle(){
        armPose = Constants.arm2;
        elbowPose = Constants.elbow2;
    }
    public static void scoreBottom(){
        armPose = Constants.arm1;
        elbowPose = Constants.elbow1;
    }

    public static int getArmPose(){
        return mArm.getCurrentPosition();
    }

    public static int getElbowPose(){
        return (int) (mElbow.getCurrentPosition()*Constants.CPR_multiplier);
    }

    public static void correctArm(){
        double power = armPid.calculate(getArmPose(),armPose);
        if (power > Constants.armPowerDown) power = Constants.armPowerDown;
        else if (power < - Constants.armPowerUp) power = - Constants.armPowerUp;
        mArm.setPower(power);
    }

    public static void correctElbow(){
        mElbow.setPower(elbowPid.calculate(getElbowPose(),elbowPose));
    }

    public static void armUpAuto(){
        armPid.setSetPoint(armPose);
        elbowPid.setSetPoint(elbowPose);
        while (!armPid.atSetPoint() && !elbowPid.atSetPoint()) {
            correctArm();
            correctElbow();
        }
    }
    public static void armDownAuto(){
        Arm.pickUp();

        while(Arm.getArmPose()<=-100){
            Arm.update();
        }
    }

    public static void elbowUpAuto(){
        elbowPose = Constants.elbowUp;
    }
}
