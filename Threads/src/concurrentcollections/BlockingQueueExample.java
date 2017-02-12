package concurrentcollections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class RopeWayBridge {
    //only 5 people can walk on this bridge at any point of time
    private BlockingQueue<String> bridge = new ArrayBlockingQueue<String>(5);

    public void allow(String person) throws InterruptedException {
        System.out.println("Entry Controller : "+ Thread.currentThread().getId() + " allowing " + person);
        bridge.put(person);
    }

    public void wishOnLeave() throws InterruptedException {
        String person = bridge.take();
        System.out.println("Exit Controller : "+ Thread.currentThread().getId() + " wishing " + person);
    }
}
class EntryBridgeController implements Runnable{

    private RopeWayBridge ropeWayBridge;
    private Queue<String> visitorQueue;

    public EntryBridgeController(RopeWayBridge ropeWayBridge, Queue<String> visitorQueue) {
        this.ropeWayBridge = ropeWayBridge;
        this.visitorQueue = visitorQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String visitor = visitorQueue.poll();
                if(visitor != null)
                    ropeWayBridge.allow(visitorQueue.poll());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExitBridgeController implements Runnable{

    private RopeWayBridge ropeWayBridge;

    public ExitBridgeController(RopeWayBridge ropeWayBridge) {
        this.ropeWayBridge = ropeWayBridge;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                ropeWayBridge.wishOnLeave();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        System.out.println("Visitor visiting the rope way bridge. Entry and Exit controllers managing the queue of visitors.");
        RopeWayBridge bridge = new RopeWayBridge();
        Queue<String> visitors = new LinkedList<>();
        for(int i=0; i<20; i++)
            visitors.add("Visitor " + (i+1));
        EntryBridgeController  entryController1 = new EntryBridgeController(bridge, visitors);

        ExitBridgeController exitBridgeController1 = new ExitBridgeController(bridge);
        ExitBridgeController exitBridgeController2 = new ExitBridgeController(bridge);

        new Thread(entryController1).start();
        new Thread(exitBridgeController1).start();
        new Thread(exitBridgeController2).start();
    }
}
