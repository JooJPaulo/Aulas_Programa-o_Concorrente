package aula04;

import java.util.concurrent.ThreadLocalRandom;

public class Sender {
    private Data data;
    private String[] messages;

    public Sender(Data data, String[] messages) {
        this.data = data;
        this.messages = messages;
    }

    Thread sender = new Thread(new Runnable() {
        @Override
        public void run() {
            for (String message : messages) {
                int randomTime = ThreadLocalRandom.current().nextInt(1000, 5000);
                try {
                    Thread.sleep(randomTime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                data.send(message);
            }
        }
    });

}
