package fresh.lee.algorithm.java.design_pattern.commad.commands;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("no command execute.");
    }

    @Override
    public void undo() {
        System.out.println("undo. no command execute.");
    }
}
