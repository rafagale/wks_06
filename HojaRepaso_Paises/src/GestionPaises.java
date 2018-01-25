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
			case 2:
				nombrePais = pedirString("Introduce un nombre");
				for (int i = 0; i < numeroPaises; i++) {
					if (paises[i].equals(nombrePais)) {
						
					}
				}
				break;
			case 3:
				
				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
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
