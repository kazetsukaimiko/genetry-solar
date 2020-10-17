package com.genetrysolar.victor.entity.telemetry.enumerations;

public enum MQTTTopics {
    CMD("cmd", "inverter commands"),
    OUT("out", "AC output specs"),
    IN("in", "AC input / battery input"),
    STATS("stats", "various info about the system"),
    FANS("fans", "fan channel throttle values"),
    ERRORS("errors", "alarm bitflags, error"),
    TEMPS("temps", "radix, and each temperature channel's calibrated/calculated value");

    private final String topicName;
    private final String description;

    MQTTTopics(String topicName, String description) {
        this.topicName = topicName;
        this.description = description;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getDescription() {
        return description;
    }
}
