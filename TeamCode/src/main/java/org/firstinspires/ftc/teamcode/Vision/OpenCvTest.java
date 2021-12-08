package org.firstinspires.ftc.teamcode.Vision;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.Robot;

@TeleOp(name = "OpenCV Test", group = "OpModes")
//@Disabled
public class OpenCvTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Camera.init(hardwareMap, telemetry); //initialize the camera
        telemetry.addData("Camera Ready", ""); //report camera working
        telemetry.update();
        waitForStart();
        if (opModeIsActive()) {
            Robot.wait(1000);
            String position = Camera.getTeamElementPosition("Left");
            telemetry.addData("Position", position);
            telemetry.update();
            while (opModeIsActive()) {

            }
        }
    }
}
