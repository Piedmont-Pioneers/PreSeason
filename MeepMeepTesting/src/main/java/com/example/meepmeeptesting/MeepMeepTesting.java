package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.ColorScheme;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = autoBlue(meepMeep);

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }



    public static RoadRunnerBotEntity parkInTerminalRed(MeepMeep meepMeep) {
        return new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(19.536997917000335, 19.536997917000335, Math.toRadians(67.84166818181818), Math.toRadians(67.84166818181818), 16.5)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-60, -34, 0))
                                .strafeRight(20)
                                .build()
                );
    }

    public static RoadRunnerBotEntity parkInTerminalBlue(MeepMeep meepMeep) {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(19.536997917000335, 19.536997917000335, Math.toRadians(67.84166818181818), Math.toRadians(67.84166818181818), 16.5)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-60, 34, 0))
                                .strafeLeft(20)
                                .build()
                );
    }

    public static RoadRunnerBotEntity parkInSubstationRed(MeepMeep meepMeep) {
        return new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(19.536997917000335, 19.536997917000335, Math.toRadians(67.84166818181818), Math.toRadians(67.84166818181818), 16.5)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-34, -60, Math.toRadians(90)))
                                .strafeRight(35)
                                .build()
                );
    }

    public static RoadRunnerBotEntity parkInSubstationBlue(MeepMeep meepMeep) {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(19.536997917000335, 19.536997917000335, Math.toRadians(67.84166818181818), Math.toRadians(67.84166818181818), 16.5)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-34, 60, Math.toRadians(-90)))
                                .strafeLeft(35)
                                .build()
                );
    }

    public static RoadRunnerBotEntity autoBlue(MeepMeep meepMeep) {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-34, 60, Math.toRadians(270)))
                                .addDisplacementMarker(() -> {
                                    // Move arm motor
                                })
                                .strafeLeft(21)
                                .forward(23)
                                .strafeRight(10)
                                .forward(8)
                                .addDisplacementMarker(() -> {
                                    // Release Cone
                                })
                                .back(8)
                                .strafeLeft(10)
                                .back(23)
                                .strafeLeft(10)
                                .build()
                );
    }
}