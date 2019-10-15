package cn.netbuffer.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * 自定义视图路径
 */
@Configuration
public class CustomTemplateResolver {

    @Bean
    public ITemplateResolver fileTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        //在jar应用同级目录下查找视图文件
        resolver.setPrefix("file:");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
//        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return resolver;
    }
}