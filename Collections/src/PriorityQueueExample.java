import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(70, 10, 20, 80, 30, 40, 50, 90, 15, 100, 95, 5, 1, 35, 60);
        minHeap(numbers);
        maxHeap(numbers);
    }

    public static void minHeap(List<Integer> numbers) {
        int capacity = 20;
        System.out.println("---------- min heap --------------------");
        PriorityQueue<Integer> queue = new PriorityQueue<>(capacity);
        queue.addAll(numbers);
        queue.offer(-10); // adds element. introduced in priority queue. returns false or true based on the status
        queue.add(-5); // adds element. coming from Collection. always returns true

        //gets minimum value. Doesn't remove from queue
        System.out.println("peek = " + queue.peek());
        System.out.println("peek = " + queue.peek());

        //gets minimum value. Removes minimum value.
        System.out.println("1st poll = " + queue.poll());
        System.out.println("2nd poll = " + queue.poll());
    }

    public static void maxHeap(List<Integer> numbers) {
        int capacity = 20;
        System.out.println("---------- max heap --------------------");
        PriorityQueue<Integer> queue = new PriorityQueue<>(capacity, Collections.reverseOrder());
        queue.addAll(numbers);
        queue.offer(1010); // adds element. introduced in priority queue. returns false or true based on the status
        queue.add(-5); // adds element. coming from Collection. always returns true


        //gets minimum value. Doesn't remove from queue
        System.out.println("peek = " + queue.peek());
        System.out.println("peek = " + queue.peek());

        //gets minimum value. Removes minimum value.
        System.out.println("1st poll = " + queue.poll());
        System.out.println("2nd poll = " + queue.poll());
    }
}
