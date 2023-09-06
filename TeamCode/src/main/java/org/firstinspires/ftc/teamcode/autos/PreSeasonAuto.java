package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.hardware.DcMotor;

public class PreSeasonAuto extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();


        moveForward(10);
        strafeRight(10);
        moveForward(10);
        strafeLeft(10);
        moveForward(10);
        strafeRight(10);
        moveForward(10);

    }

}
