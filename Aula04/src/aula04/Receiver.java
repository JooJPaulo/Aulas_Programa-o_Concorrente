package aula04;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver {
    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    Thread receiver = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                String message = data.receive();

                int randomTime = ThreadLocalRandom.current().nextInt(1000, 5000);
                try {
                    Thread.sleep(randomTime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (message == "END") {
                    System.out.println("Received END message. Exiting...");
                    break;
                }
            }
        }
    });
}
