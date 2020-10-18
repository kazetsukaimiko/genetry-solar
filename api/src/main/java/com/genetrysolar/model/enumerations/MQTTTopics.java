package com.genetrysolar.model.enumerations;

import static com.genetrysolar.model.enumerations.MQTTConstants.CMD_TOPIC;
import static com.genetrysolar.model.enumerations.MQTTConstants.ERRORS_TOPIC;
import static com.genetrysolar.model.enumerations.MQTTConstants.FANS_TOPIC;
import static com.genetrysolar.model.enumerations.MQTTConstants.IN_TOPIC;
import static com.genetrysolar.model.enumerations.MQTTConstants.OUT_TOPIC;
import static com.genetrysolar.model.enumerations.MQTTConstants.STATS_TOPIC;
import static com.genetrysolar.model.enumerations.MQTTConstants.TEMPS_TOPIC;

public enum MQTTTopics {
    CMD(CMD_TOPIC, "inverter commands"),
    OUT(OUT_TOPIC, "AC output specs"),
    IN(IN_TOPIC, "AC input / battery input"),
    STATS(STATS_TOPIC, "various info about the system"),
    FANS(FANS_TOPIC, "fan channel throttle values"),
    ERRORS(ERRORS_TOPIC, "alarm bitflags, error"),
    TEMPS(TEMPS_TOPIC, "radix, and each temperature channel's calibrated/calculated value");

    public final String topicName;
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
