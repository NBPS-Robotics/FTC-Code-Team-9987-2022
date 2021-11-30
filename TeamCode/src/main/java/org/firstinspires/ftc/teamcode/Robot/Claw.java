package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    public static DcMotor m_claw;
    public static boolean clawPose = false; //false for open, true for closed

    public static void init(HardwareMap hardwareMap){
        m_claw = hardwareMap.dcMotor.get("mClaw");
        clawPose = false;
    }

    public static void close(){
        clawPose = true;
    }

    public static void open(){
        clawPose = false;
    }

    public static void update(){
        if(clawPose) m_claw.setPower(-0.5);
        else m_claw.setPower(0.3);
    }

}
