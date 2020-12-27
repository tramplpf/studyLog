package config.stu;

import com.lpf.domain.Student;
import com.lpf.domain.TeacherConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 这是一个配置类，用于生成一个Student 对应的Bean，
 * 并且这个bean 会保存到spring 的容器中
 *
 * @author lpf
 * @date 2020/12/20 15:14
 */

@Import(value = {TeacherConfig.class})
@Configuration
public class StudentConf {

    /**
     * 实例化并装配一个Student 类的Bean
     *
     * @author lpf
     * @date 2020/12/20 15:16
     */
    @Bean(name="stu")
    Student configStudent(){
        System.out.println("这是一个配置类，实例化并装配一个Student 类");
        Student stu = new Student();
        stu.setUserName("lpf");
        stu.setAge(20);
        stu.setSex("M");
        return stu;
    }
}
