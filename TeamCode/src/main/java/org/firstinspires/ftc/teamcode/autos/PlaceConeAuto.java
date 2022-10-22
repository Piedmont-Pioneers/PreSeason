package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "PlaceCone", group = "Autos")
public class PlaceConeAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // INIT
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        DcMotor armMotor = hardwareMap.get(DcMotor.class, Config.ARM_MOTOR);
        Servo claw = hardwareMap.get(Servo.class, Config.CLAW_SERVO);

        claw.scaleRange(0, 1);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        TrajectorySequence trajectory =
                drive.trajectorySequenceBuilder(new Pose2d(-34, 56, Math.toRadians(270)))
                        // Move arm up
                        .addDisplacementMarker(() -> {
                            armMotor.setTargetPosition(100);
                        })
                        // Move to junction
                        .strafeLeft(20)
                        .forward(19)
                        .strafeRight(9)
                        .forward(3)
                        // Drop cone
                        .addDisplacementMarker(() -> {
                            claw.setPosition(1);
                        })
                        // Park in substation
                        .back(3)
                        .strafeLeft(9)
                        .back(23)
                        .strafeLeft(10)
                        .build();

        waitForStart();

        // RUN

        drive.followTrajectorySequence(trajectory);
    }
}
