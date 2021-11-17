package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    public static DcMotor m_claw;

    public static void init(HardwareMap hardwareMap){
        m_claw = hardwareMap.dcMotor.get("mClaw");
    }

    public static void close(){
        m_claw.setPower(1);
    }

    public static void open(){
        m_claw.setPower(-1);
    }
}
