package fresh.lee.algorithm.java.design_pattern.commad.commands;

import fresh.lee.algorithm.java.design_pattern.commad.electric.Stereo;

public class StereoWithCDCommand implements Command {

    private Stereo stereo;

    public StereoWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
