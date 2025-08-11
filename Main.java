class Counter {
    private int value = 0;

    // Synchronized method to avoid concurrency issues
    public synchronized void increment() {
        value++;
        System.out.println(Thread.currentThread().getName() + " increased counter to: " + value);
    }
}

// Task that implements Runnable
class IncrementTask implements Runnable {
    private Counter counter;

    public IncrementTask(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            counter.increment();

            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new IncrementTask(counter), "Thread-A");
        Thread thread2 = new Thread(new IncrementTask(counter), "Thread-B");

        thread1.start();
        thread2.start();

    }
}