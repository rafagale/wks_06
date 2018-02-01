import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GestionPaises {

	public static void main(String[] args) {
		int opcion, numeroPaises = 0, n;
		String nombrePais;
		ListaDePaises paises = null;
		String lista[] = { "España", "Afganistan", "Albania", "Alemania", "Cuba", "Francia", "Noruega", "Vietnam",
				"Rusia", "Estados Unidos" };
		Random nombreRandom = new Random();
		do {
			if (paises == null) {
				opcion = pedirEntero("1- Crear lista\n" + "2- Añadir nombre\n" + "3- Borrar un nombre\n"
						+ "4- Listar todos los nombres\n" + "5- Borrar todos los nombres\n" + "6- Mostrar un elemento\n"
						+ "0- Salir");
				while (opcion < 0 || opcion > 1) {
					opcion = pedirEntero("\nCrea la lista para hacer eso");
				}
			} else {
				opcion = pedirEntero("2- Añadir nombre\n" + "3- Borrar un nombre\n" + "4- Listar todos los nombres\n"
						+ "5- Borrar todos los nombres\n" + "6- Mostrar un elemento\n" + "0- Salir");
			}

			switch (opcion) {
			case 1:
				if (paises !=null) {
					System.out.println("Ya hay una lista creada");
				} else {
					numeroPaises = pedirEntero("Cuantos paises quieres almacenar?");
					paises = new ListaDePaises(numeroPaises);
				}
				break;
			case 2: // Añadir
				nombrePais = lista[nombreRandom.nextInt(10)];
				if (paises.anadir(nombrePais)) {
					System.out.println("El pais " + nombrePais + " ha sido añadido a la lista");
				} else {
					System.out.println("El pais " + nombrePais + " ya esta en la lista");
				}
				break;
			case 3: // Borrar
				nombrePais = pedirString("Introduce un nombre");
				if (paises.borrar(nombrePais)) {
					System.out.println("Llamando a Kim Jong-un...");
					System.out.println(nombrePais + " ha sido exterminado");
				} else {
					System.out.println("El pais no está en la lista");
				}
				break;
			case 4: // Listar todos
				System.out.println(paises);
				break;
			case 5: // Borrar todos
				String confirma;
				confirma = pedirString("Seguro que quieres vaciar la lista? (y/n)");
				if (confirma.toLowerCase().equals("y")) {
					paises.vaciarLista();
					System.out.println("Lista borrada");
				}
				break;
			case 6: // Ver una posicion
				System.out.println(paises);
				System.out.println("La primera posicion es 0");
				n = pedirEntero("Selecciona un número");
				if (paises.mostrar(n) != null && paises.getContadorPaises() >= n ) {
					System.out.println("El pais en la posicion " + n + " es " + paises.mostrar(n));
				} else {
					System.out.println("No hay ningun pais en esa posicion (null)");
				}
				break;
			default:
				System.out.println("Elige una opcion valida");
			}// switch
		} while (opcion != 0);

	}// main

	static public int pedirEntero(final String mensaje) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.println(mensaje);
				numero = Integer.parseInt(dataIn.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("Vuelve a introducir el dato, por favor");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato introducido no es entero");
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			}
		}
		return numero;
	}// Pedir entero

	static public String pedirString(final String mensaje) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		String cadena = "";
		boolean error = true;
		while (error) {
			try {
				cadena = "";
				System.out.println(mensaje);
				cadena = dataIn.readLine();
				error = false;
			} catch (IOException e) {
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			}
		}
		return cadena;
	} // Pedir String

}// Class
