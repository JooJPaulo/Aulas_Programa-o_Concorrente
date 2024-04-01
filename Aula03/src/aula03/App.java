package aula03;

public class App {

	public static void main(String[] args) {
		while(true) {
			Counter counter = new Counter(0);
		Incrementer incrementer1 = new Incrementer(counter);
		Incrementer incrementer2 = new Incrementer(counter);
		Incrementer incrementer3 = new Incrementer(counter);
		Incrementer incrementer4 = new Incrementer(counter);
		
		incrementer1.start();
		incrementer2.start();
		incrementer3.start();
		incrementer4.start();

		try {
			incrementer1.join();
			incrementer2.join();
			incrementer3.join();
			incrementer4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Counter value: " + counter.getValue());
}
		
	}

}
