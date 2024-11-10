package gestore.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		Concerto concerto = null;
		
		 while (concerto == null) { // Continua finché non viene creato un concerto valido
	            try {
	                // Inserimento dei dati
	                System.out.print("Inserisci il titolo del concerto: ");
	                String titolo = scan.nextLine();

	                System.out.print("Inserisci la data del concerto (YYYY-MM-DD): ");
	                LocalDate data = LocalDate.parse(scan.nextLine());

	                System.out.print("Inserisci il numero totale di posti: ");
	                int numeroDiPostiTotali = scan.nextInt();

	                System.out.print("Inserisci l'orario del concerto (HH:MM): ");
	                scan.nextLine();
	                LocalTime ora = LocalTime.parse(scan.nextLine());

	                System.out.print("Inserisci il prezzo del biglietto: €");
	                double prezzo = scan.nextDouble();

	                // Creazione del concerto
	                concerto = new Concerto(titolo, data, numeroDiPostiTotali, ora, prezzo);
	                System.out.println("Concerto creato: " + concerto);
		
	            } catch (Exception e) {
	                // Gestione dell'errore e continuazione del ciclo
	                System.out.println("Errore nell'inserimento dei dati: " + e.getMessage());
	                System.out.println("riprova inserendo dati validi.\n");
	            }
	        }
	// Una volta creato un concerto valido, possiamo procedere con le prenotazioni e disdette
    try {
        // Prenotazioni
        System.out.print("Quante prenotazioni desideri effettuare? ");
        int numeroPrenotazioni = scan.nextInt();
        for (int i = 0; i < numeroPrenotazioni; i++) {
            concerto.prenota();
        }
        System.out.println("Posti prenotati: " + concerto.getPostiPrenotati() +
                           " / " + concerto.getPostiTotali());

        // Disdette
        System.out.print("Quante prenotazioni desideri disdire? ");
        int numeroDisdette = scan.nextInt();
        for (int i = 0; i < numeroDisdette; i++) {
            concerto.disdici();
        }
        System.out.println("Posti prenotati aggiornati: " + concerto.getPostiPrenotati() +
                           " / " + concerto.getPostiTotali());

    } catch (Exception e) {
        System.out.println("Errore: " + e.getMessage());
    } finally {
        scan.close();
    }
}
}
			

