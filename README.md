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
* spring-security-test
* templating-maven-plugin
* thymeleaf
* logback