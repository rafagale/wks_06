import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Rafa
 * @see
 */
public class GestionLibroSoloUnAutor {

	public static void main(String[] args) {
		int opcion, maxAutores, maxLibros, numAutores = 0, numLibros = 0, contadorNoVacios = 0;
		String pregunta;
		maxAutores = Leer.pedirEntero("Autores maximos?");
		maxLibros = Leer.pedirEntero("Libros maximos?");

		String titulos[] = { "Blabla", "HArry potter", "diccionario", "periodico" };
		String nombres[] = { "Pepe", "Juan", "Amancio", "Mariano", "Soraya", "Esperanza", "Francisco", "Lucia" };

		Random rand = new Random();
		Libro[] libros = new Libro[maxLibros];
		Autor[] autores = new Autor[maxAutores];
		System.out.println("Hay " + maxLibros + " libros");

		opcion = Leer.pedirEntero(
				"1-Crear libro\n2-Modificar autores\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				// crear autores
				do {
					numAutores = Leer.pedirEntero("Cuantos autores quieres crear?");
					numAutores += Autor.getContaAutores();
				} while (numAutores > maxAutores);
				for (int i = Autor.getContaAutores(); i < numAutores; i++) {
					autores[i] = new Autor(nombres[rand.nextInt(nombres.length)],
							nombres[rand.nextInt(nombres.length)] + "@gmail.com", 'm');
				}
				pregunta = Leer.pedirCadena("Quieres crear libros?(s/n)");
				if (pregunta.equals("s")) {
					do {
						numLibros = Leer.pedirEntero("Cuantos libros quieres crear?");
						numLibros += Libro.getContadorLibros();
					} while (numLibros > maxLibros);

					for (int j = 0; j < autores.length; j++) {
						if (autores[j] != null) {
							contadorNoVacios++;
							// Caso limite
						}
					}
					System.out.println(contadorNoVacios);
					for (int i = Libro.getContadorLibros(); i < numLibros; i++) {
						libros[i] = new Libro(titulos[rand.nextInt(titulos.length)],
								autores[rand.nextInt(contadorNoVacios)], (double) (rand.nextInt(5)));
					}
				} else {
					System.out.println("Autores creados");
				}
				// crear libros
				break;
			case 2: // Modificar autores
				modificarAutores(autores);
				break;
			case 3: // Modificar libro
				modificarLibros(libros);
				break;
			case 4: // Ver libros
				for (int i = 0; i < libros.length; i++) {
					if (libros[i] != null) {
						System.out.println(libros[i].cadenaLibro());
					}
				}
				break;
			case 5:// Ver autores
				for (int i = 0; i < autores.length; i++) {
					if (autores[i] != null) {
						System.out.println(autores[i].cadenaAutor());
					}
				}
				break;
			default:
				System.out.println("Elige una opcion correcta");
			}// switch
			opcion = Leer.pedirEntero(
					"1-Crear libro\n2-Modificar autores\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		} // while
	}// main

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

	private static String pedirGenero() {
		String genero;
		do {
			genero = Leer.pedirCadena("Genero(hombre/mujer)");
		} while (!genero.toLowerCase().equals("hombre") && !genero.toLowerCase().equals("mujer"));
		return genero;
	}

	private static void modificarAutores(Autor[] autores) {
		int n;
		String modificacion;
		System.out.println("Lista:");
		for (int i = 0; i < autores.length; i++) {
			if (autores[i] != null) {
				System.out.println("#" + i + "--->" + autores[i].cadenaAutor());
			}
		}
		n = Leer.pedirEntero("Selecciona su numero");
		modificacion = Leer.pedirCadena("Email");
		try {
			autores[n].setEmail(modificacion);
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