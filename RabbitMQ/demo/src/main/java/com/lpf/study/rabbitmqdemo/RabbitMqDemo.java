package com.lpf.study.rabbitmqdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqDemo {


    @Autowired
    private RabbitProducer producer;
    @Value("${methyl.diagnosis.rabbitmq.queue.rcv}")
    private String rcvQueue;

    /**
     *
     * url: http://127.0.0.1:8080/api/v1/rabbitmq/sendMsg
     * @author
     * @date 2022/4/10 11:15
     * @version 1.0
     */
    @RequestMapping("/api/v1/rabbitmq/sendMsg")
    public String sendMsg(){
        System.out.println("start send msg .....");
        long startTime = System.currentTimeMillis();
        System.out.println("rcvQueue = " + rcvQueue);
        for (int i = 0; i < 5; i++) {
            producer.sendMsg("id = " + i + System.currentTimeMillis(),rcvQueue);
            System.out.println("i = " + i);
        }
        String msg = "costTime = " + (System.currentTimeMillis() - startTime);
        return msg;
    }
}
