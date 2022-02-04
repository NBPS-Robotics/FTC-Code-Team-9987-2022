package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw {
    public static DcMotor mClaw;
    public static double clawPose; //false for open, true for closed
    static PIDFController clawPid = new PIDFController(Constants.KP_claw, Constants.KI_claw, Constants.KD_claw, Constants.KF_claw);

    public static void init(HardwareMap hardwareMap){
        mClaw = hardwareMap.dcMotor.get("mClaw");
        //mClaw.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //mClaw.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //mClaw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        clawPose = 0;
        setClaw(0);
    }

    public static void close(){
        clawPose = 120;
    }

    public static void open(){
        clawPose = -100;
    }

    public static void update(){
        //if(clawPose) m_claw.setPower(-0.5);
        //else m_claw.setPower(0.3);
        correctClaw();
        Robot.tele.addData("Claw", Claw.getClawPose());
    }

    public static void setClaw(int targetPose){
        clawPose += targetPose;
        //if(armPose< -1000) elbowPose = armPose;
        //else elbowPose = -armPose - 2000;
    }
    public static int getClawPose(){
        return mClaw.getCurrentPosition();
    }

    public static void correctClaw(){
        mClaw.setPower(clawPid.calculate(getClawPose(),clawPose));
    }
}
