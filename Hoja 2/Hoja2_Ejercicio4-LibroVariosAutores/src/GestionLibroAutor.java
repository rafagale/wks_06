import java.util.Scanner;

public class GestionLibroAutor {

	public static void main(String[] args) {
		int opcion, cantidad, n, m;
		String modificacion;
		Double precio;
		String libro, titulo;
		String[] nombres = { "Arturo Perez-Reverte", "Echenique", "Adolf", "Rosa Diez" };
		String[] emails = { "cuñao@vox.es", "voyenmoto@sillaruedas.com", "III_Reich@germany.com","rosita_69@hotmail.es" };
		String[] titulos = { "Soy muy culto", "De 0 a 100km/h en 3s", "Mein Kampf", "Aprende a leer con Teo"," Caligrafia Santillana", "El futuro de nuestra mente", "Breve historia de mi vida","El bonobo y los diez mandamientos", "La cuenta atrás", "El sello indeleble" };
		Double[] precios = { 500.0, 50.0, 14.88, 0.20, 61.1, 25.5, 555.5, 99.99, 88.88, 44.44 };
		String[] generos = { "hombre", "mujer" };

		Libro[] arrayLibros = new Libro[10];
		Autor[][] arrayAutores = new Autor[4][2];

		// Matriz de autores
		for (int i = 0; i < arrayAutores.length; i++) {
			for (int j = 0; j < 2; j++) {
				arrayAutores[i][j] = new Autor(nombres[(int) Math.floor(Math.random() * 4)], emails[(int) Math.floor(Math.random() * 4)], generos[(int) Math.floor(Math.random() * 2)]);	
			}
		}
		
		
		System.out.println("Hay 10 libros");
		opcion = pedirEntero("1-Crear libro\n2-Modificar autor\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		while (opcion != 0) {
			int numRandom4 = (int) Math.floor(Math.random() * 4);
			int numRandom10 = (int) Math.floor(Math.random() * 10);
			switch (opcion) {
			case 1: // Crear libros
				cantidad = pedirEntero("Cantidad de libros a crear?");
				if (Libro.getContadorLibros() == 10) {
					System.out.println("Limite de libros alcanzado");
					//Cuando hay 4 libros creados, se eligen aleatoriamente las parejas de autores
				} else if (Libro.getContadorLibros() >= 4) {
					arrayLibros[Libro.getContadorLibros()] = new Libro(titulos[Libro.getContadorLibros()],arrayAutores[numRandom4] , precios[numRandom10], cantidad);
				} else {
					arrayLibros[Libro.getContadorLibros()] = new Libro(titulos[Libro.getContadorLibros()], arrayAutores[Libro.getContadorLibros()], precios[Libro.getContadorLibros()], cantidad);
				}
				break;
			case 2:
				for (int i = 0; i < arrayAutores.length; i++) {
					for (int j = 0; j < 2; j++) {
						System.out.println("#" + (i+1) +"," +(j + 1) + "--->" + arrayAutores[i][j].cadenaAutor());
					}
				}
				n = pedirEntero("Primer identificador autor");
				m = pedirEntero("Segundo identificador autor");
				modificacion = pedirString("Escribe su nuevo correo");
				arrayAutores[n - 1][m - 1].setEmail(modificacion);

				break;
			case 3: //Modificar libro
				try {
					for (int i = 0; i < arrayLibros.length; i++) {
						if (arrayLibros[i] != null) {
							System.out.println(("#" + (i + 1) + "--->" + arrayLibros[i].cadenaLibro()));
						} else {
							System.out.println("Vacio");
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
				for (int i = 0; i < arrayLibros.length; i++) {
					if (arrayLibros[i] != null) {
						System.out.println((arrayLibros[i].cadenaLibro()));
					}
				}
				break;
			case 5:
				for (int i = 0; i < arrayAutores.length; i++) {
					System.out.println("------------Duo-----------");
					for (int j = 0; j < 2; j++) {
						System.out.println(arrayAutores[i][j]);
					}
				}
				break;

			default:
				System.out.println("Elige una opcion correcta");
			}// switch
			opcion = pedirEntero("1-Crear libros\n2-Modificar autor\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		} // while
	}// main

	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextInt();
		return num;
	}// Pedir int

	public static String pedirString(String mensaje) {
		String s1;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		s1 = sc.nextLine();
		return s1;
	}// Pedir string

	public static double pedirDouble(String mensaje) {
		Double num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextDouble();
		return num;
	}// Pedir double
}// Class
