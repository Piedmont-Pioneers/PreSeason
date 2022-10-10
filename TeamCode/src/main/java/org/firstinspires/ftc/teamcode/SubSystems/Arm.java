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
        armMotor = config.hardwareMap.get(DcMotor.class, Config.armMotor);
        // Reset the encoder and set it to be in RUN_TO_POSITION
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void update() {

        if (config.gamePad2.a) {
            armMotor.setTargetPosition(1000);
        } else if (config.gamePad2.x) {
            armMotor.setTargetPosition(750);
        } else if (config.gamePad2.b) {
            armMotor.setTargetPosition(250);
        } else if(config.gamePad2.y) {
            armMotor.setTargetPosition(0);
        }
    }
}
