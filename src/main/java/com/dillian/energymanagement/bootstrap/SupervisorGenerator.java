package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SupervisorGenerator {

    public Supervisor[] createWithBasicProperties() {

        Supervisor supervisor1 = new Supervisor(1L, "Amelia", "Lupina",
                "D:\\Java projects\\Energy Management\\photos\\Amelia Lupina.png", null, null );
        Supervisor supervisor2 = new Supervisor(2L, "Tessa", "Savours",
                "D:\\Java projects\\Energy Management\\photos\\Tessa Savours.png", null, null);
        Supervisor supervisor3 = new Supervisor(3L, "Quillick", "Windsworth",
                "D:\\Java projects\\Energy Management\\photos\\Quillick Windsworth.png", null, null);
        Supervisor supervisor4 = new Supervisor(4L, "Henrick", "Righthood",
                "D:\\Java projects\\Energy Management\\photos\\Henrick Righthood.png", null, null);
        return new Supervisor[]{supervisor1, supervisor2, supervisor3, supervisor4};
    }
}
