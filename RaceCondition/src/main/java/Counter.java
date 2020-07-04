import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private volatile AtomicInteger count = new AtomicInteger(0);

    public synchronized void increment() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " wait");
        wait(100);
        System.out.println(Thread.currentThread().getName() + " done");

        count.getAndIncrement();
        System.out.println("Count: " + count);
    }

    public int getCount(){
        return this.count.get();
    }

}
