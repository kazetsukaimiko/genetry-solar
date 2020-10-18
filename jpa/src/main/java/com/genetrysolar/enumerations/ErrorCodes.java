package com.genetrysolar.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
    NONE(0, "None"),
    COOLING_FAN(1, "Cooling Fan"),
    XFORMER_OVERHEAT(2, "XFormer Overheat"),
    FET_OVERHEAT(3, "FET Overheat"),
    OVP_SHUTDOWN(4, "OVP Shutdown"),
    UVP_SHUTDOWN(5, "UVP Shutdown"),
    AC_OUTPUT_OVP(6, "AC Output OVP"),
    AC_OUTPUT_UVP(7, "AC Output UVP"),
    AC_OUTPUT_Error(8, "AC Output Error"),
    OVERLOAD_SHUTDOWN(9, "Overload Shutdown"),
    POWER_SWITCH_ERR(10, "Power Switch Err"),
    WIFI_BOARD_MISSING(11, "WiFi Board Missing"),
    BAD_SYSTEM_CONFIG(126, "Bad System Config"),
    SYSTEM_OVERHEAT(128, "System Overheat"),
    INVERTER_OVERLOAD(130, "Inverter Overload"),
    POWER_METER_FAIL(140, "Power Meter Fail"),
    CPU_FIRMWARE_FAIL(160, "CPU Firmware Fail");

    private final int code;
    private final String description;

    ErrorCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
