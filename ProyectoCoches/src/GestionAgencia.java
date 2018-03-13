import java.util.Random;

public class GestionAgencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Integer NUMCOCHE = 20;
		Coche[] coches = new Coche[NUMCOCHE];
		// llamada al método para crear los coches .
		creacionCoches(coches);
		int opcion = menu();// opción de menú
		while (opcion != 0) {// menú
			switch (opcion) {// acciones de menú
			case 1:// alquilar
				alquilarCoche(coches);
				break;
			case 2:// devolver
				devolverCoche(coches);
				break;
			case 3:// Listar disponibles
				verCochesDisponibles(coches);
				break;
			case 4:// Listar ocupados
				verCochesOcupados(coches);
			}
			opcion = menu();
		}
	}

	public static void devolverCoche(Coche[] coches) {
		int devolver;
		int diasAlquiler;
		for (int i = 0; i < coches.length && coches[i] != null; i++) {
			if (!coches[i].getDisponible()) {
				System.out.println("ID # " + i + " " + coches[i].visualizarCoche());
			}
		}
		do {
			devolver = Leer.pedirEntero("Estos son los coches que se pueden devolver. Elige el que quieras devolver");
		} while (devolver < 0 || devolver > 19);

		// Compruebo que no este disponible (Este alquilado) en caso de que se
		// meta otro valor sin querer
		if (coches[devolver].getDisponible()) {
			System.out.println("No se puede devolver un coche que no se ha alquilado");
		} else {
			diasAlquiler = Leer.pedirEntero("Cuantos dias has tenido este coche alquilado?");
			System.out.println(coches[devolver].devolver(diasAlquiler) + "€ es lo que tienes que pagar");
			System.out.println(coches[devolver].visualizarCoche() + " \nDevuelto");
		}
	}// devolverCoche

	public static void alquilarCoche(Coche[] coches) {
		int pregunta;
		int alquilar;
		// Obligo a que se de un numero entre 1 y 2
		do {
			pregunta = Leer.pedirEntero("Quieres alquilar un coche normal o de lujo?\n1- Normal \n2- De lujo");
		} while (pregunta < 1 || pregunta > 2);

		switch (pregunta) {
		case 1:
			// Visualizo los coches de la clase Normal que tienen el atributo
			// disponible = true
			for (int i = 0; i < coches.length; i++) {
				if (coches[i].getDisponible() && coches[i] instanceof Normal) {
					System.out.println("ID # " + i + " " + coches[i].visualizarCoche());
				}
			}
			do {
				pregunta = Leer.pedirEntero("Elige un coche");
			} while ((pregunta < 0 || pregunta > 19));
			if (coches[pregunta].getDisponible()) {
				coches[pregunta].alquilar();
				System.out.println("Has alquilado el coche" + coches[pregunta].visualizarCoche());
			} else {
				System.out.println("Ya esta alquilado!!");
			}

			break;
		case 2:
			// Visualizo los coches de la clase Lujo que tienen el atributo
			// disponible = true
			for (int i = 0; i < coches.length; i++) {
				if (coches[i].getDisponible() && coches[i] instanceof Lujo) {
					System.out.println("ID # " + i + " " + coches[i].visualizarCoche());
				}
			}
			do {
				pregunta = Leer.pedirEntero("Elige un coche");
			} while ((pregunta < 0 || pregunta > 19));
			if (coches[pregunta].getDisponible()) {
				coches[pregunta].alquilar();
				System.out.println("Has alquilado el coche" + coches[pregunta].visualizarCoche());
			} else {
				System.out.println("Ya esta alquilado!!");
			}
		}// switch
	}// alquilarCoche

	public static void verCochesOcupados(Coche[] coches) {
		// Si no estan disponibles se muestran en pantalla
		for (int i = 0; i < coches.length && coches[i] != null; i++) {
			if (!coches[i].getDisponible()) {
				System.out.println(coches[i].visualizarCoche());
			}
		}
	}// verCochesOcupados

	public static void creacionCoches(Coche[] coches) {
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "X", "Y", "Z" };
		String[] marcas = { "Audi", "BMW", "Seat", "Volvo", "Tata", "Lolo" };
		String[] modelos = { "M1", "M2", "Toledo", "M4", "M5", "A1" };
		String[] parkings = { "Aparcamiento del Ebro", "IberPark", "Aragonia" };
		Random rand = new Random();
		String letrasMatricula = "";
		// Se crean los 15 primeros espacios del vector con coches normales,
		// asignando 4 numeros aleatorios y 3 letras del string letras de forma
		// aleatoria tambien

		for (int i = 0; i < 15; i++) {
			letrasMatricula = "";
			for (int j = 0; j < 3; j++) {
				letrasMatricula += letras[rand.nextInt(letras.length)];
			}
			Fecha fechaCreacion = new Fecha(rand.nextInt(15) + 1, rand.nextInt(12) + 1,
					rand.nextInt(2017 - 2000 + 1) + 2000);
			coches[i] = new Normal(rand.nextInt(9999 - 1111 + 1) + 1111 + "-" + letrasMatricula,
					marcas[rand.nextInt(marcas.length)], modelos[rand.nextInt(modelos.length)], fechaCreacion,
					rand.nextInt(30 - 20 + 1) + 20, parkings[rand.nextInt(parkings.length)]);
		}
		// Se rellenan los ultimos 5 huecos con coches de lujo de la misma
		// manera pero con los parametros de la clase Lujo
		for (int i = 15; i < coches.length; i++) {
			letrasMatricula = "";
			for (int j = 0; j < 3; j++) {
				letrasMatricula += letras[rand.nextInt(letras.length)];
			}
			Fecha fechaCreacion = new Fecha(rand.nextInt(15) + 1, rand.nextInt(12) + 1,
					rand.nextInt(2017 - 2000 + 1) + 2000);
			coches[i] = new Lujo(rand.nextInt(9999 - 1111 + 1) + 1111 + "-" + letrasMatricula,
					marcas[rand.nextInt(marcas.length)], modelos[rand.nextInt(modelos.length)], fechaCreacion,
					rand.nextInt(60 - 50 + 1) + 50);
		}

	}// creacionCoches

	public static void verCochesDisponibles(Coche[] coches) {
		// Si estan disponibles se muestran en pantalla
		for (int i = 0; i < coches.length && coches[i] != null; i++) {
			if (coches[i].getDisponible()) {
				System.out.println(coches[i].visualizarCoche());
			}
		}
	}// verCochesDisponibles

	public static int menu() {
		int opcion;
		Leer.mostrarEnPantalla("1.- Alquilar coche");
		Leer.mostrarEnPantalla("2.- Devolver coche");
		Leer.mostrarEnPantalla("3.- Listado de coches disponibles");
		Leer.mostrarEnPantalla("4.- Listado de coches ocupados");
		Leer.mostrarEnPantalla("0.- Salir");
		opcion = Leer.pedirEntero("Introduce una opcion");
		return opcion;
	}
}
