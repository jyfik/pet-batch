package ru.jyfik.demospringbatch.petbatch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitProperties {

    /**
     * Имя пользователя для подключения к RabbitMQ.
     */
    private String username;

    /**
     * Пароль пользователя для подключения к RabbitMQ.
     */
    private String password;

    /**
     * Наименование точки доступа в RabbitMQ.
     */
    private String topic;
}
