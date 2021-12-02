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
                .lineToLinearHeading(goalWall)
                .strafeTo(new Vector2d(goal.getX(), goal.getY()))
                //.addTemporalMarker(0.6, () -> Lift.moveDown(1))
                //.addTemporalMarker(1.4, () -> Lift.moveDown(0.3))
                //.addTemporalMarker(3, Lift::stop)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToWarehouse(Pose2d goal,Pose2d goalWall, Pose2d warehouse){
        Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(goal)
                .lineToLinearHeading(goalWall)
                .strafeTo(new Vector2d(warehouse.getX(), warehouse.getY()))
                //.addTemporalMarker(0.6, () -> Lift.moveDown(1))
                //.addTemporalMarker(1.4, () -> Lift.moveDown(0.3))
                //.addTemporalMarker(3, Lift::stop)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToCarousel(Pose2d goal, Pose2d spinnerWall, Pose2d spinner){
        Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(goal)
                .lineToLinearHeading(spinnerWall)
                .lineToLinearHeading(spinner)
                //.addTemporalMarker(0.6, () -> Lift.moveDown(1))
                //.addTemporalMarker(1.4, () -> Lift.moveDown(0.3))
                //.addTemporalMarker(3, Lift::stop)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToStorage(Pose2d spinner, Pose2d storage){
        Robot.drive.setPoseEstimate(spinner);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(spinner)
                .lineToLinearHeading(storage)
                //.addTemporalMarker(0.6, () -> Lift.moveDown(1))
                //.addTemporalMarker(1.4, () -> Lift.moveDown(0.3))
                //.addTemporalMarker(3, Lift::stop)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
}
