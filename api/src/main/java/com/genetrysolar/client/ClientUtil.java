package com.genetrysolar.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

public class ClientUtil {
    private ClientUtil() {
    }

    public static <T> T makeClient(String path, Class<T> klazz) {
        ResteasyClientBuilder builder = (ResteasyClientBuilder) ClientBuilder.newBuilder();
        builder.register(new JacksonJsonProvider());

        ResteasyClient client = builder.build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));
        return target.proxy(klazz);
    }
}
