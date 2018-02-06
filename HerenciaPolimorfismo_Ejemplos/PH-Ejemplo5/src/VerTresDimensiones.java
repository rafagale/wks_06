import utilidades.Leer;

public class VerTresDimensiones extends VerDosDimensiones {
	private int grosor;

	public VerTresDimensiones() {
		grosor = Leer.pedirEntero("\n\tlndique grosor del rectángulo: ");
	}

	public VerTresDimensiones(int ancho, int alto, int grosor) {
		super(alto, ancho);
		this.grosor = grosor;
	}

	public void verVolumenPoli() {
		Leer.mostrarEnPantalla("\n\n\tUna caja con estos datos: ");
		Leer.mostrarEnPantalla("\n\t\tLARGURA: " + getLargo());
		Leer.mostrarEnPantalla("\n\t\tALTO: " + getAlto());
		Leer.mostrarEnPantalla("\n\t\tGROSOR: " + grosor);
		Leer.mostrarEnPantalla("\n\t\t\tOCUPA UN VOLUMEN DE: " + getLargo()
				* getAlto() * grosor);
	}
}
