package fresh.lee.algorithm.java.design_pattern.commad;

import fresh.lee.algorithm.java.design_pattern.commad.commands.CeilingFanOffCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.CeilingFanOnCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.Command;
import fresh.lee.algorithm.java.design_pattern.commad.commands.GarageDoorDownCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.GarageDoorUpCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.LightOffCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.LightOnCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.MacroCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.StereoOffCommand;
import fresh.lee.algorithm.java.design_pattern.commad.commands.StereoWithCDCommand;
import fresh.lee.algorithm.java.design_pattern.commad.electric.CeilingFan;
import fresh.lee.algorithm.java.design_pattern.commad.electric.GarageDoor;
import fresh.lee.algorithm.java.design_pattern.commad.electric.Light;
import fresh.lee.algorithm.java.design_pattern.commad.electric.Stereo;

public class RemoteLoader {

    /**
     * 命令模式--将请求封装成对象，这可以让你使用不同的请求、队列或者日志请求来参数化其他对象。
     * 命令模式也可以支持撤销操作。
     * <p>
     * 命令模式将发出请求的对象和执行请求的对象解耦
     * 在被解耦的两者之间是通过命令对象进行沟通。命令对象封装了接收者的一个或一组动作
     * 调用者通过调用命令对象的execute()发出请求，这会使得接收者的动作被调用
     */
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanCommand = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);

        StereoWithCDCommand stereoWithCDCommand = new StereoWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanCommand, ceilingFanOffCommand);
        remoteControl.setCommand(3, garageDoorUpCommand, garageDoorDownCommand);
        remoteControl.setCommand(4, stereoWithCDCommand, stereoOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(5);

        Command[] partyOnCommands = {livingRoomLightOn, kitchenLightOn, ceilingFanCommand, stereoWithCDCommand};
        Command[] partyOffCommands = {livingRoomLightOff, kitchenLightOff, ceilingFanOffCommand, stereoOffCommand};


        MacroCommand partyOnCommand = new MacroCommand(partyOnCommands);
        MacroCommand partyOffCommand = new MacroCommand(partyOffCommands);
        remoteControl.setCommand(6, partyOnCommand, partyOffCommand);
        System.out.println("\n\nparty begin!!!!");
        remoteControl.onButtonWasPushed(6);

        System.out.println("\nafter happy time, party end!!!!");
        remoteControl.offButtonWasPushed(6);

    }
}
