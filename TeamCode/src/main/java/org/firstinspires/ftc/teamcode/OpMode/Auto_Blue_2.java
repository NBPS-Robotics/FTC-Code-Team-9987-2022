package org.firstinspires.ftc.teamcode.OpMode;

import android.annotation.SuppressLint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Trajectories.Autocode;
import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;

@Autonomous(name = "Auto Blue 2", group = "Blue Alliance")
public class Auto_Blue_2 extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode(){
        Robot.initAuto(hardwareMap, telemetry, Coordinates.blueStart2);
        while(!opModeIsActive()) Robot.update(telemetry);
        waitForStart();
        Autocode.Blue2(telemetry);
    }
}
