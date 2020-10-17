package com.genetrysolar.victor.jms.mdb;

import javax.annotation.Resource;
import javax.ejb.MessageDrivenContext;
import javax.jms.MessageListener;

public abstract class VictorMessageRecipients implements MessageListener {
    public static final String FACTORY_RESOURCE = "java:comp/DefaultJMSConnectionFactory";
    @Resource
    protected MessageDrivenContext mdc;
}
