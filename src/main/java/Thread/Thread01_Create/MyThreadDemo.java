package Thread.Thread01_Create;

/**
 * @program: LetsJava
 * @title: Thread01_创建线程 之 1-继承Thread类
 * @description: 重写MyThread1和MyThread2的run()方法，并启动两个子线程
 * @author: poooooi
 * @create: 2021-04-19 15:29
 **/

class MyThread1 extends Thread {
    @Override
    public void run() { //重写子线程MyThread1的run()
        for (int i = 0; i < 100; i++) {
            System.out.println("-------------MyThread1");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() { //重写子线程MyThread2的run()
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread2+++++++++++");
        }
    }
}

public class MyThreadDemo {
    public static void main(String[] args) {
        // 实例化子线程MyThread1和MyThread2的对象
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        //启动线程
        thread1.start();
        thread2.start();
    }
}
