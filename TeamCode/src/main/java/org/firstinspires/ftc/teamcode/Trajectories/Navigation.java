package org.firstinspires.ftc.teamcode.Trajectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.AngularVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.ProfileAccelerationConstraint;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Mecanum_Drive.DriveConstants;
import org.firstinspires.ftc.teamcode.Robot.Claw;
import org.firstinspires.ftc.teamcode.Robot.Arm;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import java.util.Arrays;

public class Navigation {
    public static void moveLeft(Pose2d start){
        Trajectory trajectory = Robot.drive.trajectoryBuilder(start)
                .strafeRight(25)
                .build();

        Robot.drive.followTrajectoryAsync(trajectory);
        while(Robot.drive.isBusy()){
            Robot.update();
        }
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
        Robot.drive.followTrajectoryAsync(trajectory2);
    }
    public static void backfromGoal(Pose2d goal, Pose2d goalBack){
        Trajectory trajectory = Robot.drive.trajectoryBuilder(goal)
                .lineToLinearHeading(goalBack)
                .build();
        Robot.drive.followTrajectory(trajectory);
        if(goal.getHeading()==0) Robot.drive.turn(Math.toRadians(-90));
        else Robot.drive.turn(Math.toRadians(90));
    }
    public static void goToCarousel(Pose2d goalBack, Pose2d spinnerWall, Pose2d spinner){
        //Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(new Pose2d(goalBack.getX(),goalBack.getY(), Coordinates.redSpinnerWall.getHeading()))
                .splineToConstantHeading(new Vector2d(spinnerWall.getX(), spinnerWall.getY()), spinnerWall.getHeading())
                .splineToConstantHeading(new Vector2d(spinner.getX(), spinner.getY()), spinner.getHeading())
                .build();
        Robot.drive.followTrajectory(trajectory);
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
                .splineToConstantHeading(new Vector2d(goalWall.getX(), goalWall.getY()), goalWall.getHeading())
                .splineToConstantHeading(new Vector2d(warehouse.getX(), warehouse.getY()), warehouse.getHeading())
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void goToWarehouseFromCarousel(Pose2d spinner, Pose2d spinnerWall,Pose2d goalWall, Pose2d warehouse){
        //Robot.drive.setPoseEstimate(spinner);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(spinner)
                .splineToConstantHeading(new Vector2d(spinnerWall.getX(), spinnerWall.getY()), spinnerWall.getHeading())
                .splineToConstantHeading(new Vector2d(goalWall.getX(), goalWall.getY()), goalWall.getHeading())
                .splineToConstantHeading(new Vector2d(warehouse.getX(), warehouse.getY()), warehouse.getHeading())
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
    public static void clearWarehouse(Pose2d warehouse,Pose2d warehousePoint){
        //Robot.drive.setPoseEstimate(goal);
        Trajectory trajectory = Robot.drive.trajectoryBuilder(warehouse)
                .lineToLinearHeading(warehousePoint)
                .build();
        Robot.drive.followTrajectory(trajectory);
    }
}
