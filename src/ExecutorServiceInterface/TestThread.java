package ExecutorServiceInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThread {

    public static void main(final String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.submit(new Task());
            System.out.println("Shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS); // forcefully shutdown after 5 seconds
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Long duration = (long) (Math.random() * 20);
                System.out.println("Running task!");
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
