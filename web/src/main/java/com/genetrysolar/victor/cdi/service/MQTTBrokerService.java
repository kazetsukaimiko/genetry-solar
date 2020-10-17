package com.genetrysolar.victor.cdi.service;
/*
import io.moquette.broker.Server;
import io.moquette.broker.config.MemoryConfig;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.InterceptAcknowledgedMessage;
import io.moquette.interception.messages.InterceptConnectMessage;
import io.moquette.interception.messages.InterceptConnectionLostMessage;
import io.moquette.interception.messages.InterceptDisconnectMessage;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.moquette.interception.messages.InterceptSubscribeMessage;
import io.moquette.interception.messages.InterceptUnsubscribeMessage;
*/

import javax.enterprise.context.ApplicationScoped;

/**
 * Trying to do this ourselves to avoid configuring the application server.
 * <p>
 * TODO: STUB - this does not yet work
 * TODO: Test with actual WiFi board
 * TODO: Keep track of subscribed clients
 * TODO: MQTT messages get forwarded to JMS topic
 * TODO: MQTT messages get forwarded to wifi.genetrysolar.com
 */
@ApplicationScoped
public class MQTTBrokerService {
    /*
    private final Server server = new Server();
    public void startServer() throws IOException {
        Properties properties = System.getProperties();
        server.startServer(new MemoryConfig(properties));
        server.addInterceptHandler(new InterceptHandler() {
            @Override
            public String getID() {
                return "victor-broker-000001";
            }

            @Override
            public Class<?>[] getInterceptedMessageTypes() {
                return InterceptHandler.ALL_MESSAGE_TYPES;
            }

            @Override
            public void onConnect(InterceptConnectMessage message) {
                System.out.println(message);
            }

            @Override
            public void onDisconnect(InterceptDisconnectMessage message) {
                System.out.println(message);
            }

            @Override
            public void onConnectionLost(InterceptConnectionLostMessage message) {
                System.out.println(message);
            }

            @Override
            public void onPublish(InterceptPublishMessage message) {
                System.out.println(message);
            }

            @Override
            public void onSubscribe(InterceptSubscribeMessage message) {
                System.out.println(message);
            }

            @Override
            public void onUnsubscribe(InterceptUnsubscribeMessage message) {
                System.out.println(message);
            }

            @Override
            public void onMessageAcknowledged(InterceptAcknowledgedMessage message) {
                System.out.println(message);
            }
        });
    }

     */
}
