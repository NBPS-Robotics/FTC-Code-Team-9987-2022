package org.firstinspires.ftc.teamcode.OpMode.Autonomous;

import android.annotation.SuppressLint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Trajectories.Autocode;
import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;
import org.firstinspires.ftc.teamcode.Vision.Camera;

@Autonomous(name = "Auto Blue2 - Score, Clear Warehouse", group = "!Blue Alliance")
public class Auto_Blue2_Score_Clear_Warehouse extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode(){
        Robot.initAuto(hardwareMap, telemetry, Coordinates.blueStart2);
        waitForStart();
        Robot.wait(1000);
        String position = Camera.getTeamElementPosition("Left");
        telemetry.addData("Position", position);
        telemetry.update();
        Autocode.Blue2ClearWarehouse(telemetry, position);
    }
}