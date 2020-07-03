public class Person implements Runnable{

    Account account;


    public Person(Account account){
        this.account = account;

    }

    public synchronized int spend(int amount) throws InterruptedException {

        if(account.getBalance() >= amount) {

            System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount + " from the account with balance of " + this.account.getBalance() + ".");

                System.out.println("waiting");
                wait(100);
                System.out.println("done");



            account.withdraw( amount);

            return this.account.getBalance();

        }
        System.out.println(Thread.currentThread().getName() + " cannot make withdrawal, account balance: " + this.account.getBalance());
        return -1;

     }

     public void run() {

         try {

             this.spend(10);

         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }
}
