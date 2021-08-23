package cn.netbuffer.springboot.demo.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Endpoint(id = "app")
public class AppEndpoint {

    @ReadOperation
    public String info() {
        log.debug("custom endpoint");
        return "custom app endpoint";
    }
}
