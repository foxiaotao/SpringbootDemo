package com.simon.config.mq;

import com.simon.service.IMQService;
import com.simon.service.IQueueService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by xiaotao on 2017/5/16.
 */
@Configuration
public class SmqConfig {
    @Value("${loanorder.rabbitmq.queue}")
    private String queueName;
    @Value("${loanorder.rabbitmq.exchange}")
    private String exchangeName;
    @Value("${loanorder.rabbitmq.connection.host}")
    private String host;
    @Value("${loanorder.rabbitmq.connection.port}")
    private Integer port;
    @Value("${loanorder.rabbitmq.connection.user}")
    private String user;
    @Value("${loanorder.rabbitmq.connection.password}")
    private String password;
    @Value("${loanorder.rabbitmq.connection.virtual-host}")
    private String virtualHost;

    /**
     * mq的获取连接的工厂
     * @return CachingConnectionFactory
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host,port);
        cachingConnectionFactory.setChannelCacheSize(1024);
        cachingConnectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        cachingConnectionFactory.setConnectionCacheSize(1024);
        cachingConnectionFactory.setUsername(user);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        cachingConnectionFactory.setPublisherReturns(false);
        cachingConnectionFactory.setPublisherConfirms(false);
        return cachingConnectionFactory;
    }

    @Bean(name= "sxtAmqpAdmin")
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean(name="sxtExchange")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(exchangeName);
    }

    @Bean(name="sxtQueue")
    public Queue sxtQueue(){
        return new Queue(queueName);
    }

    @Bean(name="sxtBinding")
    public Binding bindingWaitGen(@Qualifier("sxtAmqpAdmin")RabbitAdmin rabbitAdmin,@Qualifier("sxtQueue")Queue queue,@Qualifier("sxtExchange")FanoutExchange exchange){
        Binding binding = BindingBuilder.bind(queue).to(exchange);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

    @Bean(name="sxtRabbitTemplate")
    public RabbitTemplate constractRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(exchangeName);
        return rabbitTemplate;
    }

    @Primary
    @Bean
    public SimpleMessageListenerContainer loanOrderSimpleMessageListenerContainer(@Qualifier("queueService")IQueueService queueService, ConnectionFactory connectionFactory, @Qualifier("sxtQueue")Queue sxtQueue) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        System.out.println(1);
        container.setQueues(sxtQueue);
        container.setAcknowledgeMode(AcknowledgeMode.NONE);
        container.setMessageListener(new MessageListenerAdapter(queueService));
        container.start();
        return container;
    }
}
