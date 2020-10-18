package com.genetrysolar.victor.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Collections;
import java.util.Enumeration;

@JMSDestinationDefinition(
        name = ExampleMessageListener.RESOURCE,
        interfaceName = "javax.jms.Topic",
        destinationName = "ExampleTopic"
)
@MessageDriven(activationConfig = {
        //@ActivationConfigProperty(propertyName="messagingType", propertyValue="javax.jms.MessageListener"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = ExampleMessageListener.RESOURCE),
        @ActivationConfigProperty(propertyName = "MaxPoolSize", propertyValue = "1"),
        @ActivationConfigProperty(propertyName = "MaxMessages", propertyValue = "1"),
        @ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "true")
})
public class ExampleMessageListener extends VictorMessageRecipients {
    public static final String RESOURCE = "java:app/jms/exampleTopic";

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
