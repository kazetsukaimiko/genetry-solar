package com.genetrysolar.victor.mdb;


import javax.jms.JMSDestinationDefinition;

import static com.genetrysolar.model.enumerations.MQTTConstants.FANS_RESOURCE;
import static com.genetrysolar.model.enumerations.MQTTConstants.FANS_TOPIC;

@JMSDestinationDefinition(
        name = FANS_RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = FANS_TOPIC
)
public class FanTopicListener {
}
