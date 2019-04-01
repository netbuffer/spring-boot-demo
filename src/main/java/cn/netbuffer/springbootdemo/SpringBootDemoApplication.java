package cn.netbuffer.springbootdemo;

import cn.netbuffer.maven.Maven;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        System.out.println("basedir:"+ Maven.baseDir);
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
