package fresh.lee.algorithm.java.design_pattern.commad.commands;

import fresh.lee.algorithm.java.design_pattern.commad.electric.Light;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
