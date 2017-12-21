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
		Fecha nuevaFecha, nuevaFecha2;
		System.out.println("Introduce la fecha de hoy");
		do {
			dia = pedirEntero("Dia?");
			mes = pedirEntero("Mes?");
			anio = pedirEntero("A�o?");
			nuevaFecha = new Fecha(dia, mes, anio);
		} while (!nuevaFecha.esCorrecta());
		
		
		while (anio != 0) {
			do {
				System.out.println("Introduce la fecha de nacimiento de una persona");
				dia = pedirEntero("Dia?");
				mes = pedirEntero("Mes?");
				anio = pedirEntero("A�o?");
				nuevaFecha2 = new Fecha(dia, mes, anio);
			} while (!nuevaFecha2.esCorrecta());
			System.out.println(nuevaFecha2.getCadenaFecha1());
			System.out.println(nuevaFecha2.getCadenaFecha2());
			System.out.println("La persona tiene: " + (nuevaFecha.getAnio() - nuevaFecha2.getAnio()) + " a�os");
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
