package org.firstinspires.ftc.teamcode.Vision;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "OpenCV Test", group = "OpModes")
public class OpenCvTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Camera.init(hardwareMap, telemetry); //initialize the camera
        waitForStart();
        if (opModeIsActive()) {
            Camera.out(); //move the camera out
            while (opModeIsActive()) {
                telemetry.addData("[Ring Stack] >>", Camera.getHeight()); //report stack height
                telemetry.update();
            }
        }
    }
}
