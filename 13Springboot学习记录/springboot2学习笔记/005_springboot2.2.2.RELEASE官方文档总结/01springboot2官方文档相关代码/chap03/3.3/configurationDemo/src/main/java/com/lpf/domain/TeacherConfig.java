package com.lpf.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TeacherConfig {

    /**
     *
     *
     * @author lpf
     * @date 2020/12/20 19:30
     */
    @Bean(name="teahA")
    public Teacher configTeacher(){
        System.out.println("这是一个配置类，实例化并装配teacher用户");
        Teacher teacher = new Teacher();
        teacher.setName("teacherA");
        teacher.setAge(30);
        return teacher;
    }

}
