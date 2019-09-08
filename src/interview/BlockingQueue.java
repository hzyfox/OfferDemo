package interview;

import java.util.LinkedList;

/**
 * 实现阻塞队列
 */
public class BlockingQueue {
    LinkedList<Integer> queue = new LinkedList<>();
    Object lock = new Object();
    int cap;

    public BlockingQueue(int cap) {
        this.cap = cap;
    }

    public Integer poll() {
        synchronized (lock) {
            while (queue.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait ");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int tmp = queue.poll();
            System.out.println(Thread.currentThread().getName() + " poll " + tmp);
            lock.notifyAll();
            return tmp;
        }
    }

    public boolean offer(int val) {
        synchronized (lock) {
            while (queue.size() == cap) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait ");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean tmp = queue.offer(val);
            System.out.println(Thread.currentThread().getName() + " offer " + val);
            lock.notifyAll();
            return tmp;
        }
    }

    static class Producer extends Thread {
        BlockingQueue blockingQueue;

        public Producer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < 10; i++) {
                    blockingQueue.offer(i);
                }
            }
        }
    }

    static class Consumer extends Thread {
        BlockingQueue blockingQueue;

        public Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                blockingQueue.poll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(5);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(producer);
            thread.setName("producer" + i);
            thread.start();
        }
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(consumer);
            thread.setName("consumer" + i);
            thread.start();
        }

    }
}
