import utilidades.Leer;

public class Principal {
	public static void main(String[] args) {
		Persona p[] = new Persona[3];
		int pos;
		for (pos = 0; pos < 3; pos++) {
			p[pos] = new Persona();
		}

		Mamifero ma[] = new Mamifero[2];
		for (pos = 0; pos < 2; pos++) {
			ma[pos] = new Mamifero();
		}

		Animal a = new Animal();
		Leer.mostrarEnPantalla("\n\tINSERCIÓN DE LOS DATOS DE LAS DIFERENTES PERSONAS:");
		for (pos = 0; pos < 3; pos++) {
			Leer.mostrarEnPantalla("\n\t\tINSERTE LOS DATOS DE LA PERSONA "	+ (pos + 1));
			p[pos].insertarDatosPers();
		}
		Leer.mostrarEnPantalla("\n\tINSERCIÓN DE LOS DATOS DE LOS DIFERENTES MAMÍFEROS:");
		for (pos = 0; pos < 2; pos++) {
			Leer.mostrarEnPantalla("\t\tINSERTE LOS DATOS DEL MAMÍFERO" + (pos + 1));
			ma[pos].insertarDatosMamif();
		}
		pos = 0;
		Leer.mostrarEnPantalla("\n\tINSERCIÓN DE LOS DATOS DEL RESTO DE LOS ANIMALES: ");
		Leer.mostrarEnPantalla("\t\tINSERTE LOS DATOS DEL ANIMAL " + (pos + 1));
		a.insertarDatos();
		Leer.mostrarEnPantalla("\nVISUALIZACIÓN DE LOS DATOS DE LAS DIFERENTES PERSONAS: ");
		for (pos = 0; pos < 3; pos++) {
			Leer.mostrarEnPantalla("\nPERSONA" + (pos + 1));
			p[pos].visualizarDatos();
		}
		Leer.mostrarEnPantalla("\nVISUALIZACIÓN DE LOS DATOS DE LOS DIFERENTES MAMÍFEROS: ");
		for (pos = 0; pos < 2; pos++) {
			System.out.println("\nMAMÍFERO" + (pos + 1));
			ma[pos].visDatosMamif();
		}
		Leer.mostrarEnPantalla("\nVISUALIZACIÓN DE LOS DATOS DEL RESTO DE LOS ANIMALES: ");
		a.vis_datosanim();
		Leer.mostrarEnPantalla("\n\tSE VA A PROCEDER A DAR DE COMER A TODAS LAS PERSONAS: ");
		for (pos = 0; pos < 3; pos++) {
			Leer.mostrarEnPantalla("\n\t\tPERSONA" + (pos + 1));
			p[pos].alimentarse();
		}
		Leer.mostrarEnPantalla("\n\tSE VA A PROCEDER A DAR DE COMER A TODOS LOS MAMÍFEROS: ");
		for (pos = 0; pos < 2; pos++) {
			Leer.mostrarEnPantalla("\n\t\t MAMÍFERO" + (pos + 1));
			ma[pos].alimentarse();
		}
		pos = 0;
		Leer.mostrarEnPantalla("\n\tTerminado de comer todos los mamíferos, pasamos a que coma el único animal: ");
		Leer.mostrarEnPantalla("\n\tSE VA A PROCEDER A DAR DE COMER AL RESTO DE LOS ANIMALES: ");
		Leer.mostrarEnPantalla("\n\t\t ANIMAL " + (pos + 1));
		a.alimentarse();
		Leer.mostrarEnPantalla("\nFINALIZACIÓN DE TODO EL PROCESO. ");

	}
}
