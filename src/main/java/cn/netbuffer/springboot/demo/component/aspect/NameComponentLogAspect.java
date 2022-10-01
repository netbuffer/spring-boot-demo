package cn.netbuffer.springboot.demo.component.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class NameComponentLogAspect {

    @Pointcut("execution (* cn.netbuffer.springboot.demo.component.INameComponent.name(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
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
        String declaringTypeName = signature.getDeclaringTypeName();
        Class target = signature.getDeclaringType();
        String annotations = Arrays.stream(target.getAnnotations()).map(a -> a.annotationType().getSimpleName()).collect(Collectors.joining(","));
        log.debug("declaringTypeName={} target={} annotations={}", declaringTypeName, target, annotations);
        log.debug("invoke[{}] with args[{}] return [{}] cost\n{}", signature, point.getArgs(), result, stopWatch.prettyPrint());
        return result;
    }

}