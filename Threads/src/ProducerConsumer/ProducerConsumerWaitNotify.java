package ProducerConsumer;

import java.util.*;

class Producer implements Runnable{
    MessageQueue Q;
    public Producer(MessageQueue Q) {
        this.Q = Q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Q) {
                if(Q.isFull()) {
                    try {
                        System.out.println("producer is waiting");
                        Q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                produce();
            }
        }
    }

    public void produce() {
        int value = new Random().nextInt();
        try {
            Thread.sleep(1000);
            System.out.println("producing value " + value);
            Q.add(value);
            Q.notifyAll();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    MessageQueue Q;
    public Consumer(MessageQueue Q) {
        this.Q = Q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Q) {
                if(Q.isEmpty()) {
                    try {
                        System.out.println("consumer is waiting");
                        Q.wait();
                    } catch (InterruptedException e) {
                    }
                }
                consume();
            }
        }
    }

    public void consume() {
        try {
            Thread.sleep(1000);
            int value = Q.peek();
            Q.remove();
            System.out.println("consuming " + value);
            Q.notifyAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MessageQueue {
    private Queue<Integer> messages = new LinkedList<Integer>();
    private int numElements = 0;

    public void remove() throws Exception {
        if(numElements == 0) {
            throw new Exception("Queue is empty");
        }
        messages.remove();
        numElements--;
    }

    public Integer peek() {
        return messages.peek();
    }

    public void add(Integer value) throws Exception {
        if(numElements >= 10) {
            throw new Exception("Queue is full");
        }
        messages.add(value);
        numElements++;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return numElements >= 10;
    }


}
public class ProducerConsumerWaitNotify {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
    }
}
