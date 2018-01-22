import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Rafa
 * @see No guarda los autores, solo los del ultimo libro creado
 */
public class GestionLibroAutor2_SoloArrays {

	public static void main(String[] args) {
		int opcion, cantidad, n, numeroAutores, indiceAutores, indiceLibros;
		String modificacion;
		Double precio;
		String libro, titulo, nombre, email, genero;
		Libro[] arrayLibros = new Libro[10];
		Autor[] arrayAutores = new Autor[4];
		Autor unicoAutor = null;

		System.out.println("Hay 10 libros");
		opcion = pedirEntero(
				"1-Crear libro\n2-Modificar autores ultimo libro\n3-Modificar libro\n4-Ver libros\n5-Ver autores ultimo libro\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Crear libros
				cantidad = pedirEntero("Cantidad de libros a crear?");
				titulo = pedirString("Introduce el titulo del libro");
				precio = pedirDouble("Introduce el precio del libro");
				numeroAutores = pedirEntero("Cuantos autores va a tener este libro?");
				if (numeroAutores == 1) {
					nombre = pedirString("Nombre autor");
					email = pedirString("Email autor");
					do {
						genero = pedirString("Genero(hombre/mujer)");
					} while (!genero.toLowerCase().equals("hombre") && !genero.toLowerCase().equals("mujer"));
					unicoAutor = new Autor(nombre, email, genero);
					arrayLibros[Libro.getContadorLibros()] = new Libro(titulo, unicoAutor, precio, cantidad);
					System.out.println("Libro #" + Libro.getContadorLibros() + " creado");
					System.out.println("Contador de autores = " + Autor.getContadorAutores());
				} else {
					for (int i = 0; i < numeroAutores; i++) {
						nombre = pedirString("Nombre autor");
						email = pedirString("Email autor");
						do {
							genero = pedirString("Genero(hombre/mujer)");
						} while (!genero.toLowerCase().equals("hombre") && !genero.toLowerCase().equals("mujer"));
						arrayAutores[i] = new Autor(nombre, email, genero);
					} // for
					arrayLibros[Libro.getContadorLibros()] = new Libro(titulo, arrayAutores, precio, cantidad);
					System.out.println("Libro #" + Libro.getContadorLibros() + " creado");
					System.out.println("Contador de autores = " + Autor.getContadorAutores());
				}
				break;
			case 2:
				for (int i = 0; i < arrayAutores.length; i++) {
					if (arrayAutores[i] != null) {
						System.out.println("#" + (i + 1) + "--->" + arrayAutores[i].cadenaAutor());
						n = pedirEntero("Elige autor");
						modificacion = pedirString("Escribe su nuevo correo");
						arrayAutores[n - 1].setEmail(modificacion);
					} else if (unicoAutor!=null) {
						n = pedirEntero("Elige autor");
						modificacion = pedirString("Escribe su nuevo correo");
						unicoAutor.setEmail(modificacion);
					}
				}
				break;
			case 3: // Modificar libro
				try {
					System.out.println("Ahora hay estos libros: ");
					for (int i = 0; i < Libro.getContadorLibros(); i++) {
						if (arrayLibros[i] != null && arrayAutores[i]==null) {
							System.out.println("#" + (i + 1) + "--->" +arrayLibros[i].cadenaUnAutor());
						} else {
							System.out.println("#" + (i + 1) + "--->" +arrayLibros[i].cadenaLibroVariosAutores());
						}
					}
					n = pedirEntero("Que libro quieres modificar");
					precio = pedirDouble("Escribe su nuevo precio");
					arrayLibros[n - 1].setPrecio(precio);
					cantidad = pedirEntero("Escribe su nueva cantidad");
					arrayLibros[n - 1].setCantidad(cantidad);
				} catch (Exception e) {
					System.out.println("No has creado ningun libro todavia");
				}

				break;
			case 4:
				System.out.println("Ahora hay estos libros: ");
				for (int i = 0; i < Libro.getContadorLibros(); i++) {
					if (arrayLibros[i] != null && arrayAutores[i]==null) {
						System.out.println(arrayLibros[i].cadenaUnAutor());
					} else {
						System.out.println(arrayLibros[i].cadenaLibroVariosAutores());
					}
				}
				break;
			case 5:
				for (int i = 0; i < arrayAutores.length; i++) {
					if (arrayAutores[i] != null) {
						System.out.println(arrayAutores[i]);
					}
				}
				try {
					System.out.println(unicoAutor.cadenaAutor());
				} catch (Exception e) {
					System.out.println("no hay libros con un unico autor");
				}
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
