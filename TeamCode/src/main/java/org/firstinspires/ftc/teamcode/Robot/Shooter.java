package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    //initialize the left shooter motor object
    public static DcMotor leftShooter;
    //initialize the right shooter motor object
    public static DcMotor rightShooter;
    /**
     * This function initializes all components of the Shooter subsystem, including all motors and sensors.
     * @param hardwareMap HardwareMap object used to initialize the hardware of the robot.
     */
    public static void init(HardwareMap hardwareMap){
        leftShooter = hardwareMap.dcMotor.get("MLeftShooter"); //left shooter motor assignment
        rightShooter = hardwareMap.dcMotor.get("MRightShooter"); //right shooter motor assignment
    }
    /**
     * This function turns the shooter on to a set speed(defined by the targetShooterSpeed constant in the Constants class).
     * @param constant a calculated constant applied to achieve desired output.
     */
    public static void on(double constant){
        leftShooter.setPower(constant/VoltageSensor.getVoltage()); //set left shooter motor to the power provided by constant
        rightShooter.setPower(-constant/VoltageSensor.getVoltage()); //set right shooter motor to the power provided by constant
    }
    /**
     * This function shuts the shooter off by making it run the opposite way for a short amount of time.
     * This method stops the shooter quicker than by just setting power to 0.
     */
    public static void off(){
        leftShooter.setPower(-1);
        rightShooter.setPower(1);
        Robot.wait(500); // delay of 500 milliseconds
        leftShooter.setPower(0);
        rightShooter.setPower(0);
    }
    /**
     * This function shoots a single ring out of the shooter.
     * Shooter speed is defined by the targetShooterSpeed constant in the Constants class.
     */
    public static void shootOne(){ //shoot one ring
        //shooting code
        Hopper.back(); //bring the hopper back
        on(Constants.powerConstant); //turn the shooter on
        Robot.wait(1000);
        //shoot the ring
        Hopper.forward(); //bring the hopper forward
        Robot.wait(200);
        Hopper.back(); // bring the hopper back
    }
    /**
     * This function shoots three rings out of the shooter.
     * Shooter speed is defined by the targetShooterSpeed constant in the Constants class.
     */
    public static void shootThree(){
        //shooting code
        Hopper.back(); //set hopper back
        on(Constants.powerConstant);
        Robot.wait(500);
        Intake.succIn(0.5); //run the intake inwards
        for(int i=0; i<3; i++){ //shoot the rings
            Hopper.forward();
            Robot.wait(500);
            Hopper.back();
            on(Constants.powerConstant);
            Robot.wait(500);
        }
        Hopper.back(); // bring the hopper back
        Intake.stop(); //stop the intake
    }
    /**
     * This function scores the power shot targets by turning the robot and shooting rings at them.
     * Shooter speed is defined by the targetShooterSpeed constant in the Constants class.
     */
    public static void powerShot(){
        //shooting code
        Hopper.back();
        Intake.succIn(0.5);
        on(Constants.shotConstant);
        Robot.wait(2000);
        Hopper.forward();
        Robot.wait(200);
        Hopper.back();
        Robot.drive.turn(Math.toRadians(Constants.powerShotTurn)); //turn left to the second powershot
        Drivetrain.stop();
        on(Constants.shotConstant);
        Robot.wait(1000);
        Hopper.forward();
        Robot.wait(200);
        Hopper.back();
        Robot.drive.turn(Math.toRadians(-Constants.powerShotTurn*2));  //turn right to the last powershot
        Drivetrain.stop();
        on(Constants.shotConstant);
        Robot.wait(1000);
        Hopper.forward();
        Robot.wait(200);
        Hopper.back();
        Intake.stop();
        off(); //turn off the shooter
    }
}
