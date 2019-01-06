package ThreadLocalVariables;

public class RunnableDemo implements Runnable {

    int normalCounter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();

    @Override
    public void run() {
        this.normalCounter++;

        if (threadLocalCounter.get() != null) {
            threadLocalCounter.set(threadLocalCounter.get() + 1);
        } else {
            threadLocalCounter.set(0);
        }
        System.out.println("Normal counter: " + normalCounter);
        System.out.println("threadLocalCounter: " + threadLocalCounter.get());
    }

}
