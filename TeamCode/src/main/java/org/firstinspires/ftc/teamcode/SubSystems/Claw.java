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
        clawServo = config.hardwareMap.get(Servo.class, Config.CLAW_SERVO);
        clawServo.scaleRange(0, 1);
    }

    @Override
    public void update() {
        if (config.gamePad2.left_bumper) {
            clawServo.setPosition(1);
        } else if (config.gamePad2.right_bumper) {
            clawServo.setPosition(0);
        }
    }
}
