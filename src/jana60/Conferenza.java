package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento {
	private String argomento;
	private Oratore oratore;

	public Conferenza(String titolo, LocalDate data, int postiTotali,String argomento, Oratore oratore) throws Exception {
		super(titolo, data, postiTotali);
		this.argomento = argomento;
		this.oratore = oratore;
	}

	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	public Oratore getOratore() {
		return oratore;
	}

	public void setOratore(Oratore oratore) {
		this.oratore = oratore;
	}

	@Override
	public String toString() {
		return super.toString()+ " questa è una conferenza riguardante: " + argomento + " presentata da: " + oratore;
	}
}
