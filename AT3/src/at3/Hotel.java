package at3;

public class Hotel {
	public static void main(String[] args) {
		
		Quartos quartos = new Quartos();
		Hospedes hospedes = new Hospedes(quartos);
		Camareiras camareiras = new Camareiras(quartos);
		Recepcionistas recepcionistas = new Recepcionistas(quartos);
		
		hospedes.start();
		camareiras.start();
		recepcionistas.start();
		
		try {
			hospedes.join();
			camareiras.join();
			recepcionistas.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}

}
