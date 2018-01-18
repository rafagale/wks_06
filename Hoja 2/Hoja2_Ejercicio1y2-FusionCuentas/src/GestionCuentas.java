import java.util.Scanner;

public class GestionCuentas {

	public static void main(String[] args) {
		int opcion, n, a, b;
		double dineroInicial, dinero;
		String nombreCliente;
		// Maximo de 10 cuentas (todas null)
		CuentaCorriente[] cuentas = new CuentaCorriente[10];
		System.out.println("El banco tiene capacidad para 10 cuentas tanto abiertas como cerradas\n");
		opcion = pedirEntero("1-Crear una cuenta\n2-Fusionar dos cuentas\n3-Ingresar\n4-Retirar\n5-Visualizar");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Crear cuenta
				if (CuentaCorriente.getTotalCuentasAbiertas() == 10) {
					System.out.println("Limite de cuentas alcanzado");
				} else {
					dineroInicial = pedirDouble("Saldo inicial ");
					nombreCliente = pedirString("Nombre del cliente ");
					// La primera cuenta va en el indice 0
					cuentas[CuentaCorriente.getTotalCuentasCreadas()] = new CuentaCorriente(dineroInicial,
							nombreCliente);
				}
				mostrarInfo();
				break;
			case 2: // fusionar cuenta
				System.out.println("Qué cuentas quieres fusionar?");
				a = pedirEntero("Introduce la primera cuenta");
				b = pedirEntero("Introduce la segunda cuenta");
				try {
					if (cuentas[a - 1].getNombreCuenta().indexOf("CERRADA") == -1
							|| cuentas[b - 1].getNombreCuenta().indexOf("CERRADA") == -1) {
						cuentas[CuentaCorriente.getTotalCuentasCreadas()] = CuentaCorriente.fusiona(cuentas[a - 1],
								cuentas[b - 1]);
						mostrarInfo();
					} else {
						System.out.println("Una o varias de las cuentas que intentas fusionar estan cerradas");
					}
				} catch (NullPointerException e) {
					System.out.println("No existen esas cuentas");
					System.out.println(e);
				}

				break;
			case 3: // Ingresar
				n = pedirEntero("Introduce la cuenta en la que quieres ingresas dinero");
				if (cuentas[n - 1].getNombreCuenta().indexOf("CERRADA") == -1) {
					dinero = pedirDouble("Introduce la cantidad a ingresar");
					cuentas[n - 1].ingresaEfectivo(dinero);
					System.out.println("Se ha ingresado " + dinero + "€ en la cuenta");
				} else {
					System.out.println("La cuenta esta cerrada");
				}
				break;
			case 4: // Retirar
				n = pedirEntero("Introduce la cuenta en la que quieres retirar dinero");
				if (cuentas[n - 1].getNombreCuenta().indexOf("CERRADA") == -1) {
					dinero = pedirDouble("Introduce la cantidad a retirar");
					if (cuentas[n - 1].retiraEfectivo(dinero)) {
						System.out.println("Se ha retirado " + dinero + "€ en la cuenta");
					} else {
						System.out.println("No hay tanto dinero en la cuenta");
						System.out.println(
								"Tienes" + cuentas[n - 1].getSaldo() + "€ y estas intentando sacar " + dinero + "€");
					}
				} else {
					System.out.println("La cuenta esta cerrada");
				}
				break;
			case 5:
				for (int i = 0; i < cuentas.length; i++) {
					if (cuentas[i] != null) {
						System.out.println((cuentas[i]));
					} else {
						System.out.println("Reservado #" + (i + 1));
					}
				}
				mostrarInfo();
				break;
			case 6: // Cerrar
				n = pedirEntero("Introduce la cuenta que quieras cerrar");
				if (cuentas[n - 1].getNombreCuenta().indexOf("CERRADA") == -1) {
					cuentas[n - 1].cerrarCuenta();
					System.out.println("Cuenta cerrada");
				} else {
					System.out.println("La cuenta ya esta cerrada");
				}
				break;
			default:
				mostrarBillete();
				System.out.println("Elige una opcion correcta");
			}// switch
			opcion = pedirEntero(
					"1-Crear una cuenta\n2-Fusionar dos cuentas\n3-Ingresar\n4-Retirar\n5-Visualizar\n6-Cerrar una cuenta");
		} // while

	}// main

	/**
	 * 
	 */
	public static void mostrarInfo() {
		System.out.println("Cuentas creadas: " + CuentaCorriente.getTotalCuentasCreadas());
		System.out
				.println("Ahora hay " + (CuentaCorriente.getTotalCuentasAbiertas() - 1) + " cuentas abiertas/activas");
	}

	public static double pedirDouble(String mensaje) {
		Double num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextDouble();
		return num;
	}// Pedir double

	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextInt();
		return num;
	}// Pedir int

	public static String pedirString(String mensaje) {
		String s1;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		s1 = sc.nextLine();
		return s1;
	}// Pedir string

	public static void mostrarBillete() {
		System.out.println("XXXXXXXXXXXXXXXXXXFEDERAL RESERVE NOTEXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXX  XX       THE UNITED STATES OF AMERICA        XXX  XX");
		System.out.println("XXXX XX  -------       ------------               XXXX XX");
		System.out.println("XXXX XX              /   jJ===-\\    \\      C7675  XXXX XX");
		System.out.println("XXXXXX     OOO      /   jJ - -  L    \\      ---    XXXXXX");
		System.out.println("XXXXX     OOOOO     |   JJ  |   X    |       __     XXXXX");
		System.out.println("XXX    3   OOO      |   JJ ---  X    |      OOOO    3 XXX");
		System.out.println("XXX                 |   J|\\    /|    |     OOOOOO     XXX");
		System.out.println("XXX     C36799887   |   /  |  |  \\   |      OOOO      XXX");
		System.out.println("XXX                 |  |          |  |       --       XXX");
		System.out.println("XXX      -------    \\ /            \\ /                XXX");
		System.out.println("X  XX                \\ ____________ /               X  XX");
		System.out.println("XX XXX 3_________        --------  ___   _______ 3 XXX XX");
		System.out.println("XX XXX            ___   ONE DOLLAR  i              XXX XX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}// Billetico

}// Class