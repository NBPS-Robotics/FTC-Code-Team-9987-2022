package org.firstinspires.ftc.teamcode.OpMode.TestModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.arcrobotics.ftclib.controller.wpilibcontroller.SimpleMotorFeedforward;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "FeedForwardTest", group = "OpModes")
@Config
@Disabled
public class FeedForwardTest extends LinearOpMode {
    public static double kV = 0.01;
    public static double kS = 0.01;
    public static double kA = 0.001;
    ArmFeedforward pidf = new ArmFeedforward(kS,kV,kA);

    @Override
    public void runOpMode() {
        //Robot.initTeleOp(hardwareMap, telemetry);
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
        DcMotor motor = hardwareMap.dcMotor.get("mArm");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            motor.setPower(pidf.calculate(-1000,1));
            telemetry.addData("Position", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}