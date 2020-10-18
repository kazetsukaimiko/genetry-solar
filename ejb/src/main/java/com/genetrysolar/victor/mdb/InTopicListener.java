package com.genetrysolar.victor.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.model.enumerations.MQTTConstants.IN_RESOURCE;
import static com.genetrysolar.model.enumerations.MQTTConstants.IN_TOPIC;

@JMSDestinationDefinition(
        name = IN_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = IN_TOPIC
)
public class InTopicListener {
}
