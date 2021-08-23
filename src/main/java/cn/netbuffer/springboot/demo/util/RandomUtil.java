package cn.netbuffer.springboot.demo.util;

public class RandomUtil {

    public static boolean bool() {
        int v = (int) (Math.random() * 10);
        if (v < 5) {
            return false;
        }
        return true;
    }

}
