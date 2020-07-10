import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private static BankAccount bankAccount;
    @Before
    public void setUp() {
        bankAccount = new BankAccount();

    }

    @Test
    public void bankAccountWithdraws() throws InterruptedException{

        for(int i = 0; i< 5; i++){
            bankAccount.withdraw(10);
        }

        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void multipleThreadWithdrawsFromBankAccount() throws InterruptedException{

        int numberOfThreads = 6;
        ExecutorService es = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for(int i = 0; i<numberOfThreads; i++){
           es.execute(() -> {

               try {
                   bankAccount.withdraw(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               latch.countDown();
           });
        }
        es.shutdown();
        latch.await();
        assertEquals(0, bankAccount.getBalance().get());
    }

}
