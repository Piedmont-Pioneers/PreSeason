package org.firstinspires.ftc.teamcode.autos;

public class PreSeasonAuto extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        // TODO: Add movement times
        moveForward();
        strafeRight();
        moveForward();
        strafeLeft();
        moveForward();
        strafeRight();
        moveForward();


    }

}
