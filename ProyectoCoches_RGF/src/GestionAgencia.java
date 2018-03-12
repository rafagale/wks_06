import java.util.Random;

/**
 * @author Rafael Gale
 * @category Ejercicio 2
 */
public class GestionAgencia {

	public static void main(String[] args) {

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
				System.out.println("Estos son los coches disponibles: ");
				verCochesDisponibles(coches);
				break;
			case 4:// Listar ocupados
				System.out.println("Estos son los coches que estan alquilados: ");
				verCochesOcupados(coches);
			}// switch
			opcion = menu();
		} // while
	}

	private static void devolverCoche(Coche[] coches) {
		int devolver;
		int diasAlquiler;
		for (int i = 0; i < coches.length && coches[i] != null; i++) {
			if (!coches[i].getDisponible()) {
				System.out.println("ID # " + i + " " + coches[i]);
			}
		}
		devolver = Leer.pedirEntero("Estos son los coches que se pueden devolver. Elige el que quieras devolver");
		// Compruebo que no este disponible (Este alquilado) en caso de que se
		// meta otro valor sin querer
		if (coches[devolver].getDisponible()) {
			System.out.println("No se puede devolver un coche que no se ha alquilado");
		} else {
			diasAlquiler = Leer.pedirEntero("Cuantos dias has tenido este coche alquilado?");
			System.out.println(coches[devolver].devolver(diasAlquiler) + "€ es lo que tienes que pagar");
			System.out.println(coches[devolver] + " \nDevuelto");
		}
	}// devolverCoche

	private static void alquilarCoche(Coche[] coches) {
		int pregunta;
		int alquilar;
		int contador;
		// Obligo a que se de un numero entre 1 y 2
		do {
			pregunta = Leer.pedirEntero("Quieres alquilar un coche normal o de lujo?\n1- Normal \n2- De lujo");
		} while (pregunta < 1 || pregunta > 2);

		switch (pregunta) {
		case 1:
			// Visualizo los coches de la clase Normal que tienen el atributo
			// disponible = true
			contador = 0;
			for (int i = 0; i < coches.length; i++) {
				if (coches[i].getDisponible() && coches[i] instanceof Normal) {
					System.out.println("ID # " + i + " " + coches[i]);
					contador++;
				}
			}
			// Si el contador es 0 es que no hay ningun coche disponible
			if (contador == 0) {
				System.out.println("No hay coches disponibles por el momento");
			} else {
				// ya que el vector es de 20 uso un filtro para que no se
				// introduzcan valores por debajo de cero ni por encima de 19 ya
				// que saltaria una excepcion
				do {
					alquilar = Leer.pedirEntero(
							"Estos son los coches normales que estan disponibles ahora. Elija una mediante su identificador");
				} while (alquilar < 0 || alquilar > 19);
				comprobarEstado(coches, alquilar);
			}
			break;
		case 2:
			// Visualizo los coches de la clase Lujo que tienen el atributo
			// disponible = true
			contador = 0;
			for (int i = 0; i < coches.length; i++) {
				if (coches[i].getDisponible() && coches[i] instanceof Lujo) {
					System.out.println("ID # " + i + " " + coches[i]);
					contador++;
				}
			}
			// Si el contador es 0 es que no hay ningun coche disponible
			if (contador == 0) {
				System.out.println("No hay coches disponibles por el momento");
			} else {
				// ya que el vector es de 20 uso un filtro para que no se
				// introduzcan valores por debajo de cero ni por encima de 19 ya
				// que saltaria una excepcion
				do {
					alquilar = Leer.pedirEntero(
							"Estos son los coches normales que estan disponibles ahora. Elija una mediante su identificador");
				} while (alquilar < 0 || alquilar > 19);
				comprobarEstado(coches, alquilar);
			}
		}// switch alquiler
	}// alquilarCoche

	private static void comprobarEstado(Coche[] coches, int alquilar) {
		// Compruebo que el estado sea disponible para el coche en cuestion,
		// para luego llamar al metodo alquilar
		if (coches[alquilar].getDisponible()) {
			System.out.println(coches[alquilar] + " \nAlquilado");
			// Llamo al metodo de alquilar que comprueba si esta disponible y le
			// cambia el valor a false
			coches[alquilar].alquilar();
		} else {
			System.out.println("Ya esta alquilado");
		}
	}

	private static void verCochesDisponibles(Coche[] coches) {
		// Si estan disponibles se muestran en pantalla
		for (int i = 0; i < coches.length && coches[i] != null; i++) {
			if (coches[i].getDisponible()) {
				System.out.println(coches[i]);
			}
		}
	}// verCochesDisponibles

	private static void verCochesOcupados(Coche[] coches) {
		// Si no estan disponibles se muestran en pantalla
		for (int i = 0; i < coches.length && coches[i] != null; i++) {
			if (!coches[i].getDisponible()) {
				System.out.println(coches[i]);
			}
		}
	}// verCochesOcupados

	public static void creacionCoches(Coche[] coches) {
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "X", "Y", "Z" };
		String[] marcas = { "Audi", "BMW", "Seat", "Volvo", "Tata", "Lolo" };
		String[] modelos = { "M1", "M2", "Toledo", "M4", "M5", "A1" };
		String[] parkings = { "Aparcamiento del Ebro", "IberPark", "Aragonia" };
		Boolean[] estados = { true, false };
		Random rand = new Random();
		// Se crean los 15 primeros espacios del vector con coches normales,
		// asignando 4 numeros aleatorios y 3 letras del string letras de forma
		// aleatoria tambien
		for (int i = 0; i < 15; i++) {
			Fecha fechaCreacion = new Fecha(rand.nextInt(15) + 1, rand.nextInt(12) + 1,
					rand.nextInt(2017 - 2000 + 1) + 2000);
			coches[i] = new Normal(
					rand.nextInt(999 - 111 + 1) + 111 + letras[rand.nextInt(letras.length)]
							+ letras[rand.nextInt(letras.length)] + letras[rand.nextInt(letras.length)],
					marcas[rand.nextInt(marcas.length)], modelos[rand.nextInt(modelos.length)], fechaCreacion,
					estados[rand.nextInt(2)], rand.nextInt(30 - 20 + 1) + 20, parkings[rand.nextInt(parkings.length)]);
		}
		// Se rellenan los ultimos 5 huecos con coches de lujo de la misma
		// manera pero con los parametros de la clase Lujo
		for (int i = 15; i < coches.length; i++) {
			Fecha fechaCreacion = new Fecha(rand.nextInt(15) + 1, rand.nextInt(12) + 1,
					rand.nextInt(2017 - 2000 + 1) + 2000);
			coches[i] = new Lujo(
					rand.nextInt(999 - 111 + 1) + 111 + letras[rand.nextInt(letras.length)]
							+ letras[rand.nextInt(letras.length)] + letras[rand.nextInt(letras.length)],
					marcas[rand.nextInt(marcas.length)], modelos[rand.nextInt(modelos.length)], fechaCreacion,
					estados[rand.nextInt(2)], rand.nextInt(60 - 50 + 1) + 50);
		}

	}// creacionCoches

	public static int menu() {
		int opcion;
		Leer.mostrarEnPantalla("1.- Alquilar coche");
		Leer.mostrarEnPantalla("2.- Devolver coche");
		Leer.mostrarEnPantalla("3.- Listado de coches disponibles");
		Leer.mostrarEnPantalla("4.- Listado de coches ocupados");
		Leer.mostrarEnPantalla("0.- Salir");
		opcion = Leer.pedirEntero("Elige una opcion");
		return opcion;
	}

}// Class
