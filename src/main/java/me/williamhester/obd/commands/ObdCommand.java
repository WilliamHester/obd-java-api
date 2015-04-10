package me.williamhester.obd.commands;

/**
 * Created by william on 4/10/15.
 */
public class ObdCommand extends AbsObdCommand {


    private String command;
    private String mode;

    /**
     * @param command a {@link java.lang.String} object.
     */
    public ObdCommand(String mode, String command) {
        this.mode = mode;
        this.command = command;
    }

    @Override
    protected String getCommand() {
        return command;
    }

    @Override
    protected String getMode() {
        return mode;
    }

    @Override
    public String getFormattedResult() {
        return getResult();
    }

    @Override
    public String getName() {
        return "Mode: " + getMode() + " Command: " + getCommand();
    }
}
