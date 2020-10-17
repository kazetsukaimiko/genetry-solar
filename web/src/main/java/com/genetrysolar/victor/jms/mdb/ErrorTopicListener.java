package com.genetrysolar.victor.jms.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.ERRORS_RESOURCE;
import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.ERRORS_TOPIC;

@JMSDestinationDefinition(
        name = ERRORS_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = ERRORS_TOPIC
)
public class ErrorTopicListener {
}
