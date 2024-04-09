package aula04;

public class Data {
    private String message;
    private boolean isSending = true;
    
public synchronized void send(String message) {
    
    while (!isSending) {
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    this.message = message;
    System.out.println("Sent: " + message);

    this.isSending = false;
    notify();
}

public synchronized String receive() {
    
    while (isSending) {
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    String receivedMessage = this.message;
    System.out.println("Received: " + receivedMessage);
    this.isSending = true;
    notify();

    return receivedMessage;
}

}
