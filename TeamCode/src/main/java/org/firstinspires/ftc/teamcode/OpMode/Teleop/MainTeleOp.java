package org.firstinspires.ftc.teamcode.OpMode.Teleop;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.Joystick;
import org.firstinspires.ftc.teamcode.Robot.Robot;

@TeleOp(name = "MainTeleOp", group = "OpModes")
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot.initTeleOp(hardwareMap, telemetry);
        waitForStart();
            while (opModeIsActive()) {
                Robot.update();
                Joystick.teleopControl(gamepad1);
            }
    }
}