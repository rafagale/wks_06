import utilidades.Leer;

public class Mamifero extends Animal {
	private int numhuesos;
	private int numextremidades;

	public Mamifero() {
		System.out.print(", mamífero");
	}

	public void insertarDatosMamif() {
		insertarDatos();
		numhuesos = Leer.pedirEntero("\t\tNúmero de huesos (como mamífero que es)");
		numextremidades = Leer.pedirEntero("\t\tNúmero de extremidades (como mamífero que es): ");
	}

	public void visDatosMamif() {
		vis_datosanim();
		Leer.mostrarEnPantalla("\n\t Huesos: " + numhuesos);
		Leer.mostrarEnPantalla("\n\t Extremidades: " + numextremidades);
	}
}
