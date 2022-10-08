package org.firstinspires.ftc.teamcode.SubSystems;

import org.firstinspires.ftc.teamcode.Config;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm implements SubSystem {

    private Config config;
    private DcMotor armMotor;

    public Arm(Config cfg){
        this.config = cfg;
    }

    @Override
    public void init() {
        armMotor = config.hardwareMap.get(DcMotor.class, Config.armMotor);
    }

    public void update() {

        if (config.gamePad2.a) {
            armMotor.setPower(1);
        }
        else if(config.gamePad2.b) {
            armMotor.setPower(-11);
        }
        else {
            armMotor.setPower(0);
        }
    }
}
