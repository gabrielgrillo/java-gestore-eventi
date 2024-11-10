package gestore.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
    private double prezzo;

    // Costruttore
    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) throws Exception {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // Getter e Setter
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo per ottenere data e ora formattate
    public String getDataOraFormattata() {
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter oraFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(dataFormatter) + " " + ora.format(oraFormatter);
    }

    // Metodo per formattare il prezzo
    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    // Override di toString() per includere data, ora e prezzo
    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - Prezzo: " + getPrezzoFormattato();
    }

}
