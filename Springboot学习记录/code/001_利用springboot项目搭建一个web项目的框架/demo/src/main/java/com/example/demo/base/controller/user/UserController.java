package com.example.demo.base.controller.user;

import com.example.demo.base.base.BaseController;
import org.springframework.stereotype.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理相关的控制器
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    /**
     * 根据用户序号查询用户信息
     * http://127.0.0.1:8080/user/getUserById?userId=1
     * @param userId
     */
    @RequestMapping("getUserById")
    public String getUserById(Long userId){
        System.out.println("根据用户序号查询用户信息，userId = " + userId);
        return userId + "";
    }
}
