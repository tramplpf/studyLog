package com.example.demo.base.controller.user;

import com.example.demo.base.biz.RedisBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 用户管理相关的控制器
 */
@RestController
public class RedisController  {


    private RedisBiz redisBiz;

    /**
     * 根据用户序号查询用户信息
     *
     * http://127.0.0.1:8081/redisdemo/redis/getUserById?userId=1
     * @param userId
     */
    @GetMapping("/redis/getUserById")
    public String getUserById(Long userId){
        System.out.println("根据用户序号查询用户信息，userId = " + userId);
        return Objects.toString(userId,"参数为空");
    }

    /**
     * 根据key从Redis中查询字符串
     *
     * http://127.0.0.1:8081/redisdemo/redis/queryMsgFromRedis?key=abc
     * @author
     * @date 2022/10/17 22:16
     * @version 1.0
     */
    @GetMapping("/redis/queryMsgFromRedis")
    public String queryMsgFromRedis(String key){
        return redisBiz.queryMsgFromRedis(key);
    }

    /**
     * 向Reids中写入数据（写入string类型的数据）
     *
     * http://127.0.0.1:8081/redisdemo/redis/saveMsg2Redis?key=abc&value=msgmsg
     * 对于的curl命令如下：
     *      curl 'http://127.0.0.1:8081/redisdemo/redis/saveMsg2Redis?key=abc&value=abcd' -X POST
     * @param key
     * @param value
     * @author
     * @date 2022/10/17 22:18
     * @version 1.0
     */
    @PostMapping("/redis/saveMsg2Redis")
    public String saveMsg2Redis(String key, String value){
        try{
            redisBiz.saveMsg2Redis(key,value);
        }catch (Exception e){
            return "写入异常";
        }
        return "写入成功";
    }



    @Autowired
    public void setRedisBiz(RedisBiz redisBiz) {
        this.redisBiz = redisBiz;
    }
}
