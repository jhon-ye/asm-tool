package sample;

import java.util.Date;

public class HelloWorld implements Cloneable {

    static {
        System.out.println("class initialization");
    }

    public void test() {
        GoodChild child = new GoodChild("lucy", 8);
    }

    public void test(int a, int b) {
        int val = Math.max(a, b);
        System.out.println(val);
    }

    public void printDate() {
        Date now  = new Date();
        System.out.println(now);
    }
}



