package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "ConeCycleAutoBlue", group = "Autos")
public class ConeCycleAutoBlue extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // INIT
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        DcMotor armMotor = hardwareMap.get(DcMotor.class, Config.ARM_MOTOR);
        Servo claw = hardwareMap.get(Servo.class, Config.CLAW_SERVO);

        claw.scaleRange(0, 1);

        TrajectorySequence getIntoStartingPos = drive.trajectorySequenceBuilder(new Pose2d(0D, 0D, 0))
                .addDisplacementMarker(() -> {
                    // TODO: Move arm to position
                })
                .forward(48)
                .turn(Math.toRadians(-90))
                .build();

        TrajectorySequence mainLoop = drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                .forward(25)
                .addDisplacementMarker(() -> {
                    // FIXME TEST: Grab Cone
                    claw.setPosition(0);
                    // TODO: Lift arm to position to deposit cone
                })
                .back(25)
                .strafeRight(11)
                .forward(5)
                .addDisplacementMarker(() -> {
                    // FIXME TEST: Drop Cone
                    claw.setPosition(1);
                })
                .back(5)
                .strafeLeft(11)
                .build();

        waitForStart();

        // RUN

        drive.followTrajectorySequence(getIntoStartingPos);

        // LOOP
        while (opModeIsActive()) {
            drive.followTrajectorySequence(mainLoop);
        }
    }

}
