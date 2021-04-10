package cn.netbuffer.springboot.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootDemo2Application {

    public static void main(String[] args) {
        /**
         * 使用spring.config.name指定配置文件名
         */
        new SpringApplicationBuilder(SpringBootDemo2Application.class).properties("spring.config.name=config").run(args);
    }
}
