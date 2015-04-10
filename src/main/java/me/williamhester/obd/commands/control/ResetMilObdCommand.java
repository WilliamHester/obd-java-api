package me.williamhester.obd.commands.control;

import me.williamhester.obd.commands.ObdCommand;

/**
 * Created by william on 4/10/15.
 */
public class ResetMilObdCommand extends ObdCommand {

    public ResetMilObdCommand() {
    }

    @Override
    protected String getCommand() {
        return "00";
    }

    @Override
    protected String getMode() {
        return "04";
    }

    @Override
    protected void performCalculations() {

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
