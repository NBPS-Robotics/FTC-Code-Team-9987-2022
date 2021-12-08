package org.firstinspires.ftc.teamcode.Trajectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.AngularVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.ProfileAccelerationConstraint;

import org.firstinspires.ftc.teamcode.Mecanum_Drive.DriveConstants;
import org.firstinspires.ftc.teamcode.Robot.Claw;
import org.firstinspires.ftc.teamcode.Robot.Arm;
import org.firstinspires.ftc.teamcode.Robot.Robot;

import java.util.Arrays;

public class Navigation {
    public static void moveLeft(Pose2d start){
        Trajectory trajectory = Robot.drive.trajectoryBuilder(start)
                .strafeRight(75)
                .build();

        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToGoalPoint(Pose2d start,Pose2d goalPoint){
        Robot.drive.setPoseEstimate(start);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(start)
                .lineToLinearHeading(goalPoint)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToGoal(Pose2d goalPoint, Pose2d goal){
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(goalPoint)
                .lineToLinearHeading(goal)
                .build();
        Robot.drive.followTrajectory(trajectory2);
    }
    public static void goToCarousel(Pose2d goal, Pose2d spinnerWall, Pose2d spinner){
        //Robot.drive.setPoseEstimate(goal);
        if(goal.getHeading()==0) Robot.drive.turn(Math.toRadians(90));
        else Robot.drive.turn(Math.toRadians(-90));
        Trajectory trajectory = Robot.drive.trajectoryBuilder(new Pose2d(goal.getX(),goal.getY(), Coordinates.redSpinnerWall.getHeading()))
                .lineToLinearHeading(spinnerWall)
                .build();
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(spinnerWall)
                .lineToLinearHeading(spinner)
                .build();
        Robot.drive.followTrajectory(trajectory);
        Robot.drive.followTrajectory(trajectory2);
    }
    public static void goToStorage(Pose2d spinner, Pose2d storage){
        //Robot.drive.setPoseEstimate(spinner);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(spinner)
                .lineToLinearHeading(storage)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToWarehouse(Pose2d goal,Pose2d goalWall, Pose2d warehouse){
        //Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(goal)
                .lineToLinearHeading(goalWall)
                .build();
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(goalWall)
                .lineToLinearHeading(warehouse)
                .build();
        Robot.drive.followTrajectory(trajectory);
        Robot.drive.followTrajectory(trajectory2);
    }
    public static void goToWarehouseFromCarousel(Pose2d spinner, Pose2d spinnerWall,Pose2d goalWall, Pose2d warehouse){
        //Robot.drive.setPoseEstimate(spinner);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(spinner)
                .lineToLinearHeading(goalWall)
                .build();
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(spinnerWall)
                .lineToLinearHeading(goalWall)
                .build();
        Trajectory trajectory3 = Robot.drive.trajectoryBuilder(goalWall)
                .lineToLinearHeading(warehouse)
                .build();
        Robot.drive.followTrajectory(trajectory);
        Robot.drive.followTrajectory(trajectory2);
        Robot.drive.followTrajectory(trajectory3);
    }
    public static void clearWarehouse(Pose2d warehouse,Pose2d warehousePoint){
        //Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(warehouse)
                .lineToLinearHeading(warehousePoint)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
}
