import java.*;
import java.util.Scanner;

public class GestionLibroAutor {
	public static void main(String[] args) {
		Libro[] libros = null;
		Autor[] autores = null;
		String titulo;
		Autor autor;
		Double precio;
		Integer cantidad, opcion;

		do {
			if (libros == null) {
				opcion = Leer.pedirEntero("1- Crear libros.\n0- Salir.");
				while (opcion < 0 || opcion > 1) {
					Leer.mostrarEnPantalla("1- Crear libros.\n0- Salir.\nElija opcion");
					opcion = Leer.pedirEntero("\nElija opcion");
				}
			} else {
				Leer.mostrarEnPantalla("2- Modificar autor.\n" + "3- Modificar libro.\n" + "4- Listado de libros.\n"
						+ "5- Listado de autores.\n" + "0- Salir.");
				opcion = Leer.pedirEntero("\nElija opcion");
			}
			switch (opcion) {
			case 1:
				crearVectorLibros(libros, autores);
				crearLibros(libros, autores);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}

		} while (opcion != 0);

	}// main

	public static void crearVectorLibros(Libro[] libros, Autor[] autores) {
		Integer cuantosLibros;
		cuantosLibros = Leer.pedirEntero("¿Cuantos libros vamos a crear?");
		autores = new Autor[cuantosLibros];
		libros = new Libro[cuantosLibros];
		// como cada libro tiene solo un autor
		// creamos un vector de autores con el mismo numero de elementos
		System.out.println(autores.toString());
		System.out.println(libros.toString());
		
	}// crearVectorLibros

	public static void crearLibros(Libro[] libros, Autor[] autores) {
		int contaLibros = 0;
		int indLibro, indTitulo, indAutor;
		String titulo, nombreAutor, email;
		String genero;
		char letraGenero;
		Autor autor;
		Double precio;
		Integer cantidad;
		Scanner sc = new Scanner(System.in);
		for (indLibro = 0; indLibro < libros.length; indLibro++) {
			titulo = Leer.pedirCadena("Titulo del libro?");
			while (existeTitulo(libros, titulo)) {
				titulo = Leer.pedirCadena("Titulo del libro?");
			}
			nombreAutor = Leer.pedirCadena("Nombre del autor?");
			indAutor = buscarAutor(autores, nombreAutor);
			precio = Leer.pedirDouble("Precio del libro?");
			cantidad = Leer.pedirEntero("Cantidad de libros?");

			if (autores[indAutor] == null) {
				// creamos el autor y lo guardamos
				// en el vector
				email = Leer.pedirCadena("Email autor?");
				genero = Leer.pedirCadena("Email autor?");
				letraGenero = genero.charAt(0);
				autor = new Autor(nombreAutor, email, genero);
				autores[indAutor] = autor;
				libros[contaLibros] = new Libro(titulo, autor, precio, cantidad);
				contaLibros++;

			} else {// al atributo autor del libro le daremos el que hemos
					// encontrado
				autor = autores[indAutor];
				libros[contaLibros] = new Libro(titulo, autor, precio, cantidad);
				contaLibros++;
			}
		} // fin for
	}// crearVectorLibros

	public static Boolean existeTitulo(Libro[] libros, String titulo) {
		int i = 0;
		Boolean encontrado = false;
		while (i < libros.length && libros[i] != null) {
			if (libros[i].getTitulo().indexOf(titulo)!=-1) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public static int buscarAutor(Autor[] autores, String nombre) {
		// devuelve la posicion del nombre o la del primer elementolibre del vector
		// de autores
		int indiceAutor = 0;
		for (int i = 0; i < autores.length; i++) {
			if (nombre.indexOf(i)!=-1) { 
				//si no está devuelve -1	
				indiceAutor=i;
			} else if (autores[i]!=null) {
				indiceAutor=i;
			}
		}
		return indiceAutor;
	}

}// class
