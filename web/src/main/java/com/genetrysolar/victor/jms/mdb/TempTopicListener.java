package com.genetrysolar.victor.jms.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.TEMPS_RESOURCE;
import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.TEMPS_TOPIC;

@JMSDestinationDefinition(
        name = TEMPS_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = TEMPS_TOPIC
)
public class TempTopicListener {
}
