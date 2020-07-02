import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        int numberOfHolders = 6;
        Account bankAccount = new Account(50);
        Person person = new Person(bankAccount);

        ExecutorService es = Executors.newFixedThreadPool(numberOfHolders);

        for(int i = 0; i<numberOfHolders; i++){
            es.submit(person);
        }

        es.shutdown();

    }


}
class Account {

    private int balance;

    public Account(int openingBalance){
        this.balance = openingBalance;
    }

    public void withdraw( int spend) {

            balance  = balance -spend;
                System.out.println(Thread.currentThread().getName() + " withdraws " + spend + ". Balance is now: " + balance);

    }

    public int getBalance(){
        return this.balance;
    }
}
