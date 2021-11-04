package org.firstinspires.ftc.teamcode.OpMode;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.Joystick;
import org.firstinspires.ftc.teamcode.Robot.Robot;

@TeleOp(name = "PidTest", group = "OpModes")
public class PidTest extends LinearOpMode {
    int kP = 0;
    int kI = 0;
    int kD = 0;
    int kF = 0;
    PIDFController pidf = new PIDFController(kP, kI, kD, kF);

    @Override
    public void runOpMode() {
        //Robot.initTeleOp(hardwareMap, telemetry);
        DcMotor motor = hardwareMap.dcMotor.get("mArm");
        waitForStart();
        while (opModeIsActive()) {
            //Robot.update(telemetry);
            //Joystick.teleopControl(gamepad1, opModeIsActive());
            motor.setPower(pidf.calculate(motor.getCurrentPosition(),10));
        }
    }
}