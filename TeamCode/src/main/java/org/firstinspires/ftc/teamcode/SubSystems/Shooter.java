package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Shooter implements SubSystem {
    private final Config config;
    private Servo trigger;
    private DcMotor flywheel;
    public Shooter(Config config) {
        this.config = config;

    }


    public void init() {
        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        trigger = config.hardwareMap.get(Servo.class, Config.SHOOTER_SERVO);
        flywheel = config.hardwareMap.get(DcMotor.class, Config.FLYWHEEL_MOTOR);

        // We might need to change the value below to FORWARD,
        // depending on how the motor is mounted.
        flywheel.setDirection(DcMotor.Direction.REVERSE);
        trigger.
    }

    @Override
    public void update() {

    }

}
