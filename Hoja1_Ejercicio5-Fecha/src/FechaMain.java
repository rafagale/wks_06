import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Primero se pedirá la fecha del día de hoy (día, mes y año), y la seguirá
 * pidiendo hasta que sea correcta. Luego pedirá la fecha de nacimiento de una
 * persona hasta que sea correcta. Finalmente mostrará la fecha de nacimiento en
 * los dos formatos (getCadenaFecha1() y getCadenaFecha2()) y dirá cuántos años
 * tiene la persona. El programa se repetirá (pidiendo únicamente la fecha de
 * nacimiento, no la de hoy) hasta que el año introducido sea 0.
 */

public class FechaMain {

	public static void main(String[] args) {
		int opcion;
		int dia, mes, anio;
		int diasASumar = 0;
		Fecha fechaActual, fechaNacimiento, fechaNueva;
		System.out.println("Introduce la fecha de hoy");
		do {
			dia = pedirEntero("Dia?");
			mes = pedirEntero("Mes?");
			anio = pedirEntero("Año?");
			fechaActual = new Fecha(dia, mes, anio);
		} while (!fechaActual.esCorrecta());

		opcion = pedirEntero(
				"Que quieres hacer?\n1-Sumar dias\n2-Saber la diferencia en dias entre este fecha y la fecha actual\n3-Calcular una edad");

		while (opcion != 0) {
			switch (opcion) {
			case 1:
				diasASumar = pedirEntero("Introduce días a sumar");
				System.out.println("La fecha resultante es " + fechaActual.sumaDias(diasASumar));
				break;
			case 2:
				System.out.println("Introduce una fecha nueva");
				do {
					dia = pedirEntero("Dia?");
					mes = pedirEntero("Mes?");
					anio = pedirEntero("Año?");
					fechaNueva = new Fecha(dia, mes, anio);
				} while (!fechaActual.esCorrecta());
				System.out.println("La nueva fecha es " + fechaNueva.getCadenaFecha1());
				System.out.println("La diferencia en dias entre esas fechas es de : "
						+ fechaNueva.diferenciaFecha(fechaNueva) + " dias");
				break;
			case 3:
				do {
					System.out.println("Introduce la fecha de nacimiento de una persona");
					dia = pedirEntero("Dia?");
					mes = pedirEntero("Mes?");
					anio = pedirEntero("Año?");
					fechaNacimiento = new Fecha(dia, mes, anio);
				} while (!fechaNacimiento.esCorrecta());
				mostrarFechaNacimiento(fechaNacimiento);
				mostrarEdad(fechaActual, fechaNacimiento);
				System.out.println("\n---------------------------------------------");
				break;
			default:
				System.out.println("Opcion incorrecta");
				System.out.println(fechaActual.getCadenaFecha1());
				break;
			}// Switch
			opcion = pedirEntero(
					"Que quieres hacer?\n1-Sumar dias\n2-Saber la diferencia en dias entre este fecha y la fecha actual\n3-Calcular una edad");
		} // while
	}// main

	/**
	 * @param fechaNacimiento
	 */
	public static void mostrarFechaNacimiento(Fecha fechaNacimiento) {
		System.out.print("Fecha de nacimiento: ");
		System.out.print(fechaNacimiento.getCadenaFecha1() + " || ");
		System.out.print(fechaNacimiento.getCadenaFecha2());
		System.out.println();
	}// Mostrar fecha nacimiento

	/**
	 * @param fechaActual
	 * @param fechaNacimiento
	 */
	public static void mostrarEdad(Fecha fechaActual, Fecha fechaNacimiento) {
		int anios = 0, meses = 0, dias = 0;
		dias = fechaActual.getDia() - fechaNacimiento.getDia();
		meses = fechaActual.getMes() - fechaNacimiento.getMes();
		anios = fechaActual.getAnio() - fechaNacimiento.getAnio();

		// Aún no es el mes de su cumpleaños
		// o es el mes pero no ha llegado el día.
		if (meses < 0 || (meses == 0 && dias < 0)) {
			anios--;
		}
		System.out.printf("La persona tiene: %d años", anios);
		// System.out.printf("La persona tiene: %d años, %d meses y %d días",
		// anios, meses, dias);
	}// mostrar Edad

	/**
	 * 
	 * @param mensaje
	 *            para pedir numero
	 * @return el numero introducido por teclado
	 */
	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextInt();
		return num;
	}// Pedir entero

}// Class
