package Thread.refer;

/**
 * @program: LetsJava
 * @description: 创建线程 之 继承Thread类
 * @author: poooooi
 * @create: 2021-03-23 19:47
 **/

/**
 * 大多数情况，通过实例化一个Thread对象来创建一个线程。Java定义了两种方式：
 * 1、实现Runnable接口；
 * 2、继承Thread类。
 */
//主线程和子线程输出会有先后顺序的原因：sleep的时间不同

//Create a second thread by extending Thread
class ExtendNewThread extends Thread {
    ExtendNewThread(){
        // Create a new, second thread
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        start(); // Start the thread
    }

    // This is the entry point for the second thread.
    public void run() {
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread:" + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Child interrupted.");
        }

        System.out.println("Exiting child thread.");
    }
}

public class ExtendThreadDemo {
    public static void main(String[] args) {
        new ExtendNewThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread:" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}