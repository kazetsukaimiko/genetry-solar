package com.genetrysolar.victor.jms.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.FANS_RESOURCE;
import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.FANS_TOPIC;

@JMSDestinationDefinition(
        name = FANS_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = FANS_TOPIC
)
public class FanTopicListener {
}
