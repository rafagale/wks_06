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
		Fecha nuevaFecha, nuevaFecha2;
		System.out.println("Introduce la fecha de hoy");
		do {
			dia = pedirEntero("Dia?");
			mes = pedirEntero("Mes?");
			anio = pedirEntero("Año?");
			nuevaFecha = new Fecha(dia, mes, anio);
		} while (!nuevaFecha.esCorrecta());
		
		
		while (anio != 0) {
			do {
				System.out.println("Introduce la fecha de nacimiento de una persona");
				dia = pedirEntero("Dia?");
				mes = pedirEntero("Mes?");
				anio = pedirEntero("Año?");
				nuevaFecha2 = new Fecha(dia, mes, anio);
			} while (!nuevaFecha2.esCorrecta());
			System.out.println(nuevaFecha2.getCadenaFecha1());
			System.out.println(nuevaFecha2.getCadenaFecha2());
			System.out.println("La persona tiene: " + (nuevaFecha.getAnio() - nuevaFecha2.getAnio()) + " años");
		}
	}// main

	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextInt();
		return num;
	}// Pedir entero
}// Class
