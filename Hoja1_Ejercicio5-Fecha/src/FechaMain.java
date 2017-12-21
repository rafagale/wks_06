import java.util.*;

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
		int dia, mes, anio;
		Fecha fechaActual, fechaNacimiento;
		System.out.println("Introduce la fecha de hoy");
		do {
			dia = pedirEntero("Dia?");
			mes = pedirEntero("Mes?");
			anio = pedirEntero("A�o?");
			fechaActual = new Fecha(dia, mes, anio);
		} while (!fechaActual.esCorrecta());

		while (anio != 0) {
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
		}

	}// main

	/**
	 * @param fechaNacimiento
	 */
	public static void mostrarFechaNacimiento(Fecha fechaNacimiento) {
		System.out.print("Fecha de nacimiento: ");
		System.out.print(fechaNacimiento.getCadenaFecha1() +" || ");
		System.out.print(fechaNacimiento.getCadenaFecha2());
		System.out.println();
	}//Mostrar fecha nacimiento

	/**
	 * @param fechaActual
	 * @param fechaNacimiento
	 */
	public static void mostrarEdad(Fecha fechaActual, Fecha fechaNacimiento) {
		System.out.printf("La persona tiene: %d a�os, %d meses y %d d�as",
				(fechaActual.getAnio() - fechaNacimiento.getAnio()), (fechaActual.getMes() - fechaNacimiento.getMes()),
				(fechaActual.getDia() - fechaNacimiento.getDia()));
	}//mostrar Edad

	/**
	 * 
	 * @param mensaje para pedir numero
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
