package ru.jyfik.demospringbatch.petbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.jyfik.demospringbatch.petbatch.RabbitProperties;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {

    private final RabbitProperties properties;

    private final static String DEMO_ROUTING_KEY = "stuff";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost", 5672);
        factory.setUsername(properties.getUsername());
        factory.setPassword(properties.getPassword());

        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(this.connectionFactory());
    }

    @Bean
    public DirectRabbitListenerContainerFactory messageListenerContainer(ConnectionFactory connectionFactory) {
        DirectRabbitListenerContainerFactory result = new DirectRabbitListenerContainerFactory();
        result.setConnectionFactory(connectionFactory);

        return result;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(this.connectionFactory());
        template.setExchange(properties.getTopic());
        template.setMessageConverter(new Jackson2JsonMessageConverter());

        return template;
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(properties.getTopic());
    }

    @Bean
    public Queue batchQueue() {
        return QueueBuilder.durable("employee-queue-demo-batch").build();
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEMO_ROUTING_KEY);
    }
}
