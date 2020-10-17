package com.genetrysolar.victor.service.telemetry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genetrysolar.victor.entity.telemetry.StatusTelemetry;
import com.genetrysolar.victor.entity.telemetry.TelemetryFragment;
import com.genetrysolar.victor.entity.telemetry.enumerations.MQTTConstants;
import com.genetrysolar.victor.jms.mdb.ExampleMessageListener;
import com.genetrysolar.victor.jms.mdb.VictorMessageRecipients;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Main service for sending telemetry messages.
 */
@ApplicationScoped
public class TelemetryMessaging {
    private static final Logger LOGGER = Logger.getLogger(TelemetryMessaging.class.getName());

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Resource
    @JMSConnectionFactory(VictorMessageRecipients.FACTORY_RESOURCE)
    private ConnectionFactory connectionFactory;

    @Resource(lookup = ExampleMessageListener.RESOURCE)
    private Topic exampleTopic;

    @Resource(lookup = MQTTConstants.ERRORS_RESOURCE)
    private Topic errorTopic;

    @Resource(lookup = MQTTConstants.FANS_RESOURCE)
    private Topic fanTopic;

    @Resource(lookup = MQTTConstants.IN_RESOURCE)
    private Topic inTopic;

    @Resource(lookup = MQTTConstants.OUT_RESOURCE)
    private Topic outTopic;

    @Resource(lookup = MQTTConstants.STATS_RESOURCE)
    private Topic statusTopic;

    @Resource(lookup = MQTTConstants.TEMPS_RESOURCE)
    private Topic tempTopic;

    public void sendStatus(StatusTelemetry statusTelemetry) {
        sendMessage(statusTopic, statusTelemetry, m -> {
        });
    }

    public void sendMessage(Topic topic, TelemetryFragment telemetryFragment, Consumer<Message> additional) {
        try {
            sendMessage(topic, OBJECT_MAPPER.writeValueAsString(telemetryFragment), telemetryFragment.getSourceId(), additional);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.SEVERE, "Unable to write message", e);
            e.printStackTrace();
        }
    }

    /**
     * TODO : Priorities, quoting Sid
     * Mostly what we would be interested in would be
     * "temperature vs load" charts (particularly inverter temps
     * correlated to ambient temp + load percentage.)
     * Sean may have other ideas;
     */
    public void sendMessage(Topic topic, String content, String sourceId, Consumer<Message> additional) {
        try (Connection connection = connectionFactory.createConnection()) {
            try (Session session = connection.createSession()) {
                try (MessageProducer producer = session.createProducer(topic)) {
                    Message message = session.createTextMessage(content);
                    message.setStringProperty("source", sourceId);
                    additional.accept(message);
                    producer.send(message);
                }
            }
        } catch (JMSException e) {
            throw new RuntimeException("Unable to send message", e);
        }
    }
}
