package cn.netbuffer.springboot.demo.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 当有同一个接口多个实现类时，使用@Primary来标识默认的注入类
 */
@Primary
@Component
public class MobileNameComponent implements INameComponent {
    @Override
    public String name() {
        return "手机名称";
    }
}
