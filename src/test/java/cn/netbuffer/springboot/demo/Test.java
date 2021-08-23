package cn.netbuffer.springboot.demo;

import cn.netbuffer.springboot.demo.util.RandomUtil;

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
}
