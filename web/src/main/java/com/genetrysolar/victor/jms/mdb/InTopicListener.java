package com.genetrysolar.victor.jms.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.IN_RESOURCE;
import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.IN_TOPIC;

@JMSDestinationDefinition(
        name = IN_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = IN_TOPIC
)
public class InTopicListener {
}
