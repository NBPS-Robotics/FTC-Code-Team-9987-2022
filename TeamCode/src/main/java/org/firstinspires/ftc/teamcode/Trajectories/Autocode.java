package org.firstinspires.ftc.teamcode.Trajectories;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Arm;
import org.firstinspires.ftc.teamcode.Robot.Claw;
import org.firstinspires.ftc.teamcode.Robot.Drivetrain;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.Spinner;

public class Autocode {
    public static void moveLeft(){
        Navigation.moveLeft(Coordinates.redStart1);
    }

    public static void Red1(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.redStart1,Coordinates.redGoalWall,Coordinates.redGoal);
        scoreElement(telemetry);
        Navigation.goToCarousel(Coordinates.redGoal,Coordinates.redSpinnerWall,Coordinates.redSpinner);
        spinner(1);
        Navigation.goToStorage(Coordinates.redSpinner,Coordinates.redStorage);
        Drivetrain.setEndPose();
    }
    public static void Red2(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.redStart2,Coordinates.redGoalWall,Coordinates.redGoal);
        scoreElement(telemetry);
        Navigation.goToWarehouse(Coordinates.redGoal,Coordinates.redGoalWall2,Coordinates.redWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue1(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.blueStart1,Coordinates.blueGoalWall,Coordinates.blueGoal);
        scoreElement(telemetry);
        Navigation.goToCarousel(Coordinates.blueGoal,Coordinates.blueSpinnerWall,Coordinates.blueSpinner);
        spinner(-1);
        Navigation.goToStorage(Coordinates.blueSpinner,Coordinates.blueStorage);
        Drivetrain.setEndPose();
    }
    public static void Blue2(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.blueStart2,Coordinates.blueGoalWall,Coordinates.blueGoal);
        scoreElement(telemetry);
        Navigation.goToWarehouse(Coordinates.blueGoal,Coordinates.blueGoalWall2,Coordinates.blueWarehouse);
        Drivetrain.setEndPose();
    }
    public static void test(Telemetry telemetry){
        telemetry.addData("Testing Autonomous", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.blueStart1, Coordinates.blueGoalWall, Coordinates.blueGoal);
        //Navigation.goToShoot();
        //Robot.shootStack(1, ExpansionHub1_VoltageSensor.getVoltage());
        //Robot.wait(1000);
        //Robot.ShootOne(ExpansionHub1_VoltageSensor.getVoltage());
        //Robot.MIntake.setPower(0);
        //Robot.goToZone(0);
        //Robot.getWobble(0);
        //Robot.bringWobble(0);
        //Robot.goToLine(0);
        Drivetrain.setEndPose();
    }
    public static void spinner(double value){
        Spinner.spin(value);
        Robot.wait(2000);
        Spinner.stop();
    }
    public static void scoreElement(Telemetry telemetry){
        Arm.armUpAuto(telemetry);
        Claw.open();
        Arm.update(telemetry);
        Robot.wait(1000);
        Arm.armDownAuto(telemetry);
        Arm.stop();
    }
}
