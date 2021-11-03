package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    public static Servo m_claw;

    public static void init(HardwareMap hardwareMap){
        m_claw = hardwareMap.servo.get("armClaw");
    }

    public static void close(){
        m_claw.setPosition(0);
    }

    public static void open(){
        m_claw.setPosition(1);
    }
}
