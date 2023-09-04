package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.SubSystems.*;

import java.util.LinkedList;
import java.util.List;

public class ManualRobot {
    // Config class to all hardware controls
    Config config;
    List<SubSystem> subSystems = new LinkedList<SubSystem>();

    // Constructor
    public ManualRobot(Config cfg) {
        config = cfg;
        // Register the subsystem. System will not work if it's not registered
        subSystems.add(new Drive(config));
        subSystems.add(new Shooter(config));
        subSystems.add(new Intake(config));
    }

    // Initialize each subsystem
    public void init() {
        for (SubSystem sub : subSystems) {
            sub.init();
        }
    }

    // Update each subsystem
    public void update() {
        for (SubSystem sub : subSystems) {
            sub.update();
        }
    }
}
