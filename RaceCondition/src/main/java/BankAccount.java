import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private volatile AtomicInteger balance = new AtomicInteger(50);

    public synchronized void withdraw(int spend) throws InterruptedException{

        //AtomicInteger temp = balance;
        System.out.println(Thread.currentThread().getName() + " withdrawing from balance: " + balance);
        wait(100);

        if(balance.get() - spend >= 0) {
            balance.addAndGet(-spend);
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + spend + ". New balance: " + balance);
        }
        else{
            System.out.println(Thread.currentThread().getName() + " is unable to  withdraw " + spend + " from a balance of " + balance);

        }

    }

    public AtomicInteger getBalance(){
        return this.balance;
    }

}
