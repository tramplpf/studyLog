package com.example.demo.base.controller.index;


import com.example.demo.base.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目的入口控制
 *
 * @author lpf
 * @date 20191219
 * @version 1.0
 *
 */
@Controller
@RequestMapping("index")
public class IndexController extends BaseController {

    /**
     * 跳转到主页面
     *
     */
    @RequestMapping("index")
    public void index(){

    }

}
