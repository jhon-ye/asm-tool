package sample;

public class HelloWorld implements Cloneable {
    private static final int intValue = 10;

    public void test() {
        int a = 1;
        int b = 2;
        int c = a + b;
    }

    public int add() {
        synchronized (this) {
            int a = 1;
            int b = 2;
            return a + b;
        }
    }

    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }
}



