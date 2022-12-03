package org.firstinspires.ftc.teamcode.SubSystems;

import org.firstinspires.ftc.teamcode.Config;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm implements SubSystem {

    private final Config config;
    private DcMotor armMotor;

    public Arm(Config cfg){
        this.config = cfg;
    }

    @Override
    public void init() {
        armMotor = config.hardwareMap.get(DcMotor.class, Config.ARM_MOTOR);
        // Reset the encoder and set it to be in RUN_TO_POSITION
        armMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void update() {
        if (config.gamePad1.x) {
            armMotor.setPower(1);
        }
        else if (config.gamePad1.y) {
            armMotor.setPower(-1);
        }
        else {
            armMotor.setPower(0);
        }
    }
}