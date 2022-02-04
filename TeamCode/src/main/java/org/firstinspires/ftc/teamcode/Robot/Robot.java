package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Mecanum_Drive.MyMecanumDrive;
import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;
import org.firstinspires.ftc.teamcode.Vision.Camera;

public class Robot {
    //create the Mecanum Drive object for Road Runner
    public static MyMecanumDrive drive;
    //create the telemetry object to use for debugging with telemetry
    public static Telemetry tele;

    public static ElapsedTime clock  = new ElapsedTime();
    /**
     * This function initializes all parts of the robot by configuring the HardwareMap and making necessary object assignments.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot
     * @param telemetry Telemetry object used to initialize the telemetry to debug the code
     */
    private static void init(HardwareMap hardwareMap, Telemetry telemetry) {
        clock.reset();
        tele = telemetry; //assign the telemetry object
        Drivetrain.init(hardwareMap); //initialize the drivetrain
        Arm.init(hardwareMap); //initialize the arm
        Claw.init(hardwareMap); //initialize the claw
        Spinner.init(hardwareMap); //initialize the spinner
        VoltageSensor.init(hardwareMap); //initialize the voltage sensor
        drive = new MyMecanumDrive(hardwareMap); //assign the drivetrain object for Road Runner
    }
    /**
     * This function initializes all parts of the robot for Autonomous OpMode by configuring the HardwareMap and making necessary object assignments.
     * Include all the Autonomous-specific initialization commands here.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot
     * @param telemetry Telemetry object used to initialize the telemetry to debug the code
     */
    public static void initAuto(HardwareMap hardwareMap, Telemetry telemetry, Pose2d startPose){
        Camera.init(hardwareMap, telemetry); //initialize the camera
        init(hardwareMap, telemetry); //initialize the robot
        Arm.resetPose();
        Claw.close(); //close the arm grippers
        Claw.update();
        drive.setPoseEstimate(startPose); //set initial position for Road Runner
        telemetry.addLine();
        telemetry.addData(">", "Press Play to start op mode"); //telemetry confirmation
        telemetry.update();
    }
    /**
     * This function initializes all parts of the robot for TeleOp OpMode by configuring the HardwareMap and making necessary object assignments.
     * Include all the TeleOp-specific initialization commands here.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot
     * @param telemetry Telemetry object used to initialize the telemetry to debug the code
     */
    public static void initTeleOp(HardwareMap hardwareMap, Telemetry telemetry){
        init(hardwareMap, telemetry); //initialize the robot
        drive.setPoseEstimate(Coordinates.end); //set the initial position for Road Runner
        //Claw.open(); // open the arm grippers
        telemetry.addLine();
        telemetry.addData(">", "Press Play to start op mode"); //telemetry confirmation
        telemetry.update();
    }
    /**
     * This function initializes all parts of the robot for Testing OpMode by configuring the HardwareMap and making necessary object assignments.
     * Include all the Test-specific initialization commands here.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot
     * @param telemetry Telemetry object used to initialize the telemetry to debug the code
     */
    public static void initTest(HardwareMap hardwareMap, Telemetry telemetry){
        Camera.init(hardwareMap, telemetry); //initialize the camera
        init(hardwareMap, telemetry); //initialize the robot
        Arm.resetPose();
        Claw.close(); //close the arm grippers
        Claw.update();
        drive.setPoseEstimate(Coordinates.redStart1); //set the initial position for Road Runner
        telemetry.addLine();
        telemetry.addData(">", "Press Play to start op mode"); //telemetry confirmation
        telemetry.update();
    }
    /**
     * This is a delay function that uses Thread.sleep but it is optimized to catch any thread interruptions.
     * @param ms The period of time(in milliseconds) that the delay will last for
     */
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms); //core java delay command
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt(); //this exception is useful to remove the glitches and errors of the thread.sleep()
        }
    }

    public static double timeSeconds(){
        return clock.seconds();
    }

    public static double timeMilliseconds(){
        return clock.milliseconds();
    }

    public static double timeNanoseconds(){
        return clock.nanoseconds();
    }
    /**
     * This function runs necessary updates for all systems of the robot such as the localizer and the telemetry.
     * This command should run at the end of every cycle of a continuous OpMode.
     */
    public static void update(){
        Robot.drive.update(); //update the robot's position
        Drivetrain.reportPose(); //report the current robot position to telemetry
        Arm.update();
        Claw.update();
        Robot.tele.update(); //update the telemetry
    }
}

