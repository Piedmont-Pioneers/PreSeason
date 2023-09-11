package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.ColorScheme;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

publi   qwerc class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = coneCycleAutoBlue(meepMeep);

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

    public static RoadRunnerBotEntity coneCycleAutoBlue(MeepMeep meepMeep) {
        return new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-34, 60, Math.toRadians(270)))
                                .addDisplacementMarker(() -> {
                                    // TODO: Move arm to position
                                })
                                .forward(48)
                                .turn(Math.toRadians(-90))
                                // TODO: LOOP THIS PART
                                .forward(25)
                                .addDisplacementMarker(() -> {
                                    // TODO: Grab Cone
                                    // TODO: Lift arm to position to deposit cone
                                })
                                .back(25)
                                .strafeRight(11)
                                .forward(5)
                                .addDisplacementMarker(() -> {
                                    // TODO: Drop Cone
                                })
                                .back(5)
                                .strafeLeft(11)
                                .build()
                );
    }
}