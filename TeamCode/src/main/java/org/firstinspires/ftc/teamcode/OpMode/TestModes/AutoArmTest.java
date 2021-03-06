package org.firstinspires.ftc.teamcode.OpMode.TestModes;


import android.annotation.SuppressLint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Trajectories.Autocode;
import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;

@Autonomous(name = "Auto Arm Test", group = "OpModes")
public class AutoArmTest extends LinearOpMode {
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode(){
        Robot.initAuto(hardwareMap, telemetry, Coordinates.blueStart1);
        waitForStart();
        Autocode.raiseArm("Right");
    }
}
