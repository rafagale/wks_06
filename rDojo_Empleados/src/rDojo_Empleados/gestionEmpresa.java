package rDojo_Empleados;

import java.util.Random;

import utilidades.Fecha;
import utilidades.Leer;

public class gestionEmpresa {

	public static void main(String[] args) {
		int opcion, n;
		Empleado[] currantes = new Empleado[20];
		String nombres[] = { "Pepe", "Juan", "Amancio", "Mariano", "Soraya", "Esperanza", "Francisco", "Lucia" };
		String especialidad[] = { "Enterrador", "Peluqueria", "Adiestrador de tortugas", "Calentar el cafe", "Dormir",
				"Comer", "Pilotar kazas" };
		String departamentos[] = { "Ventas", "Marketing", "Ventas caras", "Marketing barato" };
		Random rand = new Random();

		// Fechas
		Fecha fechaNacimiento = new Fecha(rand.nextInt(15), rand.nextInt(12), rand.nextInt(2000));
		Fecha fechaIngreso = new Fecha(rand.nextInt(15), rand.nextInt(12), rand.nextInt(2000));

		crearUnosTrabajadores(currantes, nombres, especialidad, departamentos, rand, fechaNacimiento, fechaIngreso);

		opcion = Leer.pedirEntero(
				"1-Crear administrativo\n2-Crear responsable \3-Crear tenico\n4-Listar la plantilla\n5-Calcular la nomina de la plantilla\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				n = Leer.pedirEntero("Cuantos administrativos quieres crear?");
				for (int i = Empleado.getSiguiente(); i < n; i++) {

				}
				break;
			case 2:
				n = Leer.pedirEntero("Cuantos responsables quieres crear?");
				for (int i = Empleado.getSiguiente(); i < n; i++) {
					currantes[i] = new Responsable(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
							rand.nextInt(30) + 25, fechaIngreso, (float) (rand.nextInt(201) + 50),
							departamentos[rand.nextInt(departamentos.length)], rand.nextInt(2));
				}
				break;
			case 3:
				n = Leer.pedirEntero("Cuantos tecnicos quieres crear?");
				for (int i = Empleado.getSiguiente(); i < n; i++) {

				}
				break;
			case 4:
				for (int i = 0; i < currantes.length; i++) {
					System.out.println(currantes[i]);
				}
				break;
			case 5:
				Float nomina;
				for (int i = 0; i < currantes.length; i++) {
					nomina += Empleado.calculoNomina();
				}
				System.out.println(nomina);
				break;
			case 6:

				break;

			default:
				break;
			}
			opcion = Leer.pedirEntero(
					"1-Crear administrativo\n2-Crear responsable \3-Crear tenico\n4-Listar la plantilla\n5-Calcular la nomina de la plantilla\n0-Salir");

		}

	}// main

	public static void crearUnosTrabajadores(Empleado[] currantes, String[] nombres, String[] especialidad,
			String[] departamentos, Random rand, Fecha fechaNacimiento, Fecha fechaIngreso) {
		for (int i = 2; i < 5; i++) {
			currantes[i] = new Responsable(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
					rand.nextInt(30) + 25, fechaIngreso, (float) (rand.nextInt(201) + 50),
					departamentos[rand.nextInt(departamentos.length)], rand.nextInt(2));
		}

		for (int i = 0; i < 2; i++) {
			currantes[i] = new Administrativo(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
					rand.nextInt(30) + 25, fechaIngreso, departamentos[rand.nextInt(departamentos.length)],
					(Responsable) currantes[i - 2]);
		}

		for (int i = 5; i < 9; i++) {
			currantes[i] = new Tecnico(nombres[rand.nextInt(nombres.length)], fechaNacimiento, rand.nextInt(30) + 25,
					fechaIngreso, especialidad[rand.nextInt(especialidad.length)], (float) (rand.nextInt(201) + 50),
					(Responsable) currantes[i - 2]);
		}
	}

}// Class
