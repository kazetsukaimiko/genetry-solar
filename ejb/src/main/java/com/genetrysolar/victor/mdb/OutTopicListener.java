package com.genetrysolar.victor.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.model.enumerations.MQTTConstants.OUT_RESOURCE;

@JMSDestinationDefinition(
        name = OUT_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = OUT_RESOURCE
)
public class OutTopicListener {
}
