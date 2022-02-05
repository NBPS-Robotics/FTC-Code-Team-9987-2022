package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.drive.Drive;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Joystick {
    /**
     * This function processes all the outputs of the gamepad in order to control the robot during the TeleOp OpMode.
     * @param gamepad1 the gamepad object
     */
    public static void teleopControl(Gamepad gamepad1){
        //drive the robot
        Drivetrain.fieldCentricDrive(gamepad1.right_stick_x* Constants.turnPower, -gamepad1.right_stick_y, -gamepad1.left_stick_x);

        if (gamepad1.left_bumper) Drivetrain.speedControl(1); //drivetrain speed control

        else Drivetrain.speedControl(Constants.slowSpeed);

        Spinner.spin(-gamepad1.left_trigger+gamepad1.right_trigger);

        if (gamepad1.dpad_down) Arm.setArm(-10); //arm down

        else if (gamepad1.dpad_up) Arm.setArm(10); //arm up

        if (gamepad1.dpad_right) Claw.close(); //close the grabbers

        if (gamepad1.dpad_left) Claw.open(); //open the grabbers

        if(gamepad1.a) Arm.pickUp();

        if(gamepad1.x) Arm.scoreBottom();

        if(gamepad1.b) Arm.scoreMiddle();

        if(gamepad1.y) Arm.scoreTop();

        if(gamepad1.right_bumper) Arm.capElement();
    }
    public static void splitTeleopControl(Gamepad gamepad1, Gamepad gamepad2){

        //GAMEPAD 1
        //drive the robot
        Drivetrain.fieldCentricDrive(gamepad1.right_stick_x* Constants.turnPower, -gamepad1.right_stick_y, -gamepad1.left_stick_x);

        if (gamepad1.left_bumper) Drivetrain.speedControl(1); //drivetrain speed control

        else Drivetrain.speedControl(Constants.slowSpeed);

        //if(gamepad1.a) Drivetrain.alignToScore(); //UNSTABLE
        //if(gamepad1.x) Drivetrain.alignToWarehouse(); //UNSTABLE

        //GAMEPAD 2

        Spinner.spin(-gamepad2.left_trigger+gamepad2.right_trigger);

        if (gamepad2.dpad_down) Arm.setArm(-10); //arm down

        else if (gamepad2.dpad_up) Arm.setArm(10); //arm up

        Arm.setArm((int)gamepad2.left_stick_y*-30);

        if (gamepad2.dpad_right) Claw.close(); //close the grabbers

        if (gamepad2.dpad_left) Claw.open(); //open the grabbers

        if(gamepad2.a) Arm.pickUp();

        if(gamepad2.x) Arm.scoreBottom();

        if(gamepad2.b) Arm.scoreMiddle();

        if(gamepad2.y) Arm.scoreTop();

        if(gamepad2.left_stick_button) Arm.elbowDownTeleOp();

        if(gamepad2.left_bumper) Arm.grabCap();

        if(gamepad2.right_bumper) Arm.capElement();
    }
    /**
     * This function processes all the outputs of the gamepad in order to control the robot during the Testing OpMode.
     * Use this to make sure all hardware works as needed.
     * @param gamepad1 the gamepad object
     */
    public static void testControl(Gamepad gamepad1){
        //check motors
        double LY = gamepad1.left_stick_y; //save joystick value into a variable
        double RY = gamepad1.right_stick_y;
        double LX = gamepad1.left_stick_x;
        double RX = gamepad1.right_stick_x;

        Drivetrain.leftFront.setPower(LY); //apply the variable to the motor
        Drivetrain.leftRear.setPower(LX);
        Drivetrain.rightFront.setPower(RY);
        Drivetrain.rightRear.setPower(RX);

        //check the arm
        if(gamepad1.dpad_up)
        if(gamepad1.dpad_down)

        //check the grabber
        if(gamepad1.dpad_left) Claw.open();
        if(gamepad1.dpad_right ) Claw.close();

    }
}
