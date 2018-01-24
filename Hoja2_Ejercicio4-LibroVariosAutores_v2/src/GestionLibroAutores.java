import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Rafa
 * @see
 */
public class GestionLibroAutores {

	public static void main(String[] args) {
		int opcion, maxAutores, maxLibros;//, cantidad, n, numeroAutores ;
		/*String modificacion;
		Double precio;
		String libro, titulo, nombre, email, genero;*/

		maxAutores = pedirEntero("Cuantos autores?");
		maxLibros = pedirEntero("Libros maximos?");

		Libro[] libros = new Libro[maxLibros];
		Autor[] autores = new Autor[maxAutores];
		Autor[] listaAutores = new Autor[maxAutores];
		System.out.println("Hay " + maxLibros + " libros");
		opcion = pedirEntero(
				"1-Crear libro\n2-Modificar autores\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Crear libros
				autores = crearLibros(libros, listaAutores);
				break;
			case 2: // Modificar autores
				modificarAutores(listaAutores);
				break;
			case 3: // Modificar libro
				modificarLibros(libros);
				break;
			case 4: // Ver libros
				verLibros(libros);
				break;
			case 5:// Ver autores
				verAutores(autores, listaAutores);
				break;
			default:
				System.out.println("Elige una opcion correcta");
			}// switch
			opcion = pedirEntero(
					"1-Crear libro\n2-Modificar autores\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		} // while
	}// main

	private static Autor[] crearLibros(Libro[] libros, Autor[] listaAutores) {
		int cantidad;
		int numeroAutores;
		Double precio;
		String titulo;
		String nombre;
		String email;
		String genero;
		Autor[] autores;
		titulo = pedirString("Introduce el titulo del libro");
		numeroAutores = pedirEntero("Cuantos autores va a tener este libro?");
		precio = pedirDouble("Introduce el precio del libro");
		cantidad = pedirEntero("Cantidad de libros a crear?");
		// Instanciar un array nuevo para cada libro
		autores = new Autor[numeroAutores];
		for (int i = 0; i < autores.length; i++) {
			nombre = pedirString("Nombre autor");
			email = pedirString("Email autor");
			do {
				genero = pedirString("Genero(hombre/mujer)");
			} while (!genero.toLowerCase().equals("hombre") && !genero.toLowerCase().equals("mujer"));
			autores[i] = new Autor(nombre, email, genero);
			// Guardar los autores en un otro array
			listaAutores[Autor.getContadorAutores()] = autores[i];
		}
		libros[Libro.getContadorLibros()] = new Libro(titulo, autores, precio, cantidad);
		System.out.println("Libro #" + Libro.getContadorLibros() + " creado");
		System.out.println("Contador de autores = " + Autor.getContadorAutores());
		return autores;
	}

	private static void modificarAutores(Autor[] listaAutores) {
		int n;
		String modificacion;
		System.out.println("Lista:");
		for (int i = 0; i < listaAutores.length; i++) {
			if (listaAutores[i] != null) {
				System.out.println("#" + i + "--->" + listaAutores[i].cadenaAutor());
			}
		}
		n = pedirEntero("Selecciona su numero");
		modificacion = pedirString("Escribe su nuevo correo");
		try {
			listaAutores[n].setEmail(modificacion);
		} catch (Exception e) {
			System.out.println("No hay autores");
		}
	}

	private static void modificarLibros(Libro[] libros) {
		int cantidad;
		int n;
		Double precio;
		try {
			System.out.println("Ahora hay estos libros: ");
			for (int i = 0; i < Libro.getContadorLibros(); i++) {
				if (libros[i] != null) {
					System.out.println("#" + (i + 1) + "--->" + libros[i].cadenaLibroVariosAutores());
				}
			}
			n = pedirEntero("Que libro quieres modificar");
			precio = pedirDouble("Escribe su nuevo precio");
			libros[n - 1].setPrecio(precio);
			cantidad = pedirEntero("Escribe su nueva cantidad");
			libros[n - 1].setCantidad(cantidad);
		} catch (Exception e) {
			System.out.println("No has creado ningun libro todavia");
		}
	}

	private static void verLibros(Libro[] libros) {
		System.out.println("Ahora hay estos libros: ");
		for (int i = 0; i < Libro.getContadorLibros(); i++) {
			if (libros[i] != null) {
				System.out.println(libros[i]);
			}
		}
	}

	private static void verAutores(Autor[] autores, Autor[] listaAutores) {
		System.out.println("Autor/es ultimo libro:");
		for (int i = 0; i < autores.length; i++) {
			if (autores[i] != null) {
				System.out.println(autores[i]);
			}
		}
		System.out.println("Lista:");
		for (int i = 0; i < listaAutores.length; i++) {
			if (listaAutores[i] != null) {
				System.out.println(listaAutores[i]);
			}
		}
	}

	// Metodos leer---------------
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
