import java.util.*;

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
		int dia, mes, anio;
		Fecha fechaActual, fechaNacimiento;
		System.out.println("Introduce la fecha de hoy");
		do {
			dia = pedirEntero("Dia?");
			mes = pedirEntero("Mes?");
			anio = pedirEntero("Año?");
			fechaActual = new Fecha(dia, mes, anio);
		} while (!fechaActual.esCorrecta());

		while (anio != 0) {
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
		System.out.printf("La persona tiene: %d años, %d meses y %d días",
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
