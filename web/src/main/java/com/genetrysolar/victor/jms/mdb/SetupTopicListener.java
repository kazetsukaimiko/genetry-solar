package com.genetrysolar.victor.jms.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.SETUP_RESOURCE;
import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.SETUP_TOPIC;

@JMSDestinationDefinition(
        name = SETUP_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = SETUP_TOPIC
)
public class SetupTopicListener {
}
