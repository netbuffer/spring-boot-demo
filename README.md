# spring-boot-demo
![](https://img.shields.io/static/v1?label=java&message=1.8&color=blue)
![](https://img.shields.io/static/v1?label=spring-boot&message=2.4.5.RELEASE&color=blue)
![](https://img.shields.io/static/v1?label=spring-restdocs&message=2.0.4.RELEASE&color=blue)
![](https://img.shields.io/static/v1?label=junit&message=4.13.2&color=black)
![](https://img.shields.io/static/v1?label=hibernate-validator&message=6.1.7.Final&color=blue)
* use spring-boot 2.x
* https://shields.io/
* [github source](https://github.com/netbuffer/spring-boot-demo)
* [gitee source](https://gitee.com/netbuffer/spring-boot-demo)
* /actuator/health
* [@ControllerAdvice](https://docs.spring.io/spring-framework/docs/5.3.6/reference/html/web.html#mvc-ann-controller-advice)
* [Exceptions Process](https://docs.spring.io/spring-framework/docs/5.3.6/reference/html/web.html#mvc-ann-exceptionhandler)
* [ResponseEntityExceptionHandler](https://docs.spring.io/spring-framework/docs/5.3.6/javadoc-api/org/springframework/web/servlet/mvc/method/annotation/ResponseEntityExceptionHandler.html)
* [requestmapping](https://docs.spring.io/spring-framework/docs/5.3.6/reference/html/web.html#mvc-ann-requestmapping-registration)
* [hibernate_validator_reference](https://docs.jboss.org/hibernate/validator/6.2/reference/en-US/pdf/hibernate_validator_reference.pdf#validator-gettingstarted)
* https://docs.docker.com/compose/compose-file/compose-file-v3/#build


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

### docker镜像制作

#### 构建
1. 先通过maven打包到target目录下
2. 执行构建指令：docker build -t netbuffer/spring-boot-demo:1.0 .

#### 运行
* docker run --rm -it -p 9100:9100 netbuffer/spring-boot-demo:1.0
* docker-compose up (使用docker-compose启动服务)

#### 发布到DockerHub
> 需要注册DockerHub身份，再docker login登录对应的Registry
1. docker images 找到镜像ID
2. docker tag 镜像ID 你的DockerHub账户名/spring-boot-demo:1.0 打tag
3. docker push 你的DockerHub账户名/spring-boot-demo:1.0 推送到远程

#### 远程镜像
> 已发布到DockerHub，可以直接运行以下指令测试  
https://hub.docker.com/r/javawiki/spring-boot-demo  

* docker pull javawiki/spring-boot-demo:1.0          拉取远程镜像
* docker run -it --rm javawiki/spring-boot-demo:1.0  运行远程镜像

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
* [Spring中出现NoUniqueBeanDefinitionException的解决方法](https://www.toutiao.com/i7018897444583113247)