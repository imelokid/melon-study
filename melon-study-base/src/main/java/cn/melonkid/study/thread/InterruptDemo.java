package cn.melonkid.study.thread;

/**
 * 线程中断学习
 *
 * @author imelonkid
 * @date 2021/08/27 11:36
 **/
public class InterruptDemo {


    class T1 extends Thread{

        @Override
        public void run() {
            while (true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("T1 has been Interrupted!");
                    break;
                }
                System.out.println("I am running...");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptDemo demo = new InterruptDemo();
        T1 t1 = demo.new T1();
        t1.start();
        t1.interrupt();
    }
}
