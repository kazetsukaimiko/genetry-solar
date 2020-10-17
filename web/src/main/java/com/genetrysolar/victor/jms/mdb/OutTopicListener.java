package com.genetrysolar.victor.jms.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants.OUT_RESOURCE;

@JMSDestinationDefinition(
        name = OUT_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = OUT_RESOURCE
)
public class OutTopicListener {
}
