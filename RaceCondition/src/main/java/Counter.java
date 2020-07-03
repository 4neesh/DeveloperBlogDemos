public class Counter {

    private int count;

    public synchronized void increment() throws InterruptedException{
        int temp = count;
        System.out.println(Thread.currentThread().getName() + " wait");
        wait(100);
        System.out.println(Thread.currentThread().getName() + " done");

        count = temp + 1;
    }

    public int getCount(){
        return this.count;
    }

}
