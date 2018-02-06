import utilidades.Leer;

public class VerDosDimensiones extends VerUnaDimension {
	private int alto;

	public VerDosDimensiones() {
		alto = Leer.pedirEntero("\n\tIndique la altura del rect�ngulo: ");
	}

	public VerDosDimensiones(int alto, int ancho) {
		super(ancho);
		this.alto = alto;
	}

	public void verArea() {
		Leer.mostrarEnPantalla("\n\tUn rect�ngulo con estos datos: ");
		Leer.mostrarEnPantalla("\n\t\tLARGURA: " + getLargo());
		Leer.mostrarEnPantalla("\n\t\tALTO: " + alto);
		Leer.mostrarEnPantalla("\n\t\t\tLA CARA OCUPA UN �REA DE: " + getLargo() * alto + "\n");
	}

	public int getAlto() {
		return alto;
	}
}