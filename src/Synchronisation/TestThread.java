package Synchronisation;

public class TestThread {

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo T1 = new ThreadDemo("Thread - 1", printDemo);
        ThreadDemo T2 = new ThreadDemo("Thread - 2", printDemo);

        T1.start();
        T2.start();

        try {
            T1.join();
            T2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }

}
