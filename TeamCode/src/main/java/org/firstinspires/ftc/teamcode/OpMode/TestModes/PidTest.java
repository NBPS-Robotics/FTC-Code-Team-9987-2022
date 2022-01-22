package org.firstinspires.ftc.teamcode.OpMode.TestModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.Arm;
import org.firstinspires.ftc.teamcode.Robot.Joystick;
import org.firstinspires.ftc.teamcode.Robot.Robot;

@TeleOp(name = "PidTest", group = "OpModes")
@Config
//@Disabled
public class PidTest extends LinearOpMode {
    public static double P = 0.01;
    public static double I = 0.0;
    public static double D = 0.001;
    public static double F = 0.0;

    public static double setpoint = 700;



    @Override
    public void runOpMode() {
        Robot.initTeleOp(hardwareMap, telemetry);
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
        DcMotor motor = hardwareMap.dcMotor.get("mElbow");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
        while (opModeIsActive()) {
            PIDFController pidf = new PIDFController(P, I, D, F);
            pidf.setTolerance(10);
            motor.setPower(pidf.calculate(Arm.getElbowPose(),setpoint));
            //Joystick.teleopControl(gamepad1);
            telemetry.addData("Position", Arm.getElbowPose());
            telemetry.update();
            //Robot.update();
        }
    }
}