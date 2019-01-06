package LockInterface;

public class ThreadDemo extends Thread {

    PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo printDemo) {
        super(name);
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts printing a document.");
        printDemo.print();
    }
}
