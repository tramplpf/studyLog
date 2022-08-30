package com.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
public class UserController {

    /**
     * 根据用户序号查询用户信息
     *
     * http://127.0.0.1:8081/api/v1/user/queryUserInfoById
     * http://192.168.0.130:8081/api/v1/user/queryUserInfoById
     * @return
     */
    @GetMapping("api/v1/user/queryUserInfoById")
    AuUser queryUserInfoById(Long id){
        AuUser user = new AuUser();
        user.setId(id);
        user.setUserName("lipf");
        user.setAge(12);
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        user.setCurrTime(now.toString());
        if(localHost != null){
            user.setIp(localHost.getHostAddress());
            user.setHostName(localHost.getHostName());
            System.out.println(now + " id = " + id + "--IP = " +localHost.getHostAddress() + "--" +localHost.getHostName());
            System.out.println();
        }else{
            System.out.println(now + " id = " + id + "--获取主机信息失败");
        }
        return user;
    }
}
