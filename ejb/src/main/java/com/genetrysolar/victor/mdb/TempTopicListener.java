package com.genetrysolar.victor.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.model.enumerations.MQTTConstants.TEMPS_RESOURCE;
import static com.genetrysolar.model.enumerations.MQTTConstants.TEMPS_TOPIC;

@JMSDestinationDefinition(
        name = TEMPS_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = TEMPS_TOPIC
)
public class TempTopicListener {
}
