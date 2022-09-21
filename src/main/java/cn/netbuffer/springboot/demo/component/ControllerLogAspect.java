package cn.netbuffer.springboot.demo.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ControllerLogAspect {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut("execution (* cn.netbuffer.springboot.demo.controller.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        log.debug("around point={}", point);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            log.error("invoke error:", e);
        }
        stopWatch.stop();
        Signature signature = point.getSignature();
        log.debug("invoke[{}] with args[{}] return [{}] cost\n{}", signature, point.getArgs(), result, stopWatch.prettyPrint());
        try {
            log.debug("to json args={} result={}", objectMapper.writeValueAsString(point.getArgs()), objectMapper.writeValueAsString(result));
        } catch (JsonProcessingException e) {
            log.error("process args to json error");
        }
        return result;
    }

}