import com.lpf.domain.Employee;
import com.lpf.domain.Hello;
import com.lpf.domain.Student;
import com.lpf.domain.Teacher;
import config.proxybeanmethod.MyBean01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration(proxyBeanMethods = false)
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration(excludeName = {"org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration"})
//@ComponentScan(basePackages = "config")
//@ComponentScan(value = "config")
@ComponentScan("config")
public class ExampleApplication {

	/**
	 * springBoot 项目的启动类
	 *
	 * @author lpf
	 * @date 2020/12/20 15:11
	 */
	public static void main(String[] args){
		ConfigurableApplicationContext context = SpringApplication.run(ExampleApplication.class, args);
		int beanDefinitionCount = context.getBeanDefinitionCount();
		System.out.println("spring容器中bean的个数是：" + beanDefinitionCount);
		for(int i =0; i < 5; i++){
			MyBean01 myBean01 = (MyBean01)context.getBean("myBean01");
			System.out.println("从spring的容器中获取得到的myBean01实例的地址是：" + myBean01.toString());
		}
		/*Hello helloMsg = (Hello)context.getBean("helloMsg");
		if(helloMsg == null){
			System.out.println("通过@Configuration注解没有配置好Hello类");
		}else{
			System.out.println("helloMsg的地址是：" + helloMsg.toString() + ", 提示信息：" +   helloMsg.getMsg());
		}*/

		Hello hello =  (Hello)context.getBean("hello");
		if(hello == null){
			System.out.println("从spring的容器中没有获取到hello实例");
		}else{
			System.out.println("从spring容器中获取得到的hello实例的地址是：" + hello.toString());
		}
		Employee employee = (Employee)context.getBean("employee");
		if(employee == null){
			System.out.println("从容器中获取Employee实例失败");
		}else{
			System.out.println("从spring容器中获取Employee实例，name = " + employee.getName());
		}
		Student stu =  (Student) context.getBean("stu");
		if(stu == null){
			System.out.println("从容器中获取student实例失败");
		}else{
			System.out.println("从spring容器中获取student实例，实例中name=" + stu.getUserName());
		}

		Teacher taacher = (Teacher) context.getBean("teahA");
		if(taacher == null){
			System.out.println("从容器中获取Teacher实例失败");
		}else{
			System.out.println("从spring容器内获取Teacher实例，name = " +  taacher.getName());
		}


	}

	@RequestMapping("/")
	String home(){
		System.out.println("Hello world!");
		return "Hello World!";
	}

}
