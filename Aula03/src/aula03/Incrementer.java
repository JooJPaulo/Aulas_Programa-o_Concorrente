package aula03;

public class Incrementer extends Thread {
    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        System.out.println("Incrementer started");
        this.counter.increment();
    }
}
