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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        InterruptDemo demo = new InterruptDemo();
        T1 t1 = demo.new T1();
        t1.start();
        int i = 0;
        do {
            i++;
        } while (i != 100000);
        t1.interrupt();
    }
}
