package LockInterface;

public class TestThread {

    public static void main(final String[] args) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo t1 = new ThreadDemo("Thread - 1", printDemo);
        ThreadDemo t2 = new ThreadDemo("Thread - 2", printDemo);
        ThreadDemo t3 = new ThreadDemo("Thread - 3", printDemo);
        ThreadDemo t4 = new ThreadDemo("Thread - 4", printDemo);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
