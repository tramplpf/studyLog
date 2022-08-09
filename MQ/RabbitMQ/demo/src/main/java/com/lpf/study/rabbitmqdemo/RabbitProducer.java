package com.lpf.study.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Producer for message send
 *
 * @author
 * @date 2022/4/9 19:54
 * @version 1.0
 */
@Component
public class RabbitProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * SendMsg to Queue
     *
     * @param msg  message
     * @param queueName
     * @author
     * @date 2022/4/10 09:23
     * @version 1.0
     */
    public void sendMsg(String msg, String queueName){
        try{
            rabbitTemplate.convertAndSend(queueName,msg);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
