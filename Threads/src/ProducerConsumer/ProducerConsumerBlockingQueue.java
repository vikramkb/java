package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer1 implements Runnable{
    BlockingQueue<Integer> Q;
    public Producer1(BlockingQueue<Integer> Q) {
        this.Q = Q;
    }

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }

    public void produce() {
        int value = new Random().nextInt();
        try {
            Thread.sleep(200);
            System.out.println("producing : " + value);
            Q.put(value);
        } catch (Exception e) {
        }
    }
}

class Consumer1 implements Runnable{
    BlockingQueue<Integer> Q;
    public Consumer1(BlockingQueue<Integer> Q) {
        this.Q = Q;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    public void consume() {
        try {
            Thread.sleep(1000);
            int value = Q.take();
            System.out.println("consuming : " + value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        new Thread(new Consumer1(queue)).start();
        new Thread(new Producer1(queue)).start();
    }
}
