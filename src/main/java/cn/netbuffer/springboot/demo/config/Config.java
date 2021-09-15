package cn.netbuffer.springboot.demo.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    /**
     * access /actuator/httptrace
     * @return
     */
    @Bean
    public HttpTraceRepository buildHttpTraceRepository(){
        return new InMemoryHttpTraceRepository();
    }

    /**
     * /bean/map?mt=xml
     * /bean/map?mt=json
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorParameter(true)
                .parameterName("mt")
                .favorPathExtension(true)
//                根据Accept请求头来响应对应的数据格式
//                .ignoreAcceptHeader(true)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }

}