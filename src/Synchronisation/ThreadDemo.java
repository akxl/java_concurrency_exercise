package Synchronisation;


public class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;
    PrintDemo printDemo;

    ThreadDemo(String threadName, PrintDemo printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        synchronized (this.printDemo) {
            this.printDemo.printCount();
        }
        System.out.println("Thread " + this.threadName + " exiting");
    }

    public void start() {
        System.out.println("Starting " + this.threadName);

        if (t == null) {
            t = new Thread(this, this.threadName);
            t.start();
        }
    }

}
