package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class Drivetrain {
    //initialize drivetrain motor objects
    public static DcMotor leftFront;
    public static DcMotor leftRear;
    public static DcMotor rightFront;
    public static DcMotor rightRear;
    /**
     * This function initializes all components of the Drivetrain subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        leftFront = hardwareMap.dcMotor.get("leftFront");
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightRear = hardwareMap.dcMotor.get("rightRear");
    }
    /**
     * This function stops the drivetrain motors.
     */
    public static void stop(){
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }
    /**
     * This function changes the speed multiplier in order to restrict the speed of the robot for accuracy when needed.
     * @param speed the desired value for the speed multiplier
     */
    public static void speedControl(double speed){
        Constants.speed = speed; //set the speed multiplier to a specified value
    }
    /**
     * This function uses the inputs from the gamepad to drive the robot using field centric drive.
     * This function is intended for a mecanum drivetrain only.
     * The triggers are used for strafing instead of the other joystick.
     * @param RX x-axis of the right joystick
     * @param RY y-axis of the right joystick
     * @param LX left trigger value
     */
    public static void fieldCentricDrive(double RX, double RY, double LX){
        Robot.drive.setWeightedDrivePower(
                new Pose2d(
                        RY*Constants.speed,
                        LX*Constants.speed,
                        (-RX)*Constants.speed
                )
        );
    }
    /**
     * This function uses navigation to move the robot to the shooting position.
     * Keep in mind that the position of the robot has to be updated after the function runs in order to reduce error over time.
     */
    public static void alignToScore(){
        if(getAlliance() == "RED"){
            TrajectorySequence trajectory = Robot.drive.trajectorySequenceBuilder(Robot.drive.getPoseEstimate())
                    .lineToLinearHeading(Coordinates.redWarehouse)
                    .back(15)
                    .lineToLinearHeading(Coordinates.redGoalTop)
                    .build();
            Robot.drive.followTrajectorySequenceAsync(trajectory);
        }
        else{
            TrajectorySequence trajectory = Robot.drive.trajectorySequenceBuilder(Robot.drive.getPoseEstimate())
                    .lineToLinearHeading(Coordinates.blueWarehouse)
                    .back(15)
                    .lineToLinearHeading(Coordinates.blueGoalTop)
                    .build();
            Robot.drive.followTrajectorySequenceAsync(trajectory);
        }
    }
    public static void alignToWarehouse(){
        if(getAlliance() == "RED"){
            Robot.drive.turn(Math.toRadians(-90));
            TrajectorySequence trajectory = Robot.drive.trajectorySequenceBuilder(Robot.drive.getPoseEstimate())
                    .lineToLinearHeading(Coordinates.redGoalWall)
                    .forward(15)
                    .lineToLinearHeading(Coordinates.redWarehouse)
                    .build();
            Robot.drive.followTrajectorySequenceAsync(trajectory);
        }
        else{
            Robot.drive.turn(Math.toRadians(90));
            TrajectorySequence trajectory = Robot.drive.trajectorySequenceBuilder(Robot.drive.getPoseEstimate())
                    .lineToLinearHeading(Coordinates.blueGoalWall)
                    .forward(15)
                    .lineToLinearHeading(Coordinates.blueWarehouse)
                    .build();
            Robot.drive.followTrajectorySequenceAsync(trajectory);
        }
    }
    /**
     * This function reports the current position of the robot on the field to the telemetry.
     */
    public static void reportPose(){
        Pose2d myPose = Robot.drive.getPoseEstimate();

        Robot.tele.addData("x", myPose.getX());
        Robot.tele.addData("y", myPose.getY());
        Robot.tele.addData("heading", myPose.getHeading());
    }
    /**
     * This function saves the final position of the robot in Autonomous OpMode in order to use it in TeleOp OpMode.
     * Run this function at the end of the Autonomous OpMode
     */
    public static void setEndPose(){
        Coordinates.end = Robot.drive.getPoseEstimate();
    }

    public static String getAlliance() {
        if(Coordinates.end.getY() < 0){ // red alliance
            return "RED";
        }
        else return "BLUE";
    }
}
