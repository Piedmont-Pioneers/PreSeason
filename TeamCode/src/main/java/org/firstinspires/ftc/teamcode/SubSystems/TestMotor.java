package org.firstinspires.ftc.teamcode.SubSystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;
public class TestMotor extends SubSystem {
    private Servo trigger;
    private DcMotor flywheel;
    private DcMotor intake;
    private DcMotor leftBackDrive;
    private DcMotor rightBackDrive;
    private DcMotor leftFrontDrive;
    private DcMotor rightFrontDrive;

    public TestMotor(Config config) {
        super(config);
    }


    @Override
    public void init() {

        leftFrontDrive = config.hardwareMap.get(DcMotor.class, Config.LEFT_FRONT_DRIVE);
        rightFrontDrive = config.hardwareMap.get(DcMotor.class, Config.RIGHT_FRONT_DRIVE);
        leftBackDrive = config.hardwareMap.get(DcMotor.class, Config.LEFT_BACK_DRIVE);
        rightBackDrive = config.hardwareMap.get(DcMotor.class, Config.RIGHT_BACK_DRIVE);
        intake = config.hardwareMap.get(DcMotor.class, Config.INTAKE_MOTOR);
        flywheel = config.hardwareMap.get(DcMotor.class, Config.FLYWHEEL_MOTOR);
        trigger= config.hardwareMap.get(Servo.class, Config.TRIGGER_MOTOR);
    }

    @Override
    public void update() {
        // TODO: Add some testing code
    }
}
