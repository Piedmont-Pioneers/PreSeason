package org.firstinspires.ftc.teamcode.SubSystems;

import org.firstinspires.ftc.teamcode.Config;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm implements SubSystem {

    private Config config;
    private DcMotor armMotor;

    public Arm(Config cfg){
        this.config = cfg;
    }

    int power = 0;

    @Override
    public void init() {
        //armMotor = config.hardwareMap.get(DcMotor.class, Config.  )
    }

    public void update() {
        armMotor.setPower(power);
    }

    public void move(int p) {
        power = p;
    }



}
