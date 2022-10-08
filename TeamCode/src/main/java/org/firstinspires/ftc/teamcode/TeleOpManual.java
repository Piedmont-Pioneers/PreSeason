package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp", group="Linear Opmode")
public class TeleOpManual extends LinearOpMode {
    // Config
    Config config = null;
    ManualRobot manualRobot = null;

    @Override
    public void runOpMode() {

        config = new Config(telemetry, hardwareMap, gamepad1, gamepad2);
        manualRobot = new ManualRobot(config);

        manualRobot.init();
        waitForStart();

        while (opModeIsActive()) {
            config.updateTelemetry();

            // runs each sub-system once
            manualRobot.update();

            // Show the elapsed game time and wheel power.
            telemetry.update();

            if (gamepad2.a) {
                manualRobot.arm.move(1);
            }
            else if(gamepad2.b) {
                manualRobot.arm.move(-1);
            }
            else {
                manualRobot.arm.move(0);
            }
        }
    }
}

