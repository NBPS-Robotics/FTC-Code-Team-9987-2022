package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.profile.MotionProfile;
import com.acmerobotics.roadrunner.profile.MotionProfileGenerator;
import com.acmerobotics.roadrunner.profile.MotionState;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    //initialize the intake motor object
    static DcMotor mArm;
    static DcMotor mElbow;
    static int armPose = 0;
    static int elbowPose = 0;

    static PIDFController armPid = new PIDFController(Constants.KP_arm, Constants.KI_arm, Constants.KD_arm, Constants.KF_arm);
    static PIDFController elbowPid = new PIDFController(Constants.KP_elbow, Constants.KI_elbow, Constants.KD_elbow, Constants.KF_elbow);

    static com.acmerobotics.roadrunner.control.PIDFController newArmPid = new com.acmerobotics.roadrunner.control.PIDFController(new PIDCoefficients(Constants.KP_arm, Constants.KI_arm, Constants.KD_arm));

    static MotionProfile armProfile;

    static MotionState armState;
    /**;
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
        armPose = Constants.armDown;
        elbowPose = Constants.elbowDown;
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
        /*
        armProfile = MotionProfileGenerator.generateSimpleMotionProfile(new MotionState(0,0,0), new MotionState(armPose,0, 0), Constants.armMaxVelocity, Constants.armMaxAcceleration, Constants.armMaxJerk);
        armState = armProfile.get(Robot.timeSeconds());
        newArmPid.setTargetPosition(armState.getX());
        newArmPid.setTargetVelocity(armState.getV());
        newArmPid.setTargetAcceleration(armState.getA());
        mArm.setPower(newArmPid.update(getArmPose()));
        */
        double power = armPid.calculate(getArmPose(),armPose);
        if (power > Constants.armPowerDown) power = Constants.armPowerDown;
        else if (power < - Constants.armPowerUp) power = - Constants.armPowerUp;
        mArm.setPower(power);
    }

    public static void correctElbow(){
        if(getElbowPose() < 30 && getElbowPose() > -30) mElbow.setPower(0);
        else mElbow.setPower(elbowPid.calculate(getElbowPose(),elbowPose));
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
