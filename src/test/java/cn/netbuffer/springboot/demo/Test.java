package cn.netbuffer.springboot.demo;

import cn.netbuffer.springboot.demo.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class Test {

    @org.junit.Test
    public void testMatch() {
        String p = "2019/12/16";
        System.out.println(p.matches("^\\d{4}/\\d{1,2}/\\d{1,2}$"));
    }

    @org.junit.Test
    public void testBool() {
        for (int i = 0; i < 30; i++) {
            System.out.println(RandomUtil.bool());
        }
    }

    @org.junit.Test
    public void testHasLength() {
        String str = "  ";
        log.debug("{} hasLength:{}", str, StringUtils.hasLength(str));
    }

    @org.junit.Test
    public void testHasText() {
        String str = "  ";
        StringUtils.hasText(str);
        log.debug("{} hasText:{}", str, StringUtils.hasText(str));
    }

}
