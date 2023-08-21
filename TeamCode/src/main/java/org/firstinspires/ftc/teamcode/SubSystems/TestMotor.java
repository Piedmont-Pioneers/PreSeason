package org.firstinspires.ftc.teamcode.SubSystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;
public class TestMotor implements SubSystem {
    private Config config;
    private Servo trigger;
    private DcMotor flywheel;
    private DcMotor intake;
    private DcMotor leftBackDrive;
    private DcMotor rightBackDrive;
    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;

    public TestMotor(Config config){
        this.config = config;
    }


    @Override
    public void init() {

    }

    @Override
    public void update() {

    }
}
