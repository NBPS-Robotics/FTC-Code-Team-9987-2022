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
        raiseElbow();
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
        Navigation.goToWarehouseFromCarousel(Coordinates.redSpinner,Coordinates.redSpinnerWall,Coordinates.redGoalWall2,Coordinates.redWarehouse);
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
        raiseElbow();
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
        Navigation.goToWarehouseFromCarousel(Coordinates.blueSpinner,Coordinates.blueSpinnerWall,Coordinates.blueGoalWall2,Coordinates.blueWarehouse);
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
        Spinner.spin(value*0.8);
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
        for(int x =0; x<100; x++){
            Arm.update();
            Robot.wait(10);
        }

    }
    public static void raiseElbow(){
        Claw.open();
        for(int y = 0; y<50; y++){
            Claw.update();
            Robot.wait(10);
        }
        Arm.elbowUpAuto();
        for(int y = 0; y<300; y++){
            Arm.correctElbow();
            Robot.wait(10);
        }
    }
    public static void scoreElement(Pose2d goal, Pose2d goalBack){
        while(Robot.drive.isBusy()){
            Arm.update();
            Robot.drive.update();
            Robot.wait(10);
        }
        Arm.update();
        Claw.open();
        Claw.update();
        Arm.update();
        for(int x =0; x<50; x++){
            Arm.update();
            Claw.update();
            Robot.wait(10);
        }
        Navigation.backfromGoal(goal, goalBack);
        while(Robot.drive.isBusy()){
            Arm.update();
            Robot.drive.update();
            Robot.wait(10);
        }
        Navigation.turnfromGoal(goal);
        Arm.armDownAuto();
        Claw.close();
        for(int x =0; x<100; x++){
            Arm.update();
            Claw.update();
            Robot.wait(10);
        }
        Arm.stop();
    }
    public static Pose2d scoreGoalRed(String pose){
        raiseArm(pose);
        switch (pose){
            case "Left":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalBottom);
                scoreElement(Coordinates.redGoalBottom, Coordinates.redGoalBack);
                return Coordinates.redGoalBack;
            }
            case "Center":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalMiddle);
                scoreElement(Coordinates.redGoalMiddle, Coordinates.redGoalBack);
                return Coordinates.redGoalBack;
            }
            case "Right":{
                Navigation.goToGoal(Coordinates.redGoalPoint1, Coordinates.redGoalTop);
                scoreElement(Coordinates.redGoalTop, Coordinates.redGoalBack);
                return Coordinates.redGoalBack;
            }
        }
        return null;
    }
    public static Pose2d scoreGoalBlue(String pose){
        raiseArm(pose);
        switch (pose){
            case "Left":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalBottom);
                scoreElement(Coordinates.blueGoalBottom, Coordinates.blueGoalBack);
                return Coordinates.blueGoalBack;
            }
            case "Center":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalMiddle);
                scoreElement(Coordinates.blueGoalMiddle, Coordinates.blueGoalBack);
                return Coordinates.blueGoalBack;
            }
            case "Right":{
                Navigation.goToGoal(Coordinates.blueGoalPoint1, Coordinates.blueGoalTop);
                scoreElement(Coordinates.blueGoalTop, Coordinates.blueGoalBack);
                return Coordinates.blueGoalBack;
            }
        }
        return null;
    }
}
