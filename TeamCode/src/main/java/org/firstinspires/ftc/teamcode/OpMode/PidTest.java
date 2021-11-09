package org.firstinspires.ftc.teamcode.OpMode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "PidTest", group = "OpModes")
@Config
@Disabled
public class PidTest extends LinearOpMode {
    public static double P = 0.01;
    public static double I = 0.0;
    public static double D = 0.001;
    public static double F = 0.0;
    PIDFController pidf = new PIDFController(P, I, D, F);

    @Override
    public void runOpMode() {
        //Robot.initTeleOp(hardwareMap, telemetry);
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
        DcMotor motor = hardwareMap.dcMotor.get("mElbow");
        waitForStart();
        while (opModeIsActive()) {
            //Robot.update(telemetry);
            //Joystick.teleopControl(gamepad1, opModeIsActive());
            motor.setPower(pidf.calculate(motor.getCurrentPosition(),80));
            telemetry.addData("Position", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}