package org.firstinspires.ftc.teamcode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.Arm;
import org.firstinspires.ftc.teamcode.Robot.Robot;
@TeleOp(name = "ArmTest", group = "OpModes")
public class ArmTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot.initTeleOp(hardwareMap, telemetry);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Arm", Arm.getArmPose());
            telemetry.addData("Elbow", Arm.getElbowPose());
            telemetry.update();

        }
    }
}
