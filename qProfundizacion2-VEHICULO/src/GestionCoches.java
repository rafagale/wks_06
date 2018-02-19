import java.util.Arrays;
import java.util.Random;

public class GestionCoches {

	public static void main(String[] args) {
		Integer n, opcion, numeroLineas;

		do {
			n = Teclado.pedirEntero("Cuantos coches quieres crear?");
		} while (n > 5000);

		Automovil coches[] = new Automovil[n];
		creaCoches(coches);

		numeroLineas = Teclado.pedirEntero("Cada cuantas lineas quieres paginar?");
		System.out.println("Por qué atributo quieres ordenar la lista?");
		opcion = Teclado.pedirEntero("1-Marca\n2-Modelo\n3-Cilindrada\n4-Precio\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				Arrays.sort(coches, new OrdenPorMarca());
				listar(coches, numeroLineas);
				break;
			case 2:
				Arrays.sort(coches, new OrdenPorModelo());
				listar(coches, numeroLineas);
				break;
			case 3:
				Arrays.sort(coches, new OrdenPorCilindrada());
				listar(coches, numeroLineas);
				break;
			case 4:
				Arrays.sort(coches, new OrdenPorPrecio());
				listar(coches, numeroLineas);
			}// switch
			opcion = Teclado.pedirEntero("1-Marca\n2-Modelo\n3-Cilindrada\n4-Precio\n0-Salir");
		} // while

/*		coches = creaCoches(n);
		listar(coches, numeroLineas);*/
		
	}// main

	public static void creaCoches(Automovil[] automoviles) {
		String[] marca = { "Audi", "BMW", "Seat", "Volvo", "Tata", "Lolo" };
		String[] modelos = { "M1", "M2", "Toledo", "M4", "M5", "A1" };
		Random azar = new Random();

		// Creacion de automoviles
		for (int i = 0; i < automoviles.length; i++) {
			automoviles[i] = new Automovil(marca[azar.nextInt(marca.length)], modelos[azar.nextInt(modelos.length)],
					azar.nextInt(2001) + 1000, azar.nextInt(20001) + 10000);
		}
	}// crearCoches

	public static Automovil[] creaCoches(Integer numero) {
		Automovil coches[] = new Automovil[numero];
		String[] marca = { "Audi", "BMW", "Seat", "Volvo", "Tata", "Lolo" };
		String[] modelos = { "M1", "M2", "Toledo", "M4", "M5", "A1" };
		Random azar = new Random();

		// Creacion de automoviles
		for (int i = 0; i < coches.length; i++) {
			coches[i] = new Automovil(marca[azar.nextInt(marca.length)], modelos[azar.nextInt(modelos.length)],
					azar.nextInt(2001) + 1000, azar.nextInt(20001) + 10000);
		}
		return coches;
	}// crearCoches

	static public void listar(Automovil automoviles[], int numLineas) {
		int t;
		for (t = 0; t < automoviles.length; t++) {
			if (t > 0 && t % numLineas == 0) {
				Teclado.pedirString("Pulsa intro");
			}
			System.out.println(automoviles[t].visualizar());
		}
	}// listar

}// Class
