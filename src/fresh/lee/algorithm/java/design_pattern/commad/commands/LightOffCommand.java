package fresh.lee.algorithm.java.design_pattern.commad.commands;

import fresh.lee.algorithm.java.design_pattern.commad.electric.Light;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
