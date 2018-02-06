import utilidades.Leer;

public class VerUnaDimension {

	private int largo;

	public VerUnaDimension() {
		largo = Leer.pedirEntero("\n\tIndique cual es su largura: ");
	}

	public VerUnaDimension(int largo) {
		this.largo = largo;
	}
	
	public void verLinea() {
		Leer.mostrarEnPantalla("\n\t\tLA LINEA TIENE UNA LARGURA DE " + largo);
	}

	public int getLargo() {
		return largo;
	}
}