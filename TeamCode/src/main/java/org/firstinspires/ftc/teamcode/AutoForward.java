package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;

@Autonomous(name = "Auto Forward", group = "RoadRunner")
public class AutoForward extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Initialize your drive system (using Road Runner's SampleTankDrive)
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);

        // Define the starting pose of the robot
        Pose2d startPose = new Pose2d(0, 0, 0);
        drive.setPoseEstimate(startPose);

        // Build the trajectory to move forward by 20 inches
        Trajectory forwardTrajectory = drive.trajectoryBuilder(startPose)
                .forward(20)
                .build();

        // Wait for the start of the autonomous period
        waitForStart();

        if (isStopRequested()) return;

        // Follow the trajectory to move the robot
        drive.followTrajectory(forwardTrajectory);
    }
}
