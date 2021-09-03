package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    //initialize the intake motor object
    public static DcMotor mIntake;
    /**
     * This function initializes all components of the Intake subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        mIntake = hardwareMap.dcMotor.get("MIntake"); //intake motor assignment
    }
    /**
     * This function stops the intake from running.
     */
    public static void stop(){
        mIntake.setPower(0); //set the intake motor to power 0
    }
    /**
     * This function runs the intake at a set power.
     * @param value power at which the intake will run
     */
    public static void succ(double value){
        mIntake.setPower(value);
    }
    /**
     * This function runs the intake INWARDS ONLY at a set power.
     * @param value power at which the intake will run INWARDS
     */
    public static void succIn(double value){
        succ(-value);
    }
    /**
     * This function runs the intake OUTWARDS ONLY at a set power.
     * @param value power at which the intake will run OUTWARDS
     */
    public static void succOut(double value){
        succ(value);
    }
}
