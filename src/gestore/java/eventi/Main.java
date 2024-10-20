package gestore.java.eventi;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		Evento ev1 = new Evento("ciao", LocalDate.of(2024, 03, 13), 300);
		System.out.println(ev1.getTitolo());
		System.out.println(ev1.getData());
		System.out.println(ev1.getPostiTotali());
		

	}

}
