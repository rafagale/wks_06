import java.util.Scanner;

public class GestionCuentas {

	public static void main(String[] args) {
		int opcion, n;
		double dineroInicial;
		String nombreCliente;
		CuentaCorriente[] cuentas = new CuentaCorriente[3];
		for (int i = 0; i < cuentas.length; i++) {
			System.out.println(cuentas[i]);
		}
		for (int i = 0; i < cuentas.length; i++) {
			if (i < CuentaCorriente.getTotalCuentas() - 1) {
				System.out.println((cuentas[i]));
			}
		}
		opcion = pedirEntero("1-Crear una cuenta\n2-Fusionar dos cuentas\n3-Ingresar\n4-Retirar\n5-Visualizar");
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				if (CuentaCorriente.getTotalCuentas() == 3) {
					System.out.println("Limite de cuentas alcanzado");
				} else {
					dineroInicial = pedirDouble("Saldo inicial ");
					nombreCliente = pedirString("Nombre del cliente ");
					cuentas[CuentaCorriente.getTotalCuentas()] = new CuentaCorriente(dineroInicial, nombreCliente);
				}
				System.out.println("Hay " + (CuentaCorriente.getTotalCuentas()-1) + " cuentas abiertas");
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				for(int i=0; i<cuentas.length; i++){
					if (cuentas[i]!=null){
						System.out.println((cuentas[i]));
					}
				}
				break;
			default:
				break;

			}// switch
			opcion = pedirEntero("1-Crear una cuenta\n2-Fusionar dos cuentas\n3-Ingresar\n4-Retirar\n5-Visualizar");
		} // while

	}// main

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