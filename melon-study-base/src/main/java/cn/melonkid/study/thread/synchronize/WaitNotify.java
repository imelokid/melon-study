package cn.melonkid.study.thread.synchronize;

/**
 * wait&notify
 * study sychronize about wait and notify
 *
 * @author imelonkid
 * @date 2021/08/31 17:02
 **/
public class WaitNotify {

    private static int MAX_LEVEL = 10;

    private static int MIN_LEVEL = 3;

    private volatile int state;

    private final Object lock = new Object();

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        Producer producer = waitNotify.new Producer();
        Consumer consumer = waitNotify.new Consumer();

        // start producer and consumer
        producer.start();
        consumer.start();

        // main thread wait worker thread
        //        try {
        //            producer.join();
        //            consumer.join();
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        System.out.println("main thread ended...");
    }

    /**
     * produce pros for increase state number
     * when state number reach the max level then
     * stop the thread and wait for consume thread.
     */
    private class Producer extends Thread {

        // constructor
        Producer() {
            super("Producer_t");
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {    // monitor enter
                    if (state >= MAX_LEVEL) {
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            // do something
                            System.out.println("I am interruptted by other thread!");
                        }
                    } else {
                        System.out.println("producing: " + state);
                        state++;

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }


    /**
     * consume pros from bucket and decrease state mumber
     * when the state number reach the min level, the stop
     * thread and wait for produce thread.
     */
    private class Consumer extends Thread {

        Consumer() {
            super("Consumer_t");
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (state <= MIN_LEVEL) {
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            // do something
                            System.out.println("I am interruptted by other thread!");
                        }
                    } else {
                        System.out.println("consuming: " + state);
                        state--;

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
