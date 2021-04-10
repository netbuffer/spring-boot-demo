package cn.netbuffer.springboot.demo;

public class Test {

    @org.junit.Test
    public void testMatch(){
        String p="2019/12/16";
        System.out.println(p.matches("^\\d{4}/\\d{1,2}/\\d{1,2}$"));
    }
}
