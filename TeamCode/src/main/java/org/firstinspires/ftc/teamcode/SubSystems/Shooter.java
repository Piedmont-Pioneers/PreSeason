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

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }
}
