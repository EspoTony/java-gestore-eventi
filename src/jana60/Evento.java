package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	// Attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;

	// Costruttore
	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		super();
		this.titolo = titolo;
		if (data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("La data non puo precedere quella odierna");
		}
		if (postiTotali > 0) {
			this.postiTotali = postiTotali;
		} else {
			throw new IllegalArgumentException("Il valore deve essere superiore a 0");
		}
	}

	// Getter and Setter
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
	
	//Metodi
	public void prenota (LocalDate dataPrenotata)throws Exception {
		if (dataPrenotata.isBefore(LocalDate.now())) {
			throw new Exception("La data non puo precedere quella odierna");
		}else if(dataPrenotata.isAfter(data))
			throw new Exception("La data non puo superare l'evento");
		else if (postiPrenotati == postiTotali) {
			throw new Exception ("Non ci sono posti prenotabili.");
		}else {
			postiPrenotati++;
		}
	}
	
	public void disdici(LocalDate dataDisdetta)throws Exception {
		if (dataDisdetta.isBefore(LocalDate.now())) {
			throw new Exception("La data non puo precedere quella odierna");
		}else if(dataDisdetta.isAfter(data))
			throw new Exception("La data non puo superare l'evento");
		else if (postiPrenotati == 0) {
			throw new Exception ("Non ci sono prenotazioni quindi non puoi disdire.");
		}else {
			postiPrenotati --;
		}
	}
	
	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter formdate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(formdate);
		return dataFormattata + " - " + this.titolo;
	}
}