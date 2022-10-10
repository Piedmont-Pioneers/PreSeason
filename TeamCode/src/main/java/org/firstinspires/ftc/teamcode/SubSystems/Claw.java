package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class Claw implements SubSystem {

    private final Config config;
    private Servo clawServo;

    public Claw(Config cfg) {
        this.config = cfg;
    }

    @Override
    public void init() {
        clawServo = config.hardwareMap.get(Servo.class, Config.clawServo);
        clawServo.scaleRange(0, 1);
    }

    @Override
    public void update() {
        if (config.gamePad1.left_bumper) {
            // TODO: MAKE CLAW CLOSE
            clawServo.setPosition(1);
        } else if (config.gamePad1.right_bumper) {
            // TODO: MAKE CLAW OPEN
            clawServo.setPosition(0);
        }
    }
}
