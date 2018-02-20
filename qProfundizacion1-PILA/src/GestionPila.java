
public class GestionPila {

	public static void main(String[] args) {
		int opcion;
		
		Pila folios = new Pila();
		Pila revistas = new Pila();
		opcion = Teclado.pedirEntero("1-Invertir la pila\n2- Añadir elemento\n" + "3- Borrar un nombre\n" + "4- Listar todos los elementos\n"
				+ "5- Borrar todos los nombres\n" + "6- copiar la pila\n");

		while (opcion != 0) {
			switch (opcion) {
			case 1: //ver la pila invertida
				if (folios.estaVacia()) {
					System.out.println("No se puede invertir, esta vacia");
				} else {
					System.out.println(folios.invertir());
				}
				break;
			case 2:
				folios.apilar();
				break;
			case 3:
				System.out.println(folios.desApilar());
				break;
			case 4:
				if (folios.estaVacia()) {
				System.out.println("Esta vacia");	
				} else {
					System.out.println(folios);
				}
				break;
			case 5:
				System.out.println(folios.borrar());
				break;
			case 6:
				folios.copiarEn(revistas);
				System.out.println("Los datos se han copiado en una pila nueva de revistas");
				System.out.println(revistas);
				break;
			default:
				break;
			}// switch
			opcion = Teclado.pedirEntero("1-Invertir la pila\n2- Añadir elemento\n" + "3- Borrar un nombre\n" + "4- Listar todos los elementos\n"
					+ "5- Borrar todos los nombres\n" + "6- copiar la pila\n");
		} // while
	}// main

}// Class
