import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class CounterTest {


    @Test
    public void testCounter() throws InterruptedException{
        Counter c = new Counter();
        for(int i = 0; i< 500; i++){
            c.increment();
        }

        assertEquals(500, c.getCount());
    }

    @Test
    public void counterWithConcurrency() throws InterruptedException{

        int numberOfThreads = 2;
        ExecutorService es = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        Counter counter = new Counter();
        for(int i = 0; i<numberOfThreads; i++){
           es.execute(() -> {
               try {
                   counter.increment();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               latch.countDown();
           });
        }
        latch.await();
        assertEquals(numberOfThreads, counter.getCount());
    }

}
