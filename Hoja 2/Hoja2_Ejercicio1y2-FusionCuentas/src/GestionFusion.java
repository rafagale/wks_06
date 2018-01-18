import java.util.Scanner;

public class GestionFusion {
	/*
	 * Pida al usuario tres nombres de clientes y cree una cuenta para cada uno
	 * con 100€ de saldo inicial. Muestre en pantalla los datos de las tres
	 * cuentas. Cierre la primera cuenta. Intente fusionar la segunda y la
	 * tercera cuenta en otra nueva. Imprima los datos de todas las cuentas,
	 * incluyendo la que haya resultado de la fusión en caso de que se haya
	 * podido hacer.
	 */
	public static void main(String[] args) {
		int opcion, n, a, b;
		String nombreCliente;
		CuentaCorriente[] cuentas = new CuentaCorriente[4];

		System.out.println("Introduce 3 nombres");
		// Crear 3 cuentas. iteracion=3, la 4 se omite para la fusion
		for (int i = 0; i < cuentas.length - 1; i++) {
			nombreCliente = pedirString("Nombre?");
			cuentas[i] = new CuentaCorriente(100.0, nombreCliente);

		}
		mostrarCuentas(cuentas);
		System.out.println("Se ha cerrado la primera cuenta");
		cuentas[0].cerrarCuenta();

		// Fusionar
		System.out.println("Se va a intentar fusionar la cuenta 2 y 3.....");
		cuentas[3] = CuentaCorriente.fusiona(cuentas[1], cuentas[2]);
		if (cuentas[3]==null) {
			System.out.println("Las cuentas no corresponden al mismo cliente");
		} else {
			System.out.println("Se han fusionado las cuentas 2 y 3");
		}

		// Mostrar info de todas las cuentas
		for (int i = 0; i < cuentas.length; i++) {
			if (cuentas[i] != null) {
				System.out.println((cuentas[i]));
			} else {
				System.out.println("Reservado #" + (i + 1));
			}
		}
		System.out.println("Cuentas creadas: " + CuentaCorriente.getTotalCuentasCreadas());
		System.out
				.println("Ahora hay " + (CuentaCorriente.getTotalCuentasAbiertas() - 1) + " cuentas abiertas/activas");

	}// main

	public static void mostrarCuentas(CuentaCorriente[] cuentas) {
		for (int i = 0; i < cuentas.length - 1; i++) {
			if (cuentas[i] != null) {
				System.out.println((cuentas[i]));
			} else {
				System.out.println("Reservado #" + (i + 1));
			}
		}
		System.out.println("Cuentas creadas: " + CuentaCorriente.getTotalCuentasCreadas());
		System.out
				.println("Ahora hay " + (CuentaCorriente.getTotalCuentasAbiertas() - 1) + " cuentas abiertas/activas");
	}

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

}// Class
