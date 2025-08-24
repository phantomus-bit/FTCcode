package org.firstinspires.ftc.teamcode.drive;

import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.drive.TankDrive;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.BaseTrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SampleTankDrive extends TankDrive implements uhm {
    private DcMotor leftMotor, rightMotor;

    public SampleTankDrive(HardwareMap hardwareMap) {
        super(1.0, 0.0, 0.0, 15.0);
         // Track width in inches – tweak as needed for your robot

        leftMotor = hardwareMap.get(DcMotor.class, "motorLeft");
        rightMotor = hardwareMap.get(DcMotor.class, "motorRight");

        leftMotor.setDirection(DcMotor.Direction.REVERSE); // Adjust if needed
    }

    @Override
    public List<DcMotor> getMotors() {
        return Arrays.asList(leftMotor, rightMotor);
    }

    @Override
    public void setMotorPowers(double leftPower, double rightPower) {
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }




    @Override
    public void update() {
        super.updatePoseEstimate();
    }

    public <T extends BaseTrajectoryBuilder<T>> BaseTrajectoryBuilder<T> trajectoryBuilder(Pose2d startPose) {
        return null;
    }

    @NonNull
    @Override
    public List<Double> getWheelPositions() {
        return Collections.emptyList();
    }

    @Override
    protected double getRawExternalHeading() {
        return 0;
    }

    public void followTrajectory(Trajectory forwardTrajectory) {
    }
}
