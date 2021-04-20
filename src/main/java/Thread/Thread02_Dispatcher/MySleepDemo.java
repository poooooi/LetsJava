package Thread.Thread02_Dispatcher;

/**
 * @program: LetsJava
 * @title: Thread02_线程调度 之 1-线程休眠 （线程调度：线程休眠、线程合并、线程礼让、线程中断）
 * @description: 实现线程休眠(内部和外部两种方式)。期望结果：主线程休眠500ms后再启动子线程，子线程每次循环输出后都休眠100ms。
 * @author: poooooi
 * @create: 2021-04-19 17:29
 **/

//sleep方法源码：public static native void sleep(long millis) throws InterruptedException;
class SleepRunnable implements Runnable {
    @Override
    public void run() { //重写MyRunnable的run()
        for (int i = 0; i < 100; i++) {
            System.out.println("This is MyRunnable");
            try {//内部调用,使线程每次循环输出后都休眠100ms
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MySleepDemo {
    public static void main(String[] args) throws InterruptedException {
        SleepRunnable sleepRunnable = new SleepRunnable();
        Thread sleepThread = new Thread(sleepRunnable);
        Thread.sleep(500);  //在外部调用需要注意，休眠一定要放在启动之前。
        sleepThread.start();
    }
}
