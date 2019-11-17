package fresh.lee.algorithm.java.design_pattern.commad;

import fresh.lee.algorithm.java.design_pattern.commad.commands.Command;
import fresh.lee.algorithm.java.design_pattern.commad.commands.NoCommand;

/**
 * 遥控器，隔离了命令和具体电器之间的联系
 * 而且是即插即用
 */
public class RemoteControl {
    private static final int SLOT_SIZE = 7;
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[SLOT_SIZE];
        offCommands = new Command[SLOT_SIZE];

        Command noCommand = new NoCommand();
        for (int i = 0; i < SLOT_SIZE; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        check(slot);
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        check(slot);
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        check(slot);
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    private void check(int slot) {
        if (slot < 0 || slot >= SLOT_SIZE) {
            throw new IllegalArgumentException("slot must between 0 and 7(exclude).");
        }
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------Remote Control-------\n");
        for (int i = 0; i < SLOT_SIZE; i++) {
            sb.append("slot [")
                    .append(i)
                    .append("] ")
                    .append(onCommands[i].getClass().getName())
                    .append("   ")
                    .append(offCommands[i].getClass().getName())
                    .append("\n");
        }
        return sb.toString();
    }
}
