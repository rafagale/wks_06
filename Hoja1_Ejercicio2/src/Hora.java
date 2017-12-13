
public class Hora {
	private int horas;
	private int minutos;
	private int segundos;

	Hora() { // Constructor para hh, mm, ss
		horas = 0;
		minutos = 0;
		segundos = 0;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas % 24;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos % 60;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos % 60;
	}

}// Class