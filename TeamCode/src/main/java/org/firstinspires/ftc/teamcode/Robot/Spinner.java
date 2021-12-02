package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.controller.PIDFController;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Spinner {
    //initialize the intake motor object
    public static DcMotor mSpinner;
    static PIDFController spinnerPid = new PIDFController(Constants.KP_spinner, Constants.KI_spinner, Constants.KD_spinner, Constants.KF_spinner);
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
     */
    public static void spin(double value){
        mSpinner.setPower(Constants.spinnerConstant/VoltageSensor.getVoltage() * value);
    }
}
