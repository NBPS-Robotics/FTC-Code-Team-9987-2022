package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw {
    public static DcMotor m_claw;
    public static double clawPose; //false for open, true for closed
    static PIDFController clawPid = new PIDFController(Constants.KP_claw, Constants.KI_claw, Constants.KD_claw, Constants.KF_claw);

    public static void init(HardwareMap hardwareMap){
        m_claw = hardwareMap.dcMotor.get("mClaw");
        clawPose = 0;
        setClaw(0);
    }

    public static void close(){
        clawPose = -120;
    }

    public static void open(){
        clawPose = 40;
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
        return m_claw.getCurrentPosition();
    }

    public static void correctClaw(){
        m_claw.setPower(clawPid.calculate(getClawPose(),clawPose));
    }
}
