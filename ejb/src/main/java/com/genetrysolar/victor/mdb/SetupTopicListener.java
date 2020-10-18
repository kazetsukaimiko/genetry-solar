package com.genetrysolar.victor.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.model.enumerations.MQTTConstants.SETUP_RESOURCE;
import static com.genetrysolar.model.enumerations.MQTTConstants.SETUP_TOPIC;

@JMSDestinationDefinition(
        name = SETUP_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = SETUP_TOPIC
)
public class SetupTopicListener {
}
