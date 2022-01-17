package org.firstinspires.ftc.teamcode.OpMode.TestModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "RRFeedForwardTest", group = "OpModes")
@Config
@Disabled
public class RRFeedForwardTest extends LinearOpMode {
    public static double P = 0;
    public static double I = 0;
    public static double D = 0;
    public static double F = 0;
    public static double kV = 0;
    public static double kS = 0;
    public static double kA = 0;

    public static double setpoint = 70;

    @Override
    public void runOpMode() {
        //Robot.initTeleOp(hardwareMap, telemetry);
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
        DcMotor motor = hardwareMap.dcMotor.get("mElbow");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            PIDCoefficients pid = new PIDCoefficients(P, I, D);
            PIDFController pidf = new PIDFController(pid,kS,kV,kA);
            pidf.setTargetPosition(setpoint);
            motor.setPower(pidf.update(motor.getCurrentPosition(), (double) (motor.getCurrentPosition()/System.nanoTime())));
            telemetry.addData("Position", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}
