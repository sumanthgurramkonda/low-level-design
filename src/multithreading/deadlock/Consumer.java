package multithreading.deadlock;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if(!queue.isEmpty())System.out.println("Consuming Queue value : "+queue.poll());
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
