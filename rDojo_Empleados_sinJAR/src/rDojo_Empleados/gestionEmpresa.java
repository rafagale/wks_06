package rDojo_Empleados;

import java.util.Random;


public class gestionEmpresa {

	public static void main(String[] args) {
		int opcion, n, contadorEmp = 0, suJefe;

		Float nomina = 0f;
		Empleado[] currantes = new Empleado[20];
		String nombres[] = { "Pepe", "Juan", "Amancio", "Mariano", "Soraya", "Esperanza", "Francisco", "Lucia" };
		String especialidad[] = { "Enterrador", "Peluqueria", "Adiestrador de tortugas", "Calentar el cafe", "Dormir",
				"Comer", "Pilotar kazas" };
		String departamentos[] = { "Ventas", "Marketing", "Ventas caras", "Marketing barato" };
		Random rand = new Random();

		// Fechas
		Fecha fechaActual = new Fecha(21, 2, 2018);
		Fecha fechaNacimiento = new Fecha(rand.nextInt(29) + 1, rand.nextInt(11) + 1,
				rand.nextInt(1990 - 1980 + 1) + 1980);
		Fecha fechaIngreso = new Fecha(rand.nextInt(29) + 1, rand.nextInt(11) + 1,
				rand.nextInt(2000 - 1995 + 1) + 1995);

		crearUnosTrabajadores(currantes, nombres, especialidad, departamentos, rand, fechaNacimiento, fechaIngreso,
				contadorEmp);
		System.out.println(Empleado.getSiguiente());
		contadorEmp = Empleado.getSiguiente();
		opcion = Leer.pedirEntero(
				"1-Crear administrativo\n2-Crear responsable \n3-Crear tenico\n4-Listar la plantilla\n5-Calcular la nomina de la plantilla\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				for (int j = 0; j < currantes.length; j++) {
					if (currantes[j] instanceof Responsable) {
						System.out.println("# " + j + currantes[j]);
					}
				}
				suJefe = Leer.pedirEntero("Elige su jefe");
				currantes[contadorEmp] = new Administrativo(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
						rand.nextInt(30) + 25, fechaIngreso, departamentos[rand.nextInt(departamentos.length)],
						(Responsable) currantes[suJefe]);
				System.out.println("Administrativo #" + Empleado.getSiguiente() + " creado");
				contadorEmp++;

				break;
			case 2:
				currantes[contadorEmp] = new Responsable(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
						rand.nextInt(30) + 25, fechaIngreso, (float) (rand.nextInt(201) + 50),
						departamentos[rand.nextInt(departamentos.length)]);
				System.out.println("Responsable #" + Empleado.getSiguiente() + " creado");
				contadorEmp++;
				break;
			case 3:
				for (int j = 0; j < currantes.length; j++) {
					if (currantes[j] instanceof Responsable) {
						System.out.println("# " + j + currantes[j]);
					}
				}
					suJefe = Leer.pedirEntero("Elige su jefe");
					currantes[contadorEmp] = new Tecnico(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
							rand.nextInt(30) + 25, fechaIngreso, especialidad[rand.nextInt(especialidad.length)],
							(float) (rand.nextInt(201) + 50), (Responsable) currantes[suJefe]);
					System.out.println("Tecnico #" + Empleado.getSiguiente() + " creado");
					contadorEmp++;
				
				break;
			case 4:
				for (int i = 0; i < currantes.length; i++) {
					if (currantes[i] != null) {
						System.out.print(currantes[i]);
						System.out.print(" " + currantes[i].edadEmpleado(fechaNacimiento) + " a�os");
						System.out.println();
					}
				}
				break;
			case 5:
				for (int i = 0; i < currantes.length; i++) {
					if (currantes[i] != null) {
						System.out.print(currantes[i]);
						System.out.println(" " + currantes[i].calculoNomina() + "�");
						// por separado
						nomina += currantes[i].calculoNomina();
					}
				}
				System.out.println();
				System.out.println("El total es de " + nomina + "�");
				System.out.println();
				break;
			}
			opcion = Leer.pedirEntero(
					"1-Crear administrativo\n2-Crear responsable \n3-Crear tenico\n4-Listar la plantilla\n5-Calcular la nomina de la plantilla\n0-Salir");
		}

	}// main

	public static void crearUnosTrabajadores(Empleado[] currantes, String[] nombres, String[] especialidad,
			String[] departamentos, Random rand, Fecha fechaNacimiento, Fecha fechaIngreso, int contadorEmp) {
		for (int i = 0; i < 2; i++) {
			currantes[i] = new Responsable(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
					rand.nextInt(30) + 25, fechaIngreso, (float) (rand.nextInt(201) + 50),
					departamentos[rand.nextInt(departamentos.length)]);
			contadorEmp++;
		}

		for (int i = 2; i < 5; i++) {
			currantes[i] = new Administrativo(nombres[rand.nextInt(nombres.length)], fechaNacimiento,
					rand.nextInt(30) + 25, fechaIngreso, departamentos[rand.nextInt(departamentos.length)],
					(Responsable) currantes[0]);
			contadorEmp++;
		}

		for (int i = 5; i < 9; i++) {

			currantes[i] = new Tecnico(nombres[rand.nextInt(nombres.length)], fechaNacimiento, rand.nextInt(30) + 25,
					fechaIngreso, especialidad[rand.nextInt(especialidad.length)], (float) (rand.nextInt(201) + 50),
					(Responsable) currantes[1]);
			contadorEmp++;

		}
	}// crearEmps

}// Class
