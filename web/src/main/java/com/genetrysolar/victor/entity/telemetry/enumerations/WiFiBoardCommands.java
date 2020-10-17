package com.genetrysolar.victor.entity.telemetry.enumerations;


public enum WiFiBoardCommands {
    PWRon("PWRon", "powers on the inverter"),
    PWRoff("PWRoff", "powers off the inverter"),
    PWRsav("PWRsav", "powers on the inverter in power save mode"),
    PWRsw("PWRsw", "power save status determined by position of the power switch--PJ inverters only"),
    RESETerr("RESETerr", "clear error, restart inverter"),
    REFRESH("REFRESH", "request updated data string"),
    FanTest("FanTest", "run all fans to 100% like at startup");

    private final String command;
    private final String description;

    WiFiBoardCommands(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
