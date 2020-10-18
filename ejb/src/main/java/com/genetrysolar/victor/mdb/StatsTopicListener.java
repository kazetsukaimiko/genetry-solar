package com.genetrysolar.victor.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Collections;
import java.util.Enumeration;

import static com.genetrysolar.model.enumerations.MQTTConstants.STATS_RESOURCE;
import static com.genetrysolar.model.enumerations.MQTTConstants.STATS_TOPIC;

@JMSDestinationDefinition(
        name = StatsTopicListener.RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = STATS_TOPIC
)
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "messagingType", propertyValue = "javax.jms.MessageListener"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = StatsTopicListener.RESOURCE),
        @ActivationConfigProperty(propertyName = "MaxPoolSize", propertyValue = "1"),
        @ActivationConfigProperty(propertyName = "MaxMessages", propertyValue = "1"),
        @ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "true")
})
public class StatsTopicListener extends VictorMessageRecipients {
    public static final String RESOURCE = STATS_RESOURCE;

    @Override
    @SuppressWarnings("unchecked")
    public void onMessage(Message message) {
        try {
            Collections.list((Enumeration<String>) message.getPropertyNames())
                    .forEach(System.out::println);
            if (message instanceof TextMessage) {
                System.out.println(((TextMessage) message).getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
