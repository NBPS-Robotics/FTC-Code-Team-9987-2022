package org.firstinspires.ftc.teamcode.OpMode.TestModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "FeedForwardTest", group = "OpModes")
@Config
@Disabled
public class FeedForwardTest extends LinearOpMode {
    public static double kV = 0.01;
    public static double kS = 0.001;
    public static double kA = 0.001;

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
            ArmFeedforward pidf = new ArmFeedforward(kS,kV,kA);
            motor.setPower(pidf.calculate(70,1, 1));
            telemetry.addData("Position", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}