package multithreading.deadlock;

import java.util.Queue;

public class Producer implements Runnable {

    private Queue<Integer> queue;
    private final int MAX_SIZE = 5;
    private int counter = 1;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if(queue.isEmpty()) {
                    System.out.println("Producing data in the producer : "+counter);
                    queue.add(counter++);
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
