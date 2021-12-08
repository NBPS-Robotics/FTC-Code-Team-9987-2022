package org.firstinspires.ftc.teamcode.Vision;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "OpenCV Test", group = "OpModes")
//@Disabled
public class OpenCvTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Camera.init(hardwareMap, telemetry); //initialize the camera
        telemetry.addData("Camera Ready", ""); //report stack height
        telemetry.update();
        waitForStart();
        if (opModeIsActive()) {
            telemetry.addData("Duck Position", Camera.getPosition(telemetry)); //report stack height
            telemetry.update();
            while (opModeIsActive()) {

            }
        }
    }
}
