public class GestionLibroAutores {
	public static void main(String[] args) {
		Libro[] libros = null;
		Autor[] autores = null;
		String  nombre = "", titulo = "";

		Integer opcion, cuantosLibros, cuantosAutores;

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

				do{
					Leer.mostrarEnPantalla("\n2- Modificar autor.\n" + "3- Modificar libro.\n" + "4- Listado de libros.\n"
							+ "5- Listado de autores.\n" + "0- Salir.");
					opcion = Leer.pedirEntero("\nElija opcion");
				}while(opcion == 1);
			}
			switch (opcion) {
			case 1: // crear los libros (y los autores)
				do{
					cuantosLibros = Leer.pedirEntero("¿Cuantos libros vamos a crear?");
				}while(cuantosLibros <=0);

				do{
					cuantosAutores = Leer.pedirEntero("¿Cuantos autores vamos a crear?");
				}while(cuantosAutores <=0);

				libros = crearVectorLibros(cuantosLibros);
				autores = crearVectorAutores(cuantosAutores);
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
		int indLibro, indiceAutor, indiceTitulo, numeroAutoresLibro, cuantosAutores;
		String titulo, nombreAutor, email, genero;
		char letraGenero;
		Autor autor, autoresDeUnLibro[];
		Double precio;
		Integer cantidad;
		Boolean correcto = true; // lo usaremos para saber si podemos crear un libro
		//Creamos todos los libros
		for (indLibro = 0; indLibro < libros.length; indLibro++) {		
			// Comprobar si el libro ya esta en el vector 
			titulo = Leer.pedirCadena("Titulo del libro?");
			indiceTitulo = buscarTitulo(libros, titulo);
			while (indiceTitulo != -1) {
				titulo = Leer.pedirCadena("El libro ya existe y no se puede repetir. Titulo del libro?");
				indiceTitulo = buscarTitulo(libros, titulo);
			}
			//pedir el resto de los datos del libro
			precio = Leer.pedirDouble("Precio del libro?");
			cantidad = Leer.pedirEntero("Cantidad de libros?");

			// pedir autores, comprobar si  ya estan en el vector del main y guardarlos en el vector del libro
			do{
				cuantosAutores = Leer.pedirEntero("¿Cuantos autores tiene el libro?");
			}while(cuantosAutores <= 0 || cuantosAutores > autores.length);
			// creamos el vector de los autores de un libro. Tendrá todos los elementos a null
			autoresDeUnLibro = new Autor[cuantosAutores];
			// llenar vector de autores del objeto de clase Libro que se creará a continuación
			correcto = true;
			for (numeroAutoresLibro = 0; numeroAutoresLibro < cuantosAutores; numeroAutoresLibro++) {
				nombreAutor = Leer.pedirCadena("Nombre del autor?");

				// devuelve la posicion del nombre o la del primer elemento libre del vector general de autores
				indiceAutor = buscarAutor(autores, nombreAutor);

				if (indiceAutor == cuantosAutores) {
					// en este caso no caben más autores en el vector general de autores
					Leer.mostrarEnPantalla("No podemos dar de alta nuevos autores. No se creará el libro");
					correcto = false;
				} else {
					// el autor NO está en el vector general de autores
					if (autores[indiceAutor] == null) {
						// creamos el autor y lo guardamos en el vector
						email = Leer.pedirCadena("Email autor?");
						do {
							genero = Leer.pedirCadena("Genero autor: (m)asculino (f)emenino ?");
						} while (genero.length() > 1 || (!genero.equalsIgnoreCase("m") && !genero.equalsIgnoreCase("f")));
						letraGenero = genero.charAt(0);
						autor = new Autor(nombreAutor, email, letraGenero);
						// lo damos de alta en el vector general de autores
						autores[indiceAutor] = autor;
						// y en el vector de los autores de un libro
						autoresDeUnLibro[numeroAutoresLibro] = autor;
					} else {// el autor SI está en el vector general de autores
						autoresDeUnLibro[numeroAutoresLibro] = autores[indiceAutor];
					}
				}
			}// for autores del libro
			// Si hemos podido llenar sin problemas el vector de los autores del libro creamos el libro
			if(correcto == true){
				libros[indLibro] = new Libro(titulo, autoresDeUnLibro, precio, cantidad);
			}
		
	} // terminamos de crear todos los libros
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
