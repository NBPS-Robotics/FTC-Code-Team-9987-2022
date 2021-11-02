package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Mecanum_Drive.MyMecanumDrive;
import org.firstinspires.ftc.teamcode.Mecanum_Drive.StandardTrackingWheelLocalizer;
import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;
import org.firstinspires.ftc.teamcode.Vision.Camera;

public class Robot {
    //create the Mecanum Drive object for Road Runner
    public static MyMecanumDrive drive;
    //create the Tracking Wheel localizer object for Road Runner
    public static StandardTrackingWheelLocalizer myLocalizer;
    //create the telemetry object to use for debugging with telemetry
    public static Telemetry tele;
    /**
     * This function initializes all parts of the robot by configuring the HardwareMap and making necessary object assignments.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot
     * @param telemetry Telemetry object used to initialize the telemetry to debug the code
     */
    private static void init(HardwareMap hardwareMap, Telemetry telemetry) {
        tele = telemetry; //assign the telemetry object
        Drivetrain.init(hardwareMap); //initialize the drivetrain
        Arm.init(hardwareMap); //initialize the arm
        Claw.init(hardwareMap); //initialize the claw
        Spinner.init(hardwareMap); //initialize the spinner
        VoltageSensor.init(hardwareMap); //initialize the voltage sensor
        drive = new MyMecanumDrive(hardwareMap); //assign the drivetrain object for Road Runner
        myLocalizer = new StandardTrackingWheelLocalizer(hardwareMap); //assign the localizer object for Road Runner
    }
    /**
     * This function initializes all parts of the robot for Autonomous OpMode by configuring the HardwareMap and making necessary object assignments.
     * Include all the Autonomous-specific initialization commands here.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot
     * @param telemetry Telemetry object used to initialize the telemetry to debug the code
     */
    public static void initAuto(HardwareMap hardwareMap, Telemetry telemetry){
        Camera.init(hardwareMap, telemetry); //initialize the camera
        init(hardwareMap, telemetry); //initialize the robot
        Claw.close(); //close the arm grippers
        Camera.out(); //bring the camera out
        drive.setPoseEstimate(Coordinates.start); //set initial position for Road Runner
        myLocalizer.setPoseEstimate(Coordinates.start); //set initial position for Road Runner
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
        myLocalizer.setPoseEstimate(Coordinates.end); //set the initial position for Road Runner
        Claw.open(); // open the arm grippers
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
        init(hardwareMap, telemetry); //initialize the robot
        Claw.close(); //close the arm grippers
        drive.setPoseEstimate(Coordinates.start); //set the initial position for Road Runner
        myLocalizer.setPoseEstimate(Coordinates.start); //set the initial position for Road Runner
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
    /**
     * This function runs necessary updates for all systems of the robot such as the localizer and the telemetry.
     * This command should run at the end of every cycle of a continuous OpMode.
     * @param telemetry Telemetry object
     */
    public static void update(Telemetry telemetry){
        telemetry.update(); //update the telemetry
        Robot.drive.update(); //update the robot's position
        Robot.myLocalizer.update(); //update the localizer position
        Drivetrain.reportPose(); //report the current robot position to telemetry
    }
}

