package config;

import com.lpf.domain.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {


    /**
     * 装配一个Employee 类
     *
     * @author lpf
     * @date 2020/12/20 19:48
     */
    @Bean("employee")
    public Employee configEmployee(){
        Employee employee = new Employee();
        employee.setName("张三");
        employee.setComponey("BAT");
        return employee;
    }
}
