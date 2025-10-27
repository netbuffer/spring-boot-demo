package cn.netbuffer.springboot.demo.config;

import cn.netbuffer.springboot.demo.decorator.HttpTaskDecorator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${extra-static.file-path1}")
    private String filePath1;

    @Value("${extra-static.file-path2}")
    private String filePath2;

    @Bean(name = AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
    public AsyncTaskExecutor buildAsyncTaskExecutor() {
        log.info("buildAsyncTaskExecutor");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("sbd-async-exec-");
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setTaskDecorator(new HttpTaskDecorator());
        return threadPoolTaskExecutor;
    }

    /**
     * access /actuator/httptrace
     *
     * @return
     */
    @Bean
    public HttpTraceRepository buildHttpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }

    /**
     * /bean/map?mt=xml
     * /bean/map?mt=json
     *
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("bind static path /uploads1/** to file path:{}", filePath1);
        log.info("bind static path /uploads2/** to file path:{}", filePath2);
        String filePrefix = "file:";
        registry.addResourceHandler("/uploads1/**").addResourceLocations(filePrefix + filePath1);
        registry.addResourceHandler("/uploads2/**").addResourceLocations(filePrefix + filePath2);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
    }

}
