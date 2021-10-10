# spring-boot-demo
![](https://img.shields.io/static/v1?label=java&message=1.8&color=blue)
![](https://img.shields.io/static/v1?label=spring-boot&message=2.4.5.RELEASE&color=blue)
![](https://img.shields.io/static/v1?label=spring-restdocs&message=2.0.4.RELEASE&color=blue)
![](https://img.shields.io/static/v1?label=junit&message=4.13.2&color=black)
* use spring-boot 2.x
* https://shields.io/
* [github source](https://github.com/netbuffer/spring-boot-demo)
* [gitee source](https://gitee.com/netbuffer/spring-boot-demo)
* /actuator/health
* [@ControllerAdvice](https://docs.spring.io/spring-framework/docs/5.3.6/reference/html/web.html#mvc-ann-controller-advice)
* [Exceptions Process](https://docs.spring.io/spring-framework/docs/5.3.6/reference/html/web.html#mvc-ann-exceptionhandler)
* [ResponseEntityExceptionHandler](https://docs.spring.io/spring-framework/docs/5.3.6/javadoc-api/org/springframework/web/servlet/mvc/method/annotation/ResponseEntityExceptionHandler.html)
* [requestmapping](https://docs.spring.io/spring-framework/docs/5.3.6/reference/html/web.html#mvc-ann-requestmapping-registration)

### server.servlet.session.timeout
```html
ns for nanoseconds
us for microseconds
ms for milliseconds
s for seconds
m for minutes
h for hours
d for days
```

### mvn build test
> `mvn -Dmvn-arg=your param -DskipTests clean package -P test`  
-Dparam,-Pyour profile

### maven-help-plugin use
* `mvn help:system` Displays a list of the platform details like system properties and environment variables
* `mvn help:help` Display help information on maven-help-plugin.Call mvn help:help -Ddetail=true -Dgoal=<goal-name> to display parameter details

### branch
* javamelody
* spring-restdocs
* templating-maven-plugin
* thymeleaf
* logback

### articles
* [spring-boot中统一修改http响应体内容的方法](https://www.toutiao.com/i7014375995448820231)
* [spring-boot中异常的处理](https://www.toutiao.com/i7014369292791579148)
* [关于spring-boot中logback日志配置引用spring环境变量的使用方式](https://www.toutiao.com/i7014368145578230304)
* [spring-boot生成打包信息](https://www.toutiao.com/i7013891369404351014)
* [spring-boot生成git版本库信息](https://www.toutiao.com/i7013890854121226789)
* [Spring Boot动态注册/删除http资源路径的方法](https://www.toutiao.com/i7014752212727431694)
* [获取SpringBoot工程运行时的操作系统进程ID方法](https://www.toutiao.com/i7015456367477522977)
* [SpringBoot使用基于json格式的配置方法](https://www.toutiao.com/i7016209186543469069)
* [怎么查看SpringBoot工程中每个过滤器的执行顺序](https://www.toutiao.com/i7016666337527382532)