package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

// CHANGE THIS to match YOUR drive class
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;


@Autonomous(name = "ForwardBackWithCorrection")
public class ForwardBackWithCorrection extends LinearOpMode {

    // How far robot can be pushed sideways before resetting (meters)
    static final double LATERAL_THRESHOLD = 0.15; // 15 cm

    @Override
    public void runOpMode() throws InterruptedException {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(0, 0, 0);
        drive.setPoseEstimate(startPose);

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {

            // ===== FORWARD =====
            Trajectory forward = drive.trajectoryBuilder(startPose)
                    .forward(70.0)
                    .strafeRight(10)
                    .strafeLeft(10)
                    .back(70)
                    .build();

            drive.followTrajectoryAsync(forward);

            while (opModeIsActive() && drive.isBusy()) {
                drive.update();

                if (isPushedSideways(drive)) {
                    returnToStart(drive, startPose);
                    continue;
                }
            }

            // ===== BACKWARD =====

        }
    }

    // Detect sideways push
    private boolean isPushedSideways(SampleMecanumDrive drive) {
        Pose2d pose = drive.getPoseEstimate();
        return Math.abs(pose.getY()) > LATERAL_THRESHOLD;
    }

    // Drive back to original pose
    private void returnToStart(SampleMecanumDrive drive, Pose2d startPose) {

        Trajectory reset = drive.trajectoryBuilder(drive.getPoseEstimate())
                .lineToLinearHeading(startPose)
                .build();

        drive.followTrajectory(reset);
        drive.setPoseEstimate(startPose);
    }
}
