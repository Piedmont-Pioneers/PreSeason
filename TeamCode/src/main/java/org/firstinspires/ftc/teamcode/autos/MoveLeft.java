package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

@Autonomous(name = "MoveLeft", group = "Autos")
public class MoveLeft extends LinearOpMode {
    public void runOpMode() {
        Config config = new Config(telemetry, hardwareMap, gamepad1, gamepad2);
        DcMotor leftFrontDrive = config.hardwareMap.get(DcMotor.class, Config.leftFrontDrive);
        DcMotor rightFrontDrive = config.hardwareMap.get(DcMotor.class, Config.rightFrontDrive);
        DcMotor leftBackDrive = config.hardwareMap.get(DcMotor.class, Config.leftBackDrive);
        DcMotor rightBackDrive = config.hardwareMap.get(DcMotor.class, Config.rightBackDrive);

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        leftFrontDrive.setPower(-1);
        rightFrontDrive.setPower(-1);
        leftBackDrive.setPower(1);
        rightBackDrive.setPower(1);

        sleep(1000);

        leftFrontDrive.setPower(0);
        rightFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
}
