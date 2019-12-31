# springboot源码阅读系列(一) 通过SpringApplication类了解springboot的启动过程

SpringApplication 类是一个单独的类，它没有实现任何的接口也没有继承任何的父类。且它的构造函数只有一个
	public SpringApplication(ResourceLoader resourceLoader, Class<?> ... primarySource){}
	在这个构造函数中，



在springboot项目的启动类中，有一个SpringApplication.run() 方法，该方法返回一个 ConfigurableApplicationContext接口类型的对象(ConfigurableApplicationContext 接口在spring源码中定义).

SpringApplication.run() 方法最后会定位到 SpringApplication类的294行的 public ConfigurableApplicationContext run(String... args) 方法中。 














其他的java编码技巧：
数组转换为为set： 先通过Arrays.asList<Object[]> 将数组转换为list，之后，通过 new LinkedHashSet<> 可以将list转换为set。 



需要深入了解的内容：
1. StopWatch 类是干什么的？ 
	stopWatch.start() .... stopWatch.stop();
2. SpringBootExceptionReporter 接口被@FunctionalInterface 注解修饰，有什么左右。 
