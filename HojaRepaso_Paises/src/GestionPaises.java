import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestionPaises {

	public static void main(String[] args) {
		int opcion, numeroPaises=0;
		String nombrePais;
		ListaDePaises paises = null;

		do {
			if (paises == null) {
				opcion = pedirEntero("1- Crear lista\n" + "2- Añadir nombre\n" + "3- Borrar un nombre\n"
						+ "4- Listar todos los nombres\n" + "5- Borrar todos los nombres\n" + "6- Salir.");
				while (opcion < 0 || opcion > 1) {
					opcion = pedirEntero("\nCrea la lista para hacer eso");
				}
			} else {
				opcion = pedirEntero("2- Añadir nombre\n" + "3- Borrar un nombre\n" + "4- Listar todos los nombres\n"
						+ "5- Borrar todos los nombres\n" + "6- Salir.");
			}

			switch (opcion) {
			case 1:
				numeroPaises = pedirEntero("Cuantos paises quieres almacenar?");
				paises = new ListaDePaises(numeroPaises);
				break;
			case 2: //Añadir
				nombrePais = pedirString("Introduce un nombre");
				if (paises.anadir(nombrePais)) {
					System.out.println(nombrePais + " ha sido añadido a la lista");
				} else if (paises.estaLlena()) {
					System.out.println("La lista esta llena");
				} else {
					System.out.println(nombrePais + " ya está en la lista");
				}
				break;
			case 3: //Borrar
				nombrePais = pedirString("Introduce un nombre");
				if (paises.borrar(nombrePais)) {
					System.out.println("Llamando a Kim Jong-un...");
					System.out.println(nombrePais + " ha sido exterminado");
				}
				break;
			case 4: //Listar todos
				System.out.println(paises);
				break;
			case 5: //Borrar todos
				String confirma;
				confirma = pedirString("Seguro que quieres vaciar la lista? (y/n)");
				if (confirma.toLowerCase().equals("y")) {
					paises.vaciarLista();
					System.out.println("Lista borrada");
				} else {
					System.out.println("No se ha vaciado la lista");
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
