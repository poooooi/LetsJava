package Thread;

/**
 * @program: LetsJava
 * @description: 创建线程 之 创建多线程
 * @author: poooooi
 * @create: 2021-03-24 13:59
 **/

class newChildThread implements Runnable{
    private String name ;
    newChildThread(String threadName){
        this.name = threadName;
        Thread t = new Thread(this,name);
        System.out.println("Start a new Thread:" + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(this.name + ":" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(this.name+" Interrupted.");
        }
        System.out.println("Child Thread "+ this.name +" Exiting.");
    }
}
public class MultiThreadDemo {
    public static void main(String[] args) {
        try {
            new newChildThread("thread1");
            new newChildThread("thread2");
            new newChildThread("thread3");

            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread:"+i);
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted.");
        }

        System.out.println("Main Thread exiting.");
    }
}
