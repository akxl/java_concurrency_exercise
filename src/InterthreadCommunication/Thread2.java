package InterthreadCommunication;

public class Thread2 implements Runnable {

    Chat m;
    String[] s1 = {"Hi", "I am good, what about you?", "Great!"};

    public Thread2(Chat m1) {
        m = m1;
        new Thread(this, "Answer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s1.length; i++) {
            m.answer(s1[i]);
        }
    }
}