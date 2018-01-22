import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.*;

/**
 * 
 * @author Rafa
 */
public class GestionLibroAutor4_ArrayList {

	public static void main(String[] args) {
		int opcion, cantidad, n, numeroAutores;
		String modificacion;
		Double precio;
		String libro, titulo, nombre, email, genero;

		ArrayList<Libro> libros = new ArrayList<>();
		ArrayList<Autor> autores = new ArrayList<>();

		Autor autor = null;
		Libro librox = null;
		opcion = pedirEntero(
				"1-Crear libro\n2-Modificar autores ultimo libro\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Crear libros
				numeroAutores = pedirEntero("Cuantos autores va a tener este libro?");
				cantidad = pedirEntero("Cantidad de libros a crear?");
				titulo = pedirString("Introduce el titulo del libro");
				precio = pedirDouble("Introduce el precio del libro");

				for (int i = 0; i < numeroAutores; i++) {
					nombre = pedirString("Nombre autor");
					email = pedirString("Email autor");
					do {
						genero = pedirString("Genero(hombre/mujer)");
					} while (!genero.toLowerCase().equals("hombre") && !genero.toLowerCase().equals("mujer"));
					autor = new Autor(nombre, email, genero);
					autores.add(autor);
				}

				Autor[] arrayAutores = new Autor[autores.size()];
				arrayAutores = autores.toArray(arrayAutores);

				librox = new Libro(titulo, arrayAutores, precio, cantidad);
				for (int i = 0; i < Libro.getContadorLibros(); i++) {
					libros.add(librox);
				}

				break;
			case 2:// Modificar autor

				break;
			case 3: // Modificar libro

				break;
			case 4: // Visualizar libros
				System.out.println(librox.cadenaLibroVariosAutores());
				break;
			case 5: // Visualizar autores
				System.out.println(autores);
				break;

			default:
				System.out.println("Elige una opcion correcta");
			}// switch
			opcion = pedirEntero(
					"1-Crear libro\n2-Modificar autores ultimo libro\n3-Modificar libro\n4-Ver libros\n5-Ver autores ultimo libro\n0-Salir");
		} // while
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

	public static String pedirString(String mensaje) {
		String s1;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		s1 = sc.nextLine();
		return s1;
	}// Pedir string

	static public double pedirDouble(final String mensaje) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		double numero = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.println(mensaje);
				numero = Double.parseDouble(dataIn.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato introducido no es decimal");
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			}
		}
		return numero;
	}// Pedir double
}// Class
