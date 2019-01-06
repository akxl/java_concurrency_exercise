package ThreadLocalRandom;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestThread {

    public static void main(final String[] args) {
        System.out.println("Random Integer: " + new Random().nextInt());
        System.out.println("Seeded Random Integer: " + new Random(15).nextInt());
        System.out.println("Thread Local Random Integer: " + ThreadLocalRandom.current().nextInt());

        final ThreadLocalRandom random = ThreadLocalRandom.current();
        random.setSeed(15); // exception will be thrown as seeding is not allowed
        System.out.println("Seeded Thread Local Random Integer: " + random.nextInt());
    }

}
