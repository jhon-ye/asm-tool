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

     public void test(int val) {
        switch (val) {
            case 1:
                System.out.println("val = 1");
                break;
            case 2:
                System.out.println("val = 2");
                break;
            case 3:
                System.out.println("val = 3");
                break;
            default:
                System.out.println("value is unknown");
        }
     }
     
     public void test2(int max) {
         for (int i = 0; i < max; i++) {
             System.out.println(i);
         }
     }

     public void test3() {
        try {
            System.out.println("before sleep");
            Thread.sleep(1000);
            System.out.println("after sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }

     public void test4() {
         System.out.println("method enter");
         System.out.println("this is test method");
     }
}



