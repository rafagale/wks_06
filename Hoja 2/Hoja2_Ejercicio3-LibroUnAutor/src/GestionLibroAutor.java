import java.util.Scanner;

public class GestionLibroAutor {

	public static void main(String[] args) {
		int opcion, cantidad, n;
		String modificacion;
		Double precio;
		String libro, titulo;
		String[] nombres = { "Arturo Perez-Reverte", "Echenique", "Adolf", "Rosa Diez" };
		String[] emails = { "cuñao@vox.es", "voyenmoto@sillaruedas.com", "III_Reich@germany.com", "rosita_69@hotmail.es" };
		String[] titulos = { "Soy muy culto", "De 0 a 100km/h en 3s", "mein kampf", "Aprende a leer con Teo" };
		Double[] precios = { 500.0, 50.0, 14.88, 0.20 };
		String[] generos = { "hombre", "hombre", "hombre", "mujer" };

		Libro[] arrayLibros = new Libro[10];
		Autor[] autores = new Autor[4];

		//int numRandom = (int) Math.floor(Math.random() * 4);

		// Crear autores
		for (int i = 0; i < autores.length; i++) {
			autores[i] = new Autor(nombres[i], emails[i], generos[i]);
		}
		
		System.out.println("Hay 4 libros");
		opcion = pedirEntero("1-Crear libros\n2-Modificar autor\n3-Modificar libro\n4-Ver libros\n5-Ver autores\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Crear libros
				cantidad = pedirEntero("Cantidad de libros a crear?");
				if (Libro.getContadorLibros() == 4) {
					System.out.println("Limite de libros alcanzado");
				} else {
					arrayLibros[Libro.getContadorLibros()] = new Libro(titulos[Libro.getContadorLibros()], autores[Libro.getContadorLibros()], precios[Libro.getContadorLibros()], cantidad);
				}
				break;
			case 2:
				for (int i = 0; i < autores.length; i++) {
					System.out.println("#" +(i+1) +"--->" +autores[i].cadenaAutor());
				}
				n = pedirEntero("Que autor quieres modificar");
				modificacion = pedirString("Escribe su nuevo correo");
				autores[n-1].setEmail(modificacion);
				
				break;
			case 3:
				try {
					for (int i = 0; i < arrayLibros.length; i++) {
						if (arrayLibros[i] != null) {
							System.out.println(("#" +(i+1) +"--->" +arrayLibros[i].cadenaLibro()));
						} else {
							System.out.println("Vacio");
						}
					}
					n = pedirEntero("Que libro quieres modificar");
					precio = pedirDouble("Escribe su nuevo precio");
					arrayLibros[n-1].setPrecio(precio);
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
				for (int i = 0; i < autores.length; i++) {
					if (autores[i] != null) {
						System.out.println((autores[i].cadenaAutor()));
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
