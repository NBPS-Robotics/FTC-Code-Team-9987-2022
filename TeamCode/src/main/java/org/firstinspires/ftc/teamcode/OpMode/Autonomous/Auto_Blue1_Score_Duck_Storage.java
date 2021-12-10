package org.firstinspires.ftc.teamcode.OpMode.Autonomous;

import android.annotation.SuppressLint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Trajectories.Autocode;
import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;
import org.firstinspires.ftc.teamcode.Vision.Camera;

@Autonomous(name = "Auto Blue1 - Score, Duck, Storage", group = "!Blue Alliance")
public class Auto_Blue1_Score_Duck_Storage extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode(){
        Robot.initAuto(hardwareMap, telemetry, Coordinates.blueStart1);
        waitForStart();
        Robot.wait(1000);
        String position = Camera.getTeamElementPosition("Right");
        telemetry.addData("Position", position);
        telemetry.update();
        Autocode.Blue1(position);
    }
}
