package org.firstinspires.ftc.teamcode.OpMode;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.Drivetrain;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Trajectories.Autocode;
import org.firstinspires.ftc.teamcode.Vision.Camera;

@Autonomous(name = "MainAuto", group = "OpModes")

public class MainAuto extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode(){
        Robot.initAuto(hardwareMap, telemetry);
        waitForStart();
        //Autocode.moveLeft();
        Drivetrain.fieldCentricDrive(0,0.5,0);
        Robot.wait(3000);

        Drivetrain.stop();
    }
}


