package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    public static DcMotor mArm;
    public static Servo leftClaw;
    public static Servo rightClaw;
    /**
     * This function initializes all components of the Arm subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        mArm = hardwareMap.dcMotor.get("MArm"); //arm motor assignment
        leftClaw = hardwareMap.servo.get("LClaw"); //left claw servo assignment
        rightClaw = hardwareMap.servo.get("RClaw");
    }
    /**
     * This function opens the grippers and releases a held object.
     */
    public static void open(){
        leftClaw.setPosition(1); //set left claw servo to position 1
        rightClaw.setPosition(1);
    }
    /**
     * This function closes the grippers to grab an object.
     */
    public static void close(){
        leftClaw.setPosition(0);
        rightClaw.setPosition(0);
    }
    /**
     * This function moves the arm at a set power.
     * WARNING: This method does not stop the arm when it reaches the limit, the user is responsible for limiting the motion of the arm to safe boundaries.
     * @param power power at which the arm motor will run
     */
    public static void move(double power){
        mArm.setPower(power); //set arm motor to a specific power
    }
    /**
     * This function moves the arm UPWARDS at a set power.
     * WARNING: This method does not stop the arm when it reaches the limit, the user is responsible for limiting the motion of the arm to safe boundaries.
     * @param value power at which the arm motor will run UPWARDS
     */
    public static void moveUp(double value){
        move(-value);
    }
    /**
     * This function moves the arm DOWNWARDS at a set power.
     * WARNING: This method does not stop the arm when it reaches the limit, the user is responsible for limiting the motion of the arm to safe boundaries.
     * @param value power at which the arm motor will run DOWNWARDS
     */
    public static void moveDown(double value){
        move(value);
    }
    /**
     * This function stops the arm from running.
     * WARNING: This method does not stop the arm when it reaches the limit, the user is responsible for limiting the motion of the arm to safe boundaries.
     */
    public static void stop(){
        mArm.setPower(0);
    }
    /**
     * This function moves the arm to the upper position
     */
    public static void up(){
        Robot.wait(500);
        mArm.setPower(-1);
        Robot.wait(1500);
        mArm.setPower(0);
    }
    /**
     * This function moves the arm to the lower position.
     */
    public static void down(){
        mArm.setPower(1);
        Robot.wait(1500);
        mArm.setPower(0);
    }
}
