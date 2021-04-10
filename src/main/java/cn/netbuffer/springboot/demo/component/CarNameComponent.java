package cn.netbuffer.springboot.demo.component;

import org.springframework.stereotype.Component;

@Component
public class CarNameComponent implements INameComponent {
    @Override
    public String name() {
        return "汽车名称";
    }
}
