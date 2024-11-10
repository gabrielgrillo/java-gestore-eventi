package gestore.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi {

		private String titolo;
		private List<Evento> eventi;
		
		//costruttore che passa il titolo come parametro e crea un arraylist
		public ProgrammaEventi(String titolo) {
			this.titolo = titolo;
			this.eventi = new ArrayList<>();
		}
		
		//metodo per aggiungere eventi
		public void addEvento(Evento evento) {
			eventi.add(evento);	
		}
		
		//metodo per contare il numero di eventi
		public int getNumeroEventi() {
			return eventi.size();	
			}
		
		// Metodo per svuotare tutti gli eventi
	    public void svuotaEventi() {
	        eventi.clear();
	    }
	    
	    // Metodo per ottenere eventi in una specifica data
	    public List<Evento> getEventiPerData(LocalDate data) {
	        return eventi.stream()
	                .filter(evento -> evento.getData().equals(data))
	                .collect(Collectors.toList());
	    }
	    
	 // Metodo per rappresentare tutti gli eventi come stringa formattata
	    public String getEventiOrdinatiPerData() {
	        return eventi.stream()
	                .sorted((e1, e2) -> e1.getData().compareTo(e2.getData()))
	                .map(Evento::toString)
	                .collect(Collectors.joining("\n"));
	    }
	    
	 // Override di toString() per visualizzare titolo e eventi
	    @Override
	    public String toString() {
	        return "Programma di eventi: " + titolo + "\n" + getEventiOrdinatiPerData();
	    }
	    
}
