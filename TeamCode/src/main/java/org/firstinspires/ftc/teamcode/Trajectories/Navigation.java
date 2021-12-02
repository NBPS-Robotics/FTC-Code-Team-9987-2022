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
    public static void goToGoal(Pose2d start,Pose2d goalWall, Pose2d goal){
        Robot.drive.setPoseEstimate(start);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(start)
                .lineTo(new Vector2d(goalWall.getX(), goalWall.getY()))
                .build();
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(goalWall)
                .strafeTo(new Vector2d(goal.getX(), goal.getY()))
                .build();
        Robot.drive.followTrajectory(trajectory);
        Robot.drive.followTrajectory(trajectory2);
    }
    public static void goToWarehouse(Pose2d goal,Pose2d goalWall, Pose2d warehouse){
        Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(goal)
                .lineToLinearHeading(goalWall)
                .build();
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(goalWall)
                .lineToLinearHeading(warehouse)
                .build();
        Robot.drive.followTrajectory(trajectory);
        Robot.drive.followTrajectory(trajectory2);
    }
    public static void goToCarousel(Pose2d goal, Pose2d spinnerWall, Pose2d spinner){
        Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(goal)
                .lineToLinearHeading(spinnerWall)
                .build();
        Trajectory trajectory2 = Robot.drive.trajectoryBuilder(spinnerWall)
                .lineToLinearHeading(spinner)
                .build();
        Robot.drive.followTrajectory(trajectory);
        Robot.drive.followTrajectory(trajectory2);
    }
    public static void goToStorage(Pose2d spinner, Pose2d storage){
        Robot.drive.setPoseEstimate(spinner);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(spinner)
                .lineToLinearHeading(storage)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
}
