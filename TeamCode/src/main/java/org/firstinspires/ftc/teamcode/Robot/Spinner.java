package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spinner {
    //initialize the intake motor object
    public static DcMotor mSpinner;
    /**
     * This function initializes all components of the Spinner subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        mSpinner = hardwareMap.dcMotor.get("mSpinner"); //spinner motor assignment
    }
    /**
     * This function stops the intake from running.
     */
    public static void stop(){
        mSpinner.setPower(0); //set the spinner motor to power 0
    }
    /**
     * This function runs the spinner at a set power.
     * @param value power at which the spinner will run
     */
    public static void spin(double value){
        mSpinner.setPower(value);
    }
}
