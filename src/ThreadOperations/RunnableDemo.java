package ThreadOperations;

import static java.lang.System.out;

public class RunnableDemo implements Runnable {

    public Thread t;
    private String threadName;
    boolean suspended = false;

    RunnableDemo(String name) {
        this.threadName = name;
        out.println("Creating ");
    }

    @Override
    public void run() {
        out.println("Running " + this.threadName);

        try {
            for (int i = 10; i > 0; i--) {
                out.println("Thread: " + this.threadName + ", " + i);
                Thread.sleep(300);

                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            out.println("Thread " + this.threadName + " interrupted");
        }
        out.println("Thread " + this.threadName + "exiting");
    }

    public void start() {
        out.println("Starting " + this.threadName);
        if (t == null) {
            t = new Thread(this, this.threadName);
            t.start();
        }
    }

    void suspend() {
        this.suspended = true;
    }

    synchronized void resume() {
        this.suspended = false;
        notify();
    }

}
