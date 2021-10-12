package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {
    public static DcMotor m_lift;
    /**
     * This function initializes all components of the Arm subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        m_lift = hardwareMap.dcMotor.get("LiftMotor"); //lift motor assignment
    }
    /**
     * This function moves the arm at a set power.
     * WARNING: This method does not stop the arm when it reaches the limit, the user is responsible for limiting the motion of the arm to safe boundaries.
     * @param power power at which the arm motor will run
     */
    public static void move(double power){
        m_lift.setPower(power); //set arm motor to a specific power
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
        m_lift.setPower(0);
    }
    /**
     * This function moves the arm to the upper position
     */
    public static void up(){
        Robot.wait(500);
        m_lift.setPower(-1);
        Robot.wait(1500);
        m_lift.setPower(0);
    }
    /**
     * This function moves the arm to the lower position.
     */
    public static void down(){
        m_lift.setPower(1);
        Robot.wait(1500);
        m_lift.setPower(0);
    }
}
