package org.firstinspires.ftc.teamcode.OpMode;

import android.annotation.SuppressLint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Trajectories.Autocode;

@Autonomous(name = "Auto Red 2", group = "Red Alliance")
public class Auto_Red_2 extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode(){
        Robot.initAuto(hardwareMap, telemetry);
        while(!opModeIsActive()) Robot.update(telemetry);
        waitForStart();
        Autocode.Red2(telemetry);
    }
}
