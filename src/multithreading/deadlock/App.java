package multithreading.deadlock;

import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

    }
}
