package InterthreadCommunication;

public class TestThread {

    public static void main(String[] args) {
        Chat m = new Chat();
        new Thread1(m);
        new Thread2(m);
    }
}
