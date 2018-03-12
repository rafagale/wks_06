import java.util.Random;

/**
 * @author Rafa
 * @category Ejercicio Almacen con muebles
 */
public class GestionMueble {

	public static void main(String[] args) {
		// Crear referencias a objetos
		Almacen[] almacen = new Almacen[4];
		Mueble[] muebles = new Mueble[15];

		// Se crean primero los muebles y los almacenes en el mismo metodo
		crearMueblesyAlmacenes(almacen, muebles);

		// Se muestran los muebles y los almacenes creados
		System.out.println("--------------------------\nMuebles:\n--------------------------");
		mostrarMuebles(muebles);
		System.out.println("--------------------------\nAlmacenes:\n--------------------------");
		mostrarAlmacenes(almacen);

		// Se muestra la informacion de cada almacen con la relacion de muebles
		// que guardan cada uno
		System.out.println("--------------------------\nAlmacenes y sus muebles:\n--------------------------");
		mostrarInfoTotalAlmacenes(almacen);

	}// main

	private static void mostrarInfoTotalAlmacenes(Almacen[] almacen) {
		for (int i = 0; i < almacen.length; i++) {
			System.out.println("Almacen #" + (i + 1) + almacen[i].verInfoTotal());
		}
	}// mostrarInfoTotalAlmacenes

	private static void mostrarAlmacenes(Almacen[] almacen) {
		for (int i = 0; i < almacen.length; i++) {
			System.out.println("Almacen #" + (i + 1) + almacen[i].muestraAlmacen());
		}
	}// mostrarAlmacenes

	private static void mostrarMuebles(Mueble[] muebles) {
		for (int i = 0; i < muebles.length; i++) {
			System.out.println("Mueble #" + (i + 1) + muebles[i].muestraMueble());
		}
	}// mostrarMuebles

	public static void crearMueblesyAlmacenes(Almacen[] almacen, Mueble[] muebles) {
		Random rand = new Random();
		String[] descripciones = { "Muy clasico", "Antiguo", "Para el salon", "Del Ikea", "Para mansiones",
				"Sin descipcion" };
		String[] nombresAlm = { "Pikolin", "Endesa", "Fenosa", "Taller de Pepe", "Charcuteria Lola" };
		String[] direccionAlm = { "Plaza Espana", "Poligono malpika", "Calle Bsreton", "Calle de la amargura",
				"Via hispanidad" };
		// Primero se crean 15 muebles para poder asignarle los muebles
		// posteriormente a los almacenes
		for (int i = 0; i < 15; i++) {
			muebles[i] = new Mueble(descripciones[rand.nextInt(descripciones.length)], rand.nextInt(50 - 20 + 1) + 20,
					rand.nextInt(50 - 20 + 1) + 20, rand.nextInt(50 - 20 + 1) + 20);
		}
		// Se crean los almacenes
		for (int i = 0; i < 4; i++) {
			almacen[i] = new Almacen(nombresAlm[rand.nextInt(nombresAlm.length)],
					direccionAlm[rand.nextInt(direccionAlm.length)], muebles);
		}
	}// crearAlmacenesyMuebles

}// Class
