package Thread;

/**
 * @program: LetsJava
 * @description: 实现多线程中的join方法和isAlive方法
 * @author: poooooi
 * @create: 2021-03-24 14:32
 **/
class JoinChildThread implements Runnable{
    private String name;
    Thread t;

    JoinChildThread(String threadName){
        name = threadName;
        t = new Thread(this,threadName);
        System.out.println("New ChildThread:" + t);
        t.start();
    }

    public void run() {
        try {
            for(int i=5;i>0;i--){
                System.out.println(this.name + ":" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Child Thread " + this.name + "Interrupted.");
        }

        System.out.println("Child Thread " + this.name + " Exiting..");
    }
}

public class JoinThreadDemo {
    public static void main(String[] args) {
        try {
            JoinChildThread jct1 = new JoinChildThread("thread01");
            JoinChildThread jct2 = new JoinChildThread("thread02");
            JoinChildThread jct3 = new JoinChildThread("thread03");

            System.out.println("Child thread01 is alive:" + jct1.t.isAlive());
            System.out.println("Child thread02 is alive:" + jct2.t.isAlive());
            System.out.println("Child thread03 is alive:" + jct3.t.isAlive());
            System.out.println("==================主程序循环开始==================");
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread:" + i);
            }
            System.out.println("==================主程序循环结束==================");

            jct1.t.join();
            jct2.t.join();
            jct3.t.join();

            System.out.println("Child thread01 is alive:" + jct1.t.isAlive());
            System.out.println("Child thread02 is alive:" + jct2.t.isAlive());
            System.out.println("Child thread03 is alive:" + jct3.t.isAlive());

        }catch (InterruptedException e){
            System.out.println("Main Thread interrupted.");
        }
    }
}
