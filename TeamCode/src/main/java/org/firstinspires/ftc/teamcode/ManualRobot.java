package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.SubSystems.Arm;
import org.firstinspires.ftc.teamcode.SubSystems.Drive;
import org.firstinspires.ftc.teamcode.SubSystems.SubSystem;

import java.util.LinkedList;
import java.util.List;

public class ManualRobot {

    public Arm arm;

    // Config class to all hardware controls
    Config config;
    List<SubSystem> subSystems = new LinkedList<SubSystem>();

    // Constructor
    public ManualRobot(Config cfg) {
        config = cfg;
        subSystems.add(new Drive(config));

        arm = new Arm(config);
        subSystems.add(arm);
    }

    //
    public void init() {
        for (SubSystem sub : subSystems) {
            sub.init();
        }
    }

    public void update() {
        for (SubSystem sub : subSystems) {
            sub.update();
        }
    }
}
