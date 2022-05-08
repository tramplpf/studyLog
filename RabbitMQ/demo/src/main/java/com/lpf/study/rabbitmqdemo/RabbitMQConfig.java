package com.lpf.study.rabbitmqdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure RabbitMQ
 *
 * @author
 * @date 2022/4/10 10:45
 * @version 1.0
 */
@Configuration
public class RabbitMQConfig {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Value("${methyl.diagnosis.rabbitmq.queue.rcv}")
    private String sndQueue;

    /**
     *
     * 
     * @author 
     * @date 2022/4/10 10:58
     * @version 1.0
     */
    @Bean
    public Queue rcvQueue() {
        log.info("init queue: sndQueue = [{}]",sndQueue);
        return new Queue(sndQueue,true);
    }
}
