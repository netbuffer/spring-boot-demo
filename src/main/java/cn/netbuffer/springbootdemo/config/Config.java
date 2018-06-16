package cn.netbuffer.springbootdemo.config;

import cn.netbuffer.printserveraddress.listener.SpringBootAppStartedListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SpringBootAppStartedListener build() {
        return new SpringBootAppStartedListener();
    }
}
