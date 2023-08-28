package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Intake implements SubSystem {
    private Config config;

    private DcMotor intake;

    public Intake(Config config) {
        this.config = config;
    }
    @Override
    public void init() {
        intake = config.hardwareMap.get(DcMotor.class, Config.INTAKE_MOTOR);
    }

    @Override
    public void update() {
        if(config.gamePad1.y) {
            intake.setPower(1);
        } else {
            intake.setPower(0.5);
        }

    }
}
