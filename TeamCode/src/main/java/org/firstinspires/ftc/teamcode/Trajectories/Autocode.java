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

    public static void Red1(Telemetry telemetry, String pose){ //Red1 - Score, Duck, Storage
        telemetry.addData("Red Alliance Starting Zone 1", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.redStart1, Coordinates.redGoalPoint1);
        scoreGoalRed(pose, telemetry);
        Navigation.goToCarousel(Coordinates.redGoalTop,Coordinates.redSpinnerWall,Coordinates.redSpinner);
        spinner(1);
        Navigation.goToStorage(Coordinates.redSpinner,Coordinates.redStorage);
        Drivetrain.setEndPose();
    }
    public static void Red2(Telemetry telemetry, String pose){ //Red2 - Score, Warehouse
        telemetry.addData("Red Alliance Starting Zone 2", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.redStart2, Coordinates.redGoalPoint2);
        scoreGoalRed(pose, telemetry);
        scoreElement(telemetry);
        Navigation.goToWarehouse(Coordinates.redGoalTop,Coordinates.redGoalWall2,Coordinates.redWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Red2ClearWarehouse(Telemetry telemetry, String pose){ //Red2 - Score, Warehouse, Clear Warehouse
        telemetry.addData("Red Alliance Starting Zone 2(Clear Warehouse)", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.redStart2, Coordinates.redGoalPoint2);
        scoreGoalRed(pose, telemetry);
        Navigation.goToWarehouse(Coordinates.redGoalTop,Coordinates.redGoalWall2,Coordinates.redWarehouse);
        Navigation.clearWarehouse(Coordinates.redWarehouse, Coordinates.redWarehousePoint);
        Drivetrain.setEndPose();
    }
    public static void Red1Warehouse(Telemetry telemetry, String pose){ //Red1 - Score, Duck, Warehouse
        telemetry.addData("Red Alliance Starting Zone 1(Warehouse)", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.redStart1, Coordinates.redGoalPoint1);
        scoreGoalRed(pose, telemetry);
        Navigation.goToCarousel(Coordinates.redGoalTop,Coordinates.redSpinnerWall,Coordinates.redSpinner);
        spinner(1);
        Navigation.goToWarehouseFromCarousel(Coordinates.redSpinner,Coordinates.redSpinnerWall,Coordinates.redGoalWall,Coordinates.redWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue1(Telemetry telemetry, String pose){ //Blue1 - Score, Duck, Storage
        telemetry.addData("Blue Alliance Starting Zone 1", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.blueStart1, Coordinates.blueGoalPoint1);
        scoreGoalBlue(pose, telemetry);
        Navigation.goToCarousel(Coordinates.blueGoalTop,Coordinates.blueSpinnerWall,Coordinates.blueSpinner);
        spinner(-1);
        Navigation.goToStorage(Coordinates.blueSpinner,Coordinates.blueStorage);
        Drivetrain.setEndPose();
    }
    public static void Blue2(Telemetry telemetry, String pose){ //Blue2 - Score, Warehouse
        telemetry.addData("Blue Alliance Starting Zone 2", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.blueStart2, Coordinates.blueGoalPoint2);
        scoreGoalBlue(pose, telemetry);
        Navigation.goToWarehouse(Coordinates.blueGoalTop,Coordinates.blueGoalWall2,Coordinates.blueWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue1Warehouse(Telemetry telemetry, String pose){ //Blue1 - Score, Duck, Warehouse
        telemetry.addData("Blue Alliance Starting Zone 1(Warehouse)", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.blueStart1, Coordinates.blueGoalPoint1);
        scoreGoalBlue(pose, telemetry);
        Navigation.goToCarousel(Coordinates.blueGoalTop,Coordinates.blueSpinnerWall,Coordinates.blueSpinner);
        spinner(1);
        Navigation.goToWarehouseFromCarousel(Coordinates.blueSpinner,Coordinates.blueSpinnerWall,Coordinates.blueGoalWall,Coordinates.blueWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue2ClearWarehouse(Telemetry telemetry, String pose){ //Blue2 - Score, Warehouse, Clear Warehouse
        telemetry.addData("Red Alliance Starting Zone 2(Clear Warehouse)", "");
        telemetry.update();
        Navigation.goToGoalPoint(Coordinates.blueStart2, Coordinates.blueGoalPoint2);
        scoreGoalBlue(pose, telemetry);
        Navigation.goToWarehouse(Coordinates.blueGoalTop,Coordinates.blueGoalWall2,Coordinates.blueWarehouse);
        Navigation.clearWarehouse(Coordinates.blueWarehouse, Coordinates.blueWarehousePoint);
        Drivetrain.setEndPose();
    }
    public static void test(Telemetry telemetry){
        telemetry.addData("Testing Autonomous", "");
        telemetry.update();
        Drivetrain.setEndPose();
    }
    public static void spinner(double value){
        Spinner.spin(value);
        Robot.wait(3000);
        Spinner.stop();
    }
    public static void raiseArm(String pose, Telemetry telemetry){
        switch (pose){
            case "Left":{
                Arm.scoreBottom();
                break;
            }
            case "Center":{
                Arm.scoreMiddle();
                break;
            }
            case "Right":{
                Arm.scoreTop();
                break;
            }
        }
        for(int i=0;i<50;i++){
            Arm.update(telemetry);
            Robot.wait(30);
        }
    }
    public static void scoreElement(Telemetry telemetry){
        Claw.open();
        Claw.update(telemetry);
        Arm.update(telemetry);
        Robot.wait(1000);
        Arm.armDownAuto(telemetry);
        Claw.close();
        Claw.update(telemetry);
        Robot.wait(500);
        Arm.stop();
    }
    public static void scoreGoalRed(String pose, Telemetry telemetry){
        raiseArm(pose, telemetry);
        switch (pose){
            case "Left":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalBottom);
                scoreElement(telemetry);
                break;
            }
            case "Center":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalMiddle);
                scoreElement(telemetry);
                break;
            }
            case "Right":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalTop);
                scoreElement(telemetry);
                break;
            }
        }
    }
    public static void scoreGoalBlue(String pose, Telemetry telemetry){
        raiseArm(pose, telemetry);
        switch (pose){
            case "Left":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalBottom);
                scoreElement(telemetry);
                break;
            }
            case "Center":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalMiddle);
                scoreElement(telemetry);
                break;
            }
            case "Right":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalTop);
                scoreElement(telemetry);
                break;
            }
        }
    }
}
