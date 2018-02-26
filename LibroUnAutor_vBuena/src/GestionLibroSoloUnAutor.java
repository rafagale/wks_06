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
public class GestionLibroSoloUnAutor {

	public static void main(String[] args) {
		int opcion, maxAutores, maxLibros;

		maxAutores = Leer.pedirEntero("Cuantos autores?");
		maxLibros = Leer.pedirEntero("Libros maximos?");

		Libro[] libros = new Libro[maxLibros];
		Autor[] autor = new Autor[maxAutores];
		System.out.println("Hay " + maxLibros + " libros");
		opcion = Leer.pedirEntero(
				"1-Crear libro\n2-Modificar autores\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Crear libros
				break;
			case 2: // Modificar autores
				modificarAutores(listaAutores);s
				break;
			case 3: // Modificar libro
				modificarLibros(libros);
				break;
			case 4: // Ver libros
				verLibros(libros);
				break;
			case 5:// Ver autores
				verAutores(autor, listaAutores);
				break;
			default:
				System.out.println("Elige una opcion correcta");
			}// switch
			opcion = Leer.pedirEntero(
					"1-Crear libro\n2-Modificar autores\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		} // while
	}// main

	private static void crearLibro(Libro[] libros, Autor autor) {
		int cantidad;
		Double precio;
		String titulo;
		titulo = pedirTitulo(libros);
		precio = pedirDouble("Introduce el precio del libro");
		cantidad = pedirEntero("Cantidad de libros a crear?");
		libros[Libro.getContadorLibros()] = new Libro(titulo, autor, precio, cantidad);
		System.out.println("Libro #" + Libro.getContadorLibros() + " creado");
	}

	private static String pedirTitulo(Libro[] libros) {
		String titulo;
		if (Libro.getContadorLibros() > 0) {
			titulo = Leer.pedirCadena("Introduce el titulo del libro");
			while (existeTitulo(libros, titulo)) {
				titulo = Leer.pedirCadena("Introduce un titulo nuevo");
			}
		} else {
			titulo = Leer.pedirCadena("Introduce el titulo del libro");
		}
		return titulo;
	}

	private static boolean existeTitulo(Libro[] libros, String titulo) {
		boolean existe = false;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null) {
				if (libros[i].getTitulo().equals(titulo)) {
					existe = true;
				}
			}
		}
		return existe;
	}

	private static Autor[] crearAutores(Autor[] listaAutores) {
		Autor[] autores;
		int numeroAutores;
		String nombre;
		String email;
		String genero;
		int indiceAutor;
		numeroAutores = Leer.pedirEntero("Cuantos autores va a tener este libro?");
		autores = new Autor[numeroAutores];
		for (int i = 0; i < autores.length; i++) {
			nombre = Leer.pedirCadena("Nombre autor");
			email = Leer.pedirCadena("Email autor");
			genero = pedirGenero();
			autores[i] = new Autor(nombre, email, genero);
			// Guardar los autores en un otro array
			listaAutores[Autor.getContadorAutores()] = autores[i];
		}
		System.out.println("Contador de autores = " + Autor.getContadorAutores());
		return autores;
	}

	private static String pedirGenero() {
		String genero;
		do {
			genero = Leer.pedirCadena("Genero(hombre/mujer)");
		} while (!genero.toLowerCase().equals("hombre") && !genero.toLowerCase().equals("mujer"));
		return genero;
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
		n = Leer.pedirEntero("Selecciona su numero");
		modificacion = Leer.pedirCadena("Email");
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
					System.out.println("#" + (i + 1) + "--->" + libros[i].cadenaLibro());
				}
			}
			n = Leer.pedirEntero("Que libro quieres modificar");
			precio = Leer.pedirDouble("Escribe su nuevo precio");
			libros[n - 1].setPrecio(precio);
			cantidad = Leer.pedirEntero("Escribe su nueva cantidad");
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

}// Class