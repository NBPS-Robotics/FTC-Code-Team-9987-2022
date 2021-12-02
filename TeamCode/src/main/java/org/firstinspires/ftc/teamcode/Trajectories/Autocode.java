package org.firstinspires.ftc.teamcode.Trajectories;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Drivetrain;

public class Autocode {
    public static void moveLeft(){
        Navigation.moveLeft(Coordinates.redStart1);
    }

    public static void Red1(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.redStart1,Coordinates.redGoalWall,Coordinates.redGoal);
        //add code to score element
        Navigation.goToCarousel(Coordinates.redGoal,Coordinates.redSpinnerWall,Coordinates.redSpinner);
        //add code to spin
        Navigation.goToStorage(Coordinates.redSpinner,Coordinates.redStorage);
        Drivetrain.setEndPose();
    }
    public static void Red2(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.redStart2,Coordinates.redGoalWall,Coordinates.redGoal);
        //add code to score element
        Navigation.goToWarehouse(Coordinates.redGoal,Coordinates.redGoalWall,Coordinates.redWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue1(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.blueStart1,Coordinates.blueGoalWall,Coordinates.blueGoal);
        //add code to score element
        Navigation.goToCarousel(Coordinates.blueGoal,Coordinates.blueSpinnerWall,Coordinates.blueSpinner);
        //add code to spin
        Navigation.goToStorage(Coordinates.blueSpinner,Coordinates.blueStorage);
        Drivetrain.setEndPose();
    }
    public static void Blue2(Telemetry telemetry){
        telemetry.addData("Read Alliance Starting Zone 1", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.blueStart2,Coordinates.blueGoalWall,Coordinates.blueGoal);
        //add code to score element
        Navigation.goToWarehouse(Coordinates.blueGoal,Coordinates.blueGoalWall,Coordinates.blueWarehouse);
        Drivetrain.setEndPose();
    }
    public static void test(Telemetry telemetry){
        telemetry.addData("Testing Autonomous", ">>>");
        telemetry.update();
        Navigation.goToGoal(Coordinates.redStart1, Coordinates.redGoalWall, Coordinates.redGoal);
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
}
