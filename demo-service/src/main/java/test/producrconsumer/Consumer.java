package test.producrconsumer;

import java.util.Queue;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 17:34
 * @Description:
 */
public class Consumer implements Runnable {
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("queue is empty, consumer start to wait");
                    try {
                        queue.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println(String.format("consume value: %s, start to wake up", queue.poll()));
                try {
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }
    }
}
