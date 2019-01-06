package ExtendingThreadClass;

public class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    ThreadDemo(String name){
        this.threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + this.threadName);

        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread " + this.threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + this.threadName + " interrupted");
        }
        System.out.println("Thread " + this.threadName + " exiting");
    }

    public void start() {
        System.out.println("Starting " + this.threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}
