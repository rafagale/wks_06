
public class GestionPila {

	public static void main(String[] args) {
		int opcion;
		String nombre;
		
		Pila folios = new Pila();
		
		opcion = Teclado.pedirEntero("2- Añadir elemento\n" + "3- Borrar un nombre\n" + "4- Listar todos los elementos\n"
				+ "5- Borrar todos los nombres\n" + "6- copiar la pila\n");

		while (opcion != 0) {
			switch (opcion) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
			}// switch
			opcion = Teclado.pedirEntero("2- Añadir elemento\n" + "3- Borrar un nombre\n" + "4- Listar todos los elementos\n"
					+ "5- Borrar todos los nombres\n" + "6- copiar la pila\n");
		} // while
	}// main

}// Class
