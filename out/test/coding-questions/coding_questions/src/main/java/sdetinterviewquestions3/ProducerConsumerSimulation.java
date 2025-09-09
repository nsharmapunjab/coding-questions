package sdetinterviewquestions3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSimulation {

    private static final int QUEUE_CAPACITY = 5;

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

        Thread producer = new Thread(new Producer(queue), "ProducerThread");
        Thread consumer = new Thread(new Consumer(queue), "ConsumerThread");

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;
        private int taskNumber = 1;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500); // Simulate workload
                    System.out.println(Thread.currentThread().getName() + " producing: " + taskNumber);
                    queue.put(taskNumber++);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Integer item = queue.take(); // Blocks if queue is empty
                    System.out.println(Thread.currentThread().getName() + " consuming: " + item);
                    Thread.sleep(1000); // Simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
