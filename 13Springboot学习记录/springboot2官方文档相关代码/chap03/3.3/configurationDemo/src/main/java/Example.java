import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Example {

	@RequestMapping("/")
	String home(){
		System.out.println("Hello world!");
		return "Hello World!";

	}

	public static void main(String[] args){
		SpringApplication.run(Example.class, args);
	}

}
