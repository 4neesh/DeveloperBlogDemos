import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class CounterTest {

    private static Counter counter = new Counter();

//    @Test
//    public void testCounter() throws InterruptedException{
//        Counter c = new Counter();
//        for(int i = 0; i< 500; i++){
//            c.increment();
//        }
//
//        assertEquals(500, c.getCount());
//    }

//    @Test
//    public void counterWithConcurrency() throws InterruptedException{
//
//        int numberOfThreads = 2;
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        CountDownLatch latch = new CountDownLatch(numberOfThreads);
//
//        Counter counter = new Counter();
//        for(int i = 0; i<numberOfThreads; i++){
//           es.execute(() -> {
//               try {
//                   counter.increment();
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               latch.countDown();
//           });
//        }
//        es.shutdown();
//        latch.await();
//        assertEquals(numberOfThreads, counter.getCount());
//    }

    @Rule
    public ConcurrentRule concurrentRule = new ConcurrentRule();

    @Rule
    public RepeatingRule rule = new RepeatingRule();

    @Test
    @Concurrent(count = 2)
    @Repeating(repetition = 2)
    public void runsMultipleTimes() throws InterruptedException{

        counter.increment();
    }

    @AfterClass
    public static void annotatedTestRunsMultipleTimes() throws InterruptedException {
        assertEquals(counter.getCount(), 2);
    }
}
