
public class GestionLibroAutor {
	public static void main(String[] args) {
		Libro[] libros = null;
		Autor[] autores = null;
		String  nombre = "", titulo = "";

		Integer opcion, cuantosLibros;

		do {
			if (libros == null) {
				// si los libros no se han creado, el menu solo muestra la opcion de crearlos
				opcion = Leer.pedirEntero("\n1- Crear libros.\n0- Salir.");
				while (opcion < 0 || opcion > 1) {
					Leer.mostrarEnPantalla("\n1- Crear libros.\n0- Salir.");
					opcion = Leer.pedirEntero("\nElija opcion");
				}
			} else {
				// si los libros ya se han creado, el menu NO muestra la opcion de crearlos
				Leer.mostrarEnPantalla("\n2- Modificar autor.\n" + "3- Modificar libro.\n" + "4- Listado de libros.\n"
						+ "5- Listado de autores.\n" + "0- Salir.");
				opcion = Leer.pedirEntero("\nElija opcion");
			}
			switch (opcion) {
			case 1: // crear los libros (y los autores)
				do{
					cuantosLibros = Leer.pedirEntero("¿Cuantos libros vamos a crear?");
				}while(cuantosLibros <=0);
				// como cada libro tiene solo un autor
				// creamos un vector de autores con el mismo numero de elementos
				libros = crearVectorLibros(cuantosLibros);
				autores = crearVectorAutores(cuantosLibros);
				crearLibros(libros, autores);
				break;
			case 2: // modificar autor (solo se puede modificar el email)				
				listarAutores(autores);
				nombre = Leer.pedirCadena("Nombre del autor a modificar (* para terminar)");
				while (!nombre.equals("*")) {
					modificarAutor(autores, nombre);
					nombre = Leer.pedirCadena("Nombre del autor a modificar (* para terminar)");
				}
				break;
			case 3: // modificar libro
				listarLibros(libros);
				titulo = Leer.pedirCadena("Titulo del libro a modificar (* para terminar)");
				while (!titulo.equals("*")) {
					modificarLibro(libros, titulo);
					titulo = Leer.pedirCadena("Titulo del libro a modificar (* para terminar)");
				}
				break;
			case 4: // listar libros
				listarLibros(libros);
				break;
			case 5: // listar autores
				listarAutores(autores);
				break;
			}

		} while (opcion != 0);

	}// main

	public static Libro[] crearVectorLibros(Integer cuantosLibros) {
		Libro[] libros = null;
		//libros = new Libro[cuantosLibros.intValue()];
		libros = new Libro[cuantosLibros];
		return libros;
	}// crearVectorLibros

	public static Autor[] crearVectorAutores(Integer cuantosLibros) {
		Autor[] autores = null;
		autores = new Autor[cuantosLibros.intValue()];
		return autores;
	}// crearVectorAutores

	public static void crearLibros(Libro[] libros, Autor[] autores) {
		int indLibro, indAutor, indTitulo;
		String titulo, nombreAutor, email, genero;
		char letraGenero;
		Autor autor;
		Double precio;
		Integer cantidad;
		//Creamos todos los libros
		for (indLibro = 0; indLibro < libros.length; indLibro++) {
			titulo = Leer.pedirCadena("Titulo del libro?");
			///////////////////******************************
			indTitulo = buscarTitulo(libros, titulo);
			while (indTitulo != -1) {
				titulo = Leer.pedirCadena("El libro ya existe y no se puede repetir. Titulo del libro?");
				indTitulo = buscarTitulo(libros, titulo);
			}
			///////////////////******************************
			precio = Leer.pedirDouble("Precio del libro?");
			cantidad = Leer.pedirEntero("Cantidad de libros?");

			nombreAutor = Leer.pedirCadena("Nombre del autor?");
			indAutor = buscarAutor(autores, nombreAutor);
			if (autores[indAutor] == null) {
				// creamos el autor y lo guardamos en el vector
				email = Leer.pedirCadena("Email autor?");
				do {
					genero = Leer.pedirCadena("Genero autor: (m)asculino (f)emenino ?");
				} while (genero.length() > 1 || (!genero.equalsIgnoreCase("m") && !genero.equalsIgnoreCase("f")));
				letraGenero = genero.charAt(0);
				autor = new Autor(nombreAutor, email, letraGenero);
				autores[indAutor] = autor;
				libros[indLibro] = new Libro(titulo, autor, precio, cantidad);

			} else {// al atributo autor del libro le daremos el que hemos encontrado
				autor = autores[indAutor];
				libros[indLibro] = new Libro(titulo, autor, precio, cantidad);
			}
		} // fin for
	}// crearVectorLibros

	public static Integer buscarTitulo(Libro[] libros, String titulo) {
		int i = 0, indiceLibro = -1;
		// devuelve el indice del elemento donde está ese título
		// o el valor -1 si no lo encuentra
		while (i < libros.length && libros[i] != null) {
			if (libros[i].getTitulo().equals(titulo)) {
				indiceLibro = i;
			}
			i++;
		}
		return indiceLibro;
	}

	public static int buscarAutor(Autor[] autores, String nombre) {
		// devuelve la posicion del nombre o la del primer elemento libre del vector de autores
		int i = 0, indiceAutor=0;
		Boolean encontrado = false;
		while (i < autores.length && autores[i] != null && !encontrado) {
			if (autores[i].getNombre().equals(nombre)) {
				indiceAutor = i;
				encontrado = true;
			}
			i++;
		}
		if(!encontrado){
			indiceAutor = i;
		}
		return indiceAutor;
	}

	public static void listarAutores(Autor[] autores) {
		int indiceAutor;
		Leer.mostrarEnPantalla("\nListado de autores");
		Leer.mostrarEnPantalla("-------------------");
		for (indiceAutor = 0; indiceAutor < autores.length && autores[indiceAutor] != null; indiceAutor++) {
			Leer.mostrarEnPantalla("\n" + autores[indiceAutor].cadenaAutor());
		}
		Leer.mostrarEnPantalla("------------------------------------------------------------------");
	}//listarAutores

	public static void listarLibros(Libro[] libros) {
		int indiceLibro;
		Leer.mostrarEnPantalla("\nListado de libros");
		Leer.mostrarEnPantalla("------------------");
		for (indiceLibro = 0; indiceLibro < libros.length && libros[indiceLibro] != null; indiceLibro++) {
			Leer.mostrarEnPantalla("\n" + libros[indiceLibro].cadenaLibro());
		}
		Leer.mostrarEnPantalla("------------------------------------------------------------------");
	}//listarLibros

	public static void modificarAutor(Autor [] autores, String nombre){
		Integer indiceAutor;
		String email;
		
		//posicion del autor o primer elemento null del vector de autores
		indiceAutor = buscarAutor(autores, nombre);
		if(autores[indiceAutor] != null){
			email = Leer.pedirCadena("Nuevo email?");
			autores[indiceAutor].setEmail(email);
		}else{
			Leer.mostrarEnPantalla("Error. El autor " + nombre + " no existe");
		}
	}//modificarAutor

	public static void modificarLibro(Libro [] libros, String titulo){
		//solo podemos modificar el precio y la cantidad
		Integer indiceLibro, opcion;
		Double precio;
		Integer cantidad;
		indiceLibro = buscarTitulo(libros, titulo); // -1 si no lo encuentra
		if(indiceLibro != -1){// el libro existe
			do{
				Leer.mostrarEnPantalla(libros[indiceLibro].cadenaLibro());
				Leer.mostrarEnPantalla("1. Modificar precio");
				Leer.mostrarEnPantalla("2. Modificar cantidad");
				opcion = Leer.pedirEntero("Elija opcion:");
			} while (opcion < 1 || opcion > 2);
			if(opcion == 1){
				precio = Leer.pedirDouble("Nuevo precio?");
				libros[indiceLibro].setPrecio(precio);
			}else{
				cantidad = Leer.pedirEntero("Nueva cantidad?");
				libros[indiceLibro].setCantidad(cantidad);
			}
		}else{// el libro NO existe
			Leer.mostrarEnPantalla("No existe ese titulo");
		}
	}//modificarLibro
}// class
