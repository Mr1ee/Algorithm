package fresh.lee.algorithm.java.design_pattern.commad.commands;

import fresh.lee.algorithm.java.design_pattern.commad.electric.Stereo;

public class StereoOffCommand implements Command {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        System.out.println("StereoOffCommand undo.");
        stereo.on();
    }
}
