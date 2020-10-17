package com.genetrysolar.victor.entity.telemetry.enumerations;

// TODO: Sid needs to spill the beans on these flags
public enum AlarmBits {
    FLAGONE(0x000000000001),
    FLATTWO(0x000000000010),
    ;

    private final int bit;

    AlarmBits(int bit) {
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }
}
