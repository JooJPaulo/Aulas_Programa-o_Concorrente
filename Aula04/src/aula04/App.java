package aula04;

public class App {

	public static void main(String[] args) {

		Data data = new Data();
		String[] messages = { "Message 1", "Message 2", "Message 3", "END" };

		Sender sender = new Sender(data, messages);
		Receiver receiver = new Receiver(data);

		sender.sender.start();
		receiver.receiver.start();

		try {
			sender.sender.join();
			receiver.receiver.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finished!");

	}

}
