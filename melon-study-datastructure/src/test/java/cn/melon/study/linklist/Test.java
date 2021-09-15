package cn.melon.study.linklist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * test
 *
 * @author imelonkid
 * @date 2021/09/12 12:23
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        t.test2();
//        LinkedBlockingQueue queue = new LinkedBlockingQueue(1);
//        while(true) {
//            boolean a = queue.add(new Object());
//            System.out.println(a);
//            Thread.sleep(1000);
//        }

    }


    private void test1(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
        while (true) {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("qsize:" + executor.getQueue().size());
        }
    }

    private void test2(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(3));
        while (true) {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("qsize:" + executor.getQueue().size());
        }
    }

}
