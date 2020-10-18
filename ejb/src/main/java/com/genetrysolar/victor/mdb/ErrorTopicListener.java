package com.genetrysolar.victor.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.model.enumerations.MQTTConstants.ERRORS_RESOURCE;
import static com.genetrysolar.model.enumerations.MQTTConstants.ERRORS_TOPIC;

@JMSDestinationDefinition(
        name = ERRORS_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = ERRORS_TOPIC
)
public class ErrorTopicListener {
}
