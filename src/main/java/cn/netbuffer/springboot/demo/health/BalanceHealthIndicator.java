package cn.netbuffer.springboot.demo.health;

import cn.netbuffer.springboot.demo.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BalanceHealthIndicator implements HealthIndicator {

    private static final String BALANCE = "balance";

    @Override
    public Health health() {
        boolean bool = RandomUtil.bool();
        log.debug("运行余额健康检查:{}", bool);
        if (bool) {
            return Health.up().withDetail(BALANCE, 10000).build();
        }
        return Health.down().withDetail(BALANCE, -1).build();
    }

}