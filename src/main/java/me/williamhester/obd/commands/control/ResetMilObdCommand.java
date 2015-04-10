package me.williamhester.obd.commands.control;

import me.williamhester.obd.commands.AbsObdCommand;

/**
 * Created by william on 4/10/15.
 */
public class ResetMilObdCommand extends AbsObdCommand {

    public ResetMilObdCommand() { }

    @Override
    protected String getCommand() {
        return null;
    }

    @Override
    protected String getMode() {
        return "04";
    }

    @Override
    protected void fillBuffer() {
        // do nothing
    }

    @Override
    public String getFormattedResult() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
