package gestore.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;

	public Evento (String titolo, LocalDate data, int postiTotali ) throws Exception {
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("La data dell'evento è già passata");
        }
        if (postiTotali <= 0) {
            throw new Exception("Il numero di posti totali deve essere >0");
        } 
    {
		setTitolo(titolo);
		setData(data);
		this.postiTotali = postiTotali;
        }
	}
	
	public Evento() {
		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	// Metodo prenota
    public void prenota() {
        if (LocalDate.now().isAfter(data)) {
            System.out.println("L'evento è già passato");
        }
        else if (postiPrenotati >= postiTotali) {
            System.out.println("Non ci sono più posti disponibili");
        }
        else {
            postiPrenotati++;
            System.out.println("Prenotazione effettuata con successo");
        }
    }
    
    //Metodo disdici
    public void disdici() {
    	if (LocalDate.now().isAfter(data)) {
            System.out.println("L'evento è già passato");
        }
    	else if(postiPrenotati <= 0) {
    		System.out.println("Non ci sono prenotazioni da disdire");
    	}
    	else {
    		postiPrenotati--;
    		System.out.println("L'operazione è andata a buon fine");
    	}
    }
    
 // Override del metodo toString()
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }

	

}
