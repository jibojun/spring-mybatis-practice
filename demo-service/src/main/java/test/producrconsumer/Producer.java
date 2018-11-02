package test.producrconsumer;

import java.util.Queue;
import java.util.Random;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 17:33
 * @Description:
 */
public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    System.out.println("queue is full, producer start to wait");
                    try {
                        queue.wait();
                    } catch (Exception e) {

                    }
                }
                Random random = new Random();
                int value = random.nextInt();
                queue.offer(value);
                System.out.println(String.format("produce value: %s, start to wake up", value));
                try {
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notify();
            }
        }
    }
}
