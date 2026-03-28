package multithreading.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
//                System.out.println("Consuming data in the consumer.");
                if(!queue.isEmpty())System.out.println("Consuming Queue value : "+queue.poll());
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
