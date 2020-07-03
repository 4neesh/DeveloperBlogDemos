import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class MainTest {

    public static Account bankAccount;

    @Test
    public void accountIsNotOverdrawn() throws InterruptedException{

        int numberOfHolders = 2;
        bankAccount = new Account(50);
        Person person = new Person(bankAccount);
        CountDownLatch latch = new CountDownLatch(numberOfHolders);

        ExecutorService es = Executors.newFixedThreadPool(10);

        for(int i = 0; i<numberOfHolders; i++){
            es.execute(person);
            latch.countDown();
        }

        es.shutdown();

        latch.await();
        assertEquals("account becomes overdrawn", true, bankAccount.getBalance() >= 0);

    }

}
