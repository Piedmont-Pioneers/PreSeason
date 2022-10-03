package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Config;
import org.firstinspires.ftc.teamcode.ManualRobot;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@TeleOp(name = "ParkInRedTerminal", group = "Autos")
public class ParkInRedTerminal extends LinearOpMode {
    public void runOpMode() {
        Config config;
        config = new Config(telemetry, hardwareMap, gamepad1, gamepad2);
        ManualRobot robot = new ManualRobot(config);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        TrajectorySequence trajectory = drive.trajectorySequenceBuilder(new Pose2d())
                .strafeRight(20)
                .build();


        drive.followTrajectorySequence(trajectory);

        while (opModeIsActive()) {
            robot.update();
        }
    }
}