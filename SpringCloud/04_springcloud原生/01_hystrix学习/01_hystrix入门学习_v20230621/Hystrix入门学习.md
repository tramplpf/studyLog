# Hystrix学习


# 相关的概念
* 熔断
* 降级



@EnableCircuitBreaker 注解


@HystrixCommand(fallbackMethod="托底方法的方法名")， 添加在实现类的方法上。 
   托低方法的返回值，需要和原来的方法的返回值保持一致。 



降级时出错了返回托底数据，而熔断时出错后如果开启了熔断将会一定时间不在访问 application server 。 

熔断机制相当于电路的跳闸功能。 例如，如果我们可以配置熔断策略为当请求错误比例在10s内 > 50%时，该服务将进入熔断状态，后续请求都会进入fallback。 


## 熔断
  熔断有自动恢复机制。 

熔断的实现时在调用远程服务的方法上，添加 @HystrixCommand注解，当注解配置满足则开启或关闭熔断器。 

  @HystrixProperty 的name属性取值可以使用 HystrixPropertiesManager常量，也可以直接使用字符串进行操作。 


@HystrixCommand注解的 commandProperties 属性 进行熔断属性配置（取值是数组）。 该属性的取值是 @HystrixProperty 注解。 



### 注解属性描述
CIRCUIT_BREAKER_ENABLED （circuitBreaker.enabled）
    是否开启熔断策略, 默认值是 true。 

CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD (circuitBreaker.requestVOlumeThreshold)
    单位时间内（默认10s内），请求超时数超过则触发熔断策略，默认值为20次请求数，通俗说明： 单位时间内要判断多少次请求。 







### 请求合并

  把一段时间范围内的所有请求合并为一个请求。 大大降低了Application Service 负载。 


什么情况下使用请求合并
  在微服务架构中，我们将一个项目拆分成很多个独立项目，这些独立的项目通过远程调用来互相配合工作，但是，在高并发情况下，通信次数的增加会导致总的通信时间增加，同时，线程池的资源池也是有限的，高并发环境会导致有大量的线程处于等待状态，进而导致响应延迟，为了解决这些问题，我们需要来了解Hystrix的请求合并。 


#### 请求合并参数介绍
    请求合并理论学习明白后，代码实现起来还是很容易的。关键就是一个@HystrixCollapser 注解。 
    