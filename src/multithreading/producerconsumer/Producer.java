package multithreading.producerconsumer;

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
            synchronized (queue) {
                if(queue.isEmpty()) {
                    System.out.println("Producing data in the producer : "+counter);
                    queue.add(counter++);
                }
                try {
                    Thread.sleep(10);
//                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    queue.notifyAll();
                }
            }
        }
    }
}
