package config.proxybeanmethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 测试 @Configuration 配置的 proxyBeanMethods不同取值时configMyBean01方法执行的次数
 *
 * @author lpf
 * @date 2020/12/22 18:44
 */
@Configuration(proxyBeanMethods = true)
//@Configuration(proxyBeanMethods = false)
public class ProxyBeanMethodsConfig {
    @Bean
    public MyBean02 configMyBean02(){
        MyBean02 myBean02 = new MyBean02(configMyBean01());
        System.out.println("在配置类中，myBean02对象的地址是：" +   myBean02.toString());
        System.out.println("myBean02中获取得到的myBean01的内存地址是：" + myBean02.getMyBean01().toString());
        MyBean02 myBean022 = new MyBean02(configMyBean01());
        System.out.println("myBean022中获取得到的myBean01的内存地址是：" + myBean022.getMyBean01().toString());
        System.out.println("在配置类中，myBean022对象的地址是：" +   myBean022.toString());
        return myBean02;
    }
    @Bean("myBean01")
    public MyBean01 configMyBean01(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        MyBean01 myBean01 = new MyBean01();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在自动配置类中，调用从figMyBean01方法创建MyBean01对象");
        System.out.println("配置类中myBean01的地址是：" +  myBean01.toString() + ",当前的时间是：" + df.format(new Date()));
        return myBean01;
    }
}
