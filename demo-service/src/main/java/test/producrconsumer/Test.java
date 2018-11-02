package test.producrconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 17:47
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue, 5);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
