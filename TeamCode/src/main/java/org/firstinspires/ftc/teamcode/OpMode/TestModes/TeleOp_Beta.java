package org.firstinspires.ftc.teamcode.OpMode.TestModes;

//THIS IS A BETA VERSION FOR THE TELEOP CODE! ALL TESTINGS OCCUR HERE. NOT FOR USE IN COMPETITIONS!

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.Joystick;
import org.firstinspires.ftc.teamcode.Robot.Robot;
@Disabled
@TeleOp(name = "TeleOp_Beta", group = "OpModes")
public class TeleOp_Beta extends LinearOpMode {
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