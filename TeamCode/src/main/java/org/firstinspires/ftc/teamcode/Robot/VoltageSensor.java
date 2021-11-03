package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class VoltageSensor {
    //create voltage sensor object
    public static com.qualcomm.robotcore.hardware.VoltageSensor voltageSensor;
    /**
     * This function initializes all components of the Voltage Sensor subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
    voltageSensor = hardwareMap.voltageSensor.get("Expansion Hub"); //Voltage sensor assignment
    }
    /**
     * This function return the voltage of the battery from the voltage sensor.
     * The returned value is a double
     */
    public static double getVoltage(){
        return voltageSensor.getVoltage();
    }
}
