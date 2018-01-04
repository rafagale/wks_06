import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
/*
 * Primero se pedir� la fecha del d�a de hoy (d�a, mes y a�o), y la seguir�
 * pidiendo hasta que sea correcta. Luego pedir� la fecha de nacimiento de una
 * persona hasta que sea correcta. Finalmente mostrar� la fecha de nacimiento en
 * los dos formatos (getCadenaFecha1() y getCadenaFecha2()) y dir� cu�ntos a�os
 * tiene la persona. El programa se repetir� (pidiendo �nicamente la fecha de
 * nacimiento, no la de hoy) hasta que el a�o introducido sea 0.
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
			anio = pedirEntero("A�o?");
			fechaActual = new Fecha(dia, mes, anio);
		} while (!fechaActual.esCorrecta());


		System.out.println("Introduce una fecha nueva");
		do {
			dia = pedirEntero("Dia?");
			mes = pedirEntero("Mes?");
			anio = pedirEntero("A�o?");
			fechaNueva = new Fecha(dia, mes, anio);
		} while (!fechaActual.esCorrecta());
		System.out.println("La nueva fecha es " + fechaNueva.getCadenaFecha1());

		 opcion = pedirEntero(
				"Que quieres hacer?\n1-Sumar dias\n2-Saber la diferencia en dias entre este fecha y la fecha actual\n3-Calcular una edad");

		while (opcion != 0) {
			switch (opcion) {
			case 1:
				diasASumar = pedirEntero("Introduce d�as a sumar");
				System.out.println("La fecha resultante es " + fechaNueva.sumaDias(diasASumar));
				break;
			case 2:
				System.out.println(
						"La diferencia en dias entre esas fechas es de : " + fechaNueva.diferenciaFecha(fechaNueva) +" dias");
				break;
			case 3:
				do {
					System.out.println("Introduce la fecha de nacimiento de una persona");
					dia = pedirEntero("Dia?");
					mes = pedirEntero("Mes?");
					anio = pedirEntero("A�o?");
					fechaNacimiento = new Fecha(dia, mes, anio);
				} while (!fechaNacimiento.esCorrecta());
				mostrarFechaNacimiento(fechaNacimiento);
				mostrarEdad(fechaActual, fechaNacimiento);
				System.out.println("\n---------------------------------------------");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}//Switch
			opcion = pedirEntero(
					"Que quieres hacer?\n1-Sumar dias\n2-Saber la diferencia en dias entre este fecha y la fecha actual\n3-Calcular una edad");
		}//while
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

		// A�n no es el mes de su cumplea�os
		// o es el mes pero no ha llegado el d�a.
		if (meses < 0 || (meses == 0 && dias < 0)) {
			anios--;
		}
		System.out.printf("La persona tiene: %d a�os", anios);
		// System.out.printf("La persona tiene: %d a�os, %d meses y %d d�as",
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
