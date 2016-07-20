package web.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import web.listener.AmqListener;

/**
 * Created by Administrator on 2016/7/20.
 */
@Configuration
public class ActiveMQConfig {

    @Value("${mq.broker.url}")
    private String MQ_BROKER_URL;

    @Value("${mq.queue.story}")
    private String MQ_QUEUE_STORY;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(MQ_BROKER_URL);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
        jmsTemplate.setPubSubDomain(false);
        return jmsTemplate;
    }

    @Bean
    public AmqListener amqListener(){
        AmqListener amqListener = new AmqListener();
        return amqListener;
    }

    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer(){
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(activeMQConnectionFactory());
        defaultMessageListenerContainer.setDestination(new ActiveMQQueue(MQ_QUEUE_STORY));
        defaultMessageListenerContainer.setMessageListener(amqListener());
        return defaultMessageListenerContainer;
    }

}
