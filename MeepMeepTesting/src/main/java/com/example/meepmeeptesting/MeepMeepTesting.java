package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(1000);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(47.265261473258434, 47.265261473258434, Math.toRadians(264.7214076246334), Math.toRadians(264.7214076246334), 19.18)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(32, -60, Math.toRadians(90)))

                        .forward(35)
                        .turn(Math.toRadians(-45))
                        .forward(20)
                        .turn(Math.toRadians(45))
                        .forward(-40)
                        .forward(30)
                        .turn(Math.toRadians(-45))
                        .forward(15)
                        .turn(Math.toRadians(45))
                        .forward(-40)
                        .forward(30)
                        .turn(Math.toRadians(-45))
                        .forward(15)
                        .turn(Math.toRadians(45))
                        .forward(-40)



                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}