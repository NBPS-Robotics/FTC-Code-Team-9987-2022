package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Trajectories.Coordinates;

public class Joystick {
    /**
     * This function processes all the outputs of the gamepad in order to control the robot during the TeleOp OpMode.
     * @param gamepad1 the gamepad object
     */
    public static void teleopControl(Gamepad gamepad1){
        //drive the robot
        Drivetrain.fieldCentricDrive(gamepad1.right_stick_x* Constants.turnPower, gamepad1.right_stick_y, gamepad1.left_trigger, gamepad1.right_trigger);

        if (gamepad1.left_bumper) Drivetrain.speedControl(0.4); //drivetrain speed control

        else Drivetrain.speedControl(1);

        if(gamepad1.x){
            //when at shooting position, reset the pose to eliminate the error over time
            Robot.myLocalizer.setPoseEstimate(Coordinates.shoot);
            Robot.drive.setPoseEstimate(Coordinates.shoot);
        }
        if(gamepad1.b) Drivetrain.alignToShoot(); //align to the shooting position

        if(gamepad1.a) Spinner.spin(0.6);

        if (gamepad1.dpad_down) Arm.moveUp(1); //arm up

        else if (gamepad1.dpad_up) Arm.moveDown(1); //arm down

        else Arm.stop();

        if (gamepad1.dpad_right) Claw.close(); //close the grabbers

        if (gamepad1.dpad_left) Claw.open(); //open the grabbers

        Arm.step(gamepad1.left_stick_y);

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

        //if(gamepad1.dpad_left) Robot.MArm.setPower(1);
        //if(gamepad1.dpad_right )Robot.MIntake.setPower(1);
    }
}
