package org.firstinspires.ftc.teamcode.Trajectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Arm;
import org.firstinspires.ftc.teamcode.Robot.Claw;
import org.firstinspires.ftc.teamcode.Robot.Drivetrain;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.Spinner;

public class Autocode {
    static Pose2d goalPose;
    public static void moveLeft(){
        Navigation.moveLeft(Coordinates.redStart1);
    }

    public static void Red1(String pose){ //Red1 - Score, Duck, Storage
        Robot.tele.addData("Red Alliance Starting Zone 1", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.redStart1, Coordinates.redGoalPoint1);
        goalPose = scoreGoalRed(pose);
        Navigation.goToCarousel(goalPose,Coordinates.redSpinnerWall,Coordinates.redSpinner);
        spinner(1);
        Navigation.goToStorage(Coordinates.redSpinner,Coordinates.redStorage);
        Drivetrain.setEndPose();
    }
    public static void Red2(String pose){ //Red2 - Score, Warehouse
        Robot.tele.addData("Red Alliance Starting Zone 2", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.redStart2, Coordinates.redGoalPoint2);
        goalPose = scoreGoalRed(pose);
        Navigation.goToWarehouse(goalPose,Coordinates.redGoalWall2,Coordinates.redWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Red2ClearWarehouse(String pose){ //Red2 - Score, Warehouse, Clear Warehouse
        Robot.tele.addData("Red Alliance Starting Zone 2(Clear Warehouse)", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.redStart2, Coordinates.redGoalPoint2);
        goalPose = scoreGoalRed(pose);
        Navigation.goToWarehouse(goalPose,Coordinates.redGoalWall2,Coordinates.redWarehouse);
        Navigation.clearWarehouse(Coordinates.redWarehouse, Coordinates.redWarehousePoint);
        Drivetrain.setEndPose();
    }
    public static void Red1Warehouse(String pose){ //Red1 - Score, Duck, Warehouse
        Robot.tele.addData("Red Alliance Starting Zone 1(Warehouse)", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.redStart1, Coordinates.redGoalPoint1);
        goalPose = scoreGoalRed(pose);
        Navigation.goToCarousel(goalPose,Coordinates.redSpinnerWall,Coordinates.redSpinner);
        spinner(1);
        Navigation.goToWarehouseFromCarousel(Coordinates.redSpinner,Coordinates.redSpinnerWall,Coordinates.redGoalWall,Coordinates.redWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue1(String pose){ //Blue1 - Score, Duck, Storage
        Robot.tele.addData("Blue Alliance Starting Zone 1", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.blueStart1, Coordinates.blueGoalPoint1);
        goalPose = scoreGoalBlue(pose);
        Navigation.goToCarousel(goalPose,Coordinates.blueSpinnerWall,Coordinates.blueSpinner);
        spinner(-1);
        Navigation.goToStorage(Coordinates.blueSpinner,Coordinates.blueStorage);
        Drivetrain.setEndPose();
    }
    public static void Blue2(String pose){ //Blue2 - Score, Warehouse
        Robot.tele.addData("Blue Alliance Starting Zone 2", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.blueStart2, Coordinates.blueGoalPoint2);
        goalPose = scoreGoalBlue(pose);
        Navigation.goToWarehouse(goalPose,Coordinates.blueGoalWall2,Coordinates.blueWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue1Warehouse(String pose){ //Blue1 - Score, Duck, Warehouse
        Robot.tele.addData("Blue Alliance Starting Zone 1(Warehouse)", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.blueStart1, Coordinates.blueGoalPoint1);
        goalPose = scoreGoalBlue(pose);
        Navigation.goToCarousel(goalPose,Coordinates.blueSpinnerWall,Coordinates.blueSpinner);
        spinner(1);
        Navigation.goToWarehouseFromCarousel(Coordinates.blueSpinner,Coordinates.blueSpinnerWall,Coordinates.blueGoalWall,Coordinates.blueWarehouse);
        Drivetrain.setEndPose();
    }
    public static void Blue2ClearWarehouse(String pose){ //Blue2 - Score, Warehouse, Clear Warehouse
        Robot.tele.addData("Red Alliance Starting Zone 2(Clear Warehouse)", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.blueStart2, Coordinates.blueGoalPoint2);
        goalPose = scoreGoalBlue(pose);
        Navigation.goToWarehouse(goalPose,Coordinates.blueGoalWall2,Coordinates.blueWarehouse);
        Navigation.clearWarehouse(Coordinates.blueWarehouse, Coordinates.blueWarehousePoint);
        Drivetrain.setEndPose();
    }
    public static void test(String pose){
        Robot.tele.addData("Testing Autonomous", "");
        Robot.tele.update();
        Navigation.goToGoalPoint(Coordinates.redStart1, Coordinates.redGoalPoint1);
        goalPose = scoreGoalRed(pose);
        Arm.update();

        Drivetrain.setEndPose();
    }
    public static void spinner(double value){
        Spinner.spin(value);
        Robot.wait(3000);
        Spinner.stop();
    }
    public static void raiseArm(String pose){
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
        Arm.armUpAuto();
        Arm.update();
        Robot.wait(2000);
    }
    public static void scoreElement(){
        Claw.open();
        Claw.update();
        Arm.update();
        Robot.wait(1000);
        Arm.armDownAuto();
        Claw.close();
        Claw.update();
        Robot.wait(500);
        Arm.stop();
    }
    public static Pose2d scoreGoalRed(String pose){
        raiseArm(pose);
        switch (pose){
            case "Left":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalBottom);
                scoreElement();
                return Coordinates.redGoalBottom;
            }
            case "Center":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalMiddle);
                scoreElement();
                return Coordinates.redGoalMiddle;
            }
            case "Right":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalTop);
                scoreElement();
                return Coordinates.redGoalTop;
            }
        }
        return null;
    }
    public static Pose2d scoreGoalBlue(String pose){
        raiseArm(pose);
        switch (pose){
            case "Left":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalBottom);
                scoreElement();
                return Coordinates.blueGoalBottom;
            }
            case "Center":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalMiddle);
                scoreElement();
                return Coordinates.blueGoalMiddle;
            }
            case "Right":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalTop);
                scoreElement();
                return Coordinates.blueGoalTop;
            }
        }
        return null;
    }
}
