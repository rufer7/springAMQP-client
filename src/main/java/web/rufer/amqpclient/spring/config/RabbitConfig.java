/*
 * Copyright (C) 2015 Marc Rufer (m.rufer@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package web.rufer.amqpclient.spring.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.rufer.amqpclient.listener.MessageHandler;

@Configuration
public class RabbitConfig {

    @Value("${amqp.queue.name}")
    private String queueName;

    @Value("${amqp.user}")
    String amqpUser;

    @Value("${amqp.password}")
    String amqpPassword;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername(amqpUser);
        connectionFactory.setPassword(amqpPassword);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        //The routing key is set to the name of the queue by the broker for the default exchange.
        rabbitTemplate.setRoutingKey(this.queueName);
        return rabbitTemplate;
    }

    @Bean
    // Every queue is bound to the default direct exchange
    public Queue myQueue() {
        return new Queue(this.queueName);
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(this.queueName);
        container.setMessageListener(createMessageListenerAdapter());
        return container;
    }

    public MessageListener createMessageListenerAdapter() {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new MessageHandler());
        messageListenerAdapter.setDefaultListenerMethod("sendMessageBySms");
        return messageListenerAdapter;
    }
}
