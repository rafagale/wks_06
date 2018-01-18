import java.util.*;

public class GestionLibroAutor {
	/*
	 * static Autor autores[] = new Autor[10]; static Libro libros[] = new
	 * Libro[10];
	 */

	public static void main(String[] args) {
		Autor autores[] = new Autor[10];
		Libro libros[] = new Libro[10];
		Scanner tcl = new Scanner(System.in);
		boolean fin = false;
		int cuantosLibros = 0, queLibro = 0;
		int opcion, k;

		// TODO Auto-generated method stub
		do {
			System.out.println("------- INICIO DEL Programa -------");
			System.out.println("-------  Bienvenido a la Libreria  -------");
			System.out.println("------- 1. Crear Libros -------");
			System.out.println("------- 2. Modificar autor  -------");
			System.out.println("------- 3. Modificar libro  -------");
			System.out.println("------- 4. Listado de libros  -------");
			System.out.println("------- 5. Listado de autores  -------");
			System.out.println("------- 0. Salir  -------");
			opcion = Leer.pedirEntero("------- Escoja la opcion deseada -------");
			switch (opcion) {
			case 1:
				cuantosLibros = Leer.pedirEntero("¿Cuantos libros quieres crear?");
				if (cuantosLibros >= libros.length) {
					System.out.println("Error:solo se pueden crear 10 libros");
				} else {
					int contador = 0;
					while (libros[contador] != null) {
						contador++;
					}
					for (k = contador; k < libros.length && k < (cuantosLibros + contador); k++) {
						crearLibro(libros, autores, k);
					}
				}

				break;
			case 2:
				if (cuantosLibros != 0) {
					Leer.mostrarEnPantalla("Has creado" + cuantosLibros + "Libros");
					queLibro = Leer.pedirEntero("¿Que libro quieres modificar?");
					while (queLibro > cuantosLibros) {
						System.out.println("Error: Lo siento no ha introducido tantos libros");
						queLibro = Leer.pedirEntero("¿Que libro quieres modificar?");
					}
					System.out.println("El libro es :");
					System.out.println(libros[queLibro - 1].candenaLibro());
					autores[queLibro - 1].setNombre(Leer.pedirCadena("Introduce el nuevo nombre"));
					autores[queLibro - 1].setEmail(Leer.pedirCadena("Introduce el nuevo email"));
				} else {
					Leer.mostrarEnPantalla("Error: No has introducido ningun libro");
				}
				break;
			case 3:
				if (cuantosLibros != 0) {
					Leer.mostrarEnPantalla("Has creado " + cuantosLibros + " Libros");
					queLibro = Leer.pedirEntero("¿Que libro quieres modificar?");
					while (queLibro > cuantosLibros) {
						System.out.println("Error: Lo siento no ha introducido tantos libros");
						queLibro = Leer.pedirEntero("¿Que libro quieres modificar?");
					}
					System.out.println("El libro es :");
					System.out.println(libros[queLibro - 1].candenaLibro());
					libros[queLibro - 1].setTitulo(Leer.pedirCadena("Introduce el nuevo Titulo"));
					libros[queLibro - 1].setPrecio((double) Leer.pedirFloat("Introduce el nuevo precio"));
					libros[queLibro - 1].setCantidad(Leer.pedirEntero("Introduce la nueva cantidad"));
				} else {
					Leer.mostrarEnPantalla("Error: No has introducido ningun libro");
				}
				break;
			case 4:
				System.out.println("El listado de libros actuales es:");
				for (int a = 0; a < libros.length && libros[a] != null; a++) {
					System.out.println(libros[a].candenaLibro());
					System.out.println();
				}
				break;
			case 5:
				System.out.println("El listado de autores actuales es:");
				for (int a = 0; a < autores.length && autores[a] != null; a++) {
					System.out.println(autores[a].cadenaAutor());
				}
			case 0:
				fin = true;
				break;
			default:
				break;
			}
		} while (fin == false);

	}

	static public void crearLibro(Libro libros[], Autor autores[], int y) {
		String titulo = "", nombre = "", email = "", genero = "";
		Integer cantidad;
		Double precio;

		titulo = Leer.pedirCadena("Introduce el titulo");
		precio = (double) Leer.pedirFloat("Introduce el precio");
		cantidad = Leer.pedirEntero("Introduce la cantidad");
		nombre = Leer.pedirCadena("Introduce el nombre del autor");
		if (comprobarAutor(nombre,autores)!=-1){
			Libro libro = new Libro(titulo, autores[comprobarAutor(nombre,autores)], precio, cantidad);
			libros[y] = libro;
		} else{
			email = Leer.pedirCadena("Introduce el email del autor");
			genero = Leer.pedirCadena("Introduce el genero del autor");
			genero = genero.toLowerCase();
			while (genero.charAt(0) != 'f' && genero.charAt(0) != 'm') {
				System.out.println("El genero es incompatible");
				genero = Leer.pedirCadena("Introduce el genero del autor");
			}
			Autor autorLibro = new Autor(nombre, email, genero);
			//Hay que insertar el autor en el vector de autores 
			Libro libro = new Libro(titulo, autorLibro, precio, cantidad);
			libros[y] = libro;
			autores[y] = autorLibro;
		}
		
		

	}

	static public Integer comprobarAutor(String nombre, Autor autores[]) {
		int posicion = 0;
		int k = 0;
		for (k = 0; k < autores.length && autores[k] != null && autores[k].getNombre().equals(nombre) == false; k++) {

		}
		if (k < autores.length) {
			posicion = k - 1;
		}
		return posicion;
	}
}
