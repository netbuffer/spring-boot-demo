# spring-boot-demo
![](https://img.shields.io/badge/springboot-2.4.5.RELEASE-blue.svg?color=blue&message=) ![](https://img.shields.io/badge/springrestdocs-2.0.4.RELEASE-blue.svg?color=blue&message=)
* use spring-boot 2.x
* https://shields.io/
* [github source](https://github.com/netbuffer/spring-boot-demo)
* [gitee source](https://gitee.com/netbuffer/spring-boot-demo)
* /actuator/health

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