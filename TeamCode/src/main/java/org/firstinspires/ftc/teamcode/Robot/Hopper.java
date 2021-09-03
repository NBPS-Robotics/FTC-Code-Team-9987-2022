package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hopper {
    //initialize the hopper object
    public static Servo hopper;
    /**
     * This function initializes all components of the Hopper subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        hopper = hardwareMap.servo.get("Hopper"); //intake servo assignment
    }
    /**
     * This function set the Hopper to its back position
     */
    public static void back(){
        hopper.setPosition(0.95); //set the servo to position 0.95
    }
    /**
     * This function set the Hopper to its forward position
     */
    public static void forward(){
        hopper.setPosition(0.81);
    }
}
