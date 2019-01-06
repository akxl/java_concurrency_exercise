package ThreadOperations;

public class TestThread {

    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();

        try {
            Thread.sleep(1000);
            R1.suspend();
            System.out.println("Suspending First thread");
            Thread.sleep(1000);
            R1.resume();
            System.out.println("Resuming First thread");

            R2.suspend();
            System.out.println("Suspending Second thread");
            Thread.sleep(1000);
            R2.resume();
            System.out.println("Resuming Second thread");

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        } try {
            System.out.println("Waiting for threads to finish");
            R1.t.join();
            R2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }

}
