# Multithreading Counter in Java

This repository demonstrates a **simple multithreading example** in Java using the `Runnable` interface and `synchronized` methods to handle concurrency safely.

## 📌 Overview
The program creates a shared counter that is incremented by two different threads.  
To prevent race conditions, the `increment()` method is declared as `synchronized`, ensuring that only one thread can update the counter at a time.

### Key concepts demonstrated:
- Creating threads using the `Runnable` interface.
- Synchronizing access to shared resources.
- Preventing race conditions in multithreaded programs.

## 🛠 Code Structure

### 1. Counter class

```java
class Counter {
    private int value = 0;

    public synchronized void increment() {
        value++;
        System.out.println(Thread.currentThread().getName() + " increased counter to: " + value);
    }
}

```

### 2. IncrementTask class

```java
class IncrementTask implements Runnable {
    private Counter counter;

    public IncrementTask(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            counter.increment();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

```

### 3. Main class

```java
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new IncrementTask(counter), "Thread-A");
        Thread thread2 = new Thread(new IncrementTask(counter), "Thread-B");

        thread1.start();
        thread2.start();
    }
}
```
## ▶️ How to Run

### Clone the repository

```bash
git clone https://github.com/yourusername/multithreading-counter-java.git
cd multithreading-counter-java
```

### Compile

```bash
javac Main.java
```
