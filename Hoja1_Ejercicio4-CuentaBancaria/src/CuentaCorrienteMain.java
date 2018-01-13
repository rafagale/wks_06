import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorrienteMain {

	public static void main(String[] args) {
		double dinero;
		int opcion;
		CuentaCorriente cuentaNueva1, cuentaNueva2;
		cuentaNueva1 = new CuentaCorriente("001", 99999999.0, "Amancio Ortega");
		cuentaNueva2 = new CuentaCorriente("002", 2.0, "Rafa");
		opcion = pedirEntero(
				"1-Ingresar en la cuenta 001\n2-Ingresar en la cuenta 002\n3-Retirar de la cuenta 001\n4-Retirar de la cuenta 002\n5-Visualizar");
		opcion = menu(opcion, cuentaNueva1, cuentaNueva2);
		
	}// main

	/**
	 * 
	 * @param opcion
	 * @param cuentaNueva1
	 * @param cuentaNueva2
	 * @return
	 */
	public static int menu(int opcion, CuentaCorriente cuentaNueva1, CuentaCorriente cuentaNueva2) {
		double dinero;
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Ingresar en la cuenta 001
				dinero = pedirDouble("Introduce la cantidad a ingresar");
				cuentaNueva1.ingresaEfectivo(dinero);
				System.out.println("Se ha ingresado " + dinero + "€ en la cuenta");
				break;
			case 2: // Ingresar en la cuenta 002
				dinero = pedirDouble("Introduce la cantidad a ingresar");
				cuentaNueva2.ingresaEfectivo(dinero);
				System.out.println("Se ha ingresado " + dinero + "€ en la cuenta");
				break;
			case 3:// Retirar en la cuenta 001
				dinero = pedirDouble("Introduce la cantidad a retirar");
				if (cuentaNueva1.retiraEfectivo(dinero)) {
					System.out.println("Se ha retirado " + dinero + "€ en la cuenta");
				} else {
					System.out.println("No hay tanto dinero en la cuenta");
					System.out.println("Tienes" +cuentaNueva1.getSaldo() +"€ y estas intentando sacar " +dinero +"€");
				}
				break;
			case 4:// Retirar en la cuenta 002
				dinero = pedirDouble("Introduce la cantidad a retirar");
				if (cuentaNueva2.retiraEfectivo(dinero)) {
					System.out.println("Se ha retirado " + dinero + "€ en la cuenta");
				} else {
					System.out.println("No hay tanto dinero en la cuenta");
					System.out.println("Tienes" +cuentaNueva2.getSaldo() +"€ y estas intentando sacar " +dinero +"€");
				}
				break;
			case 5: // Visualizar ambas cuentas
				mostrarBillete();
				System.out.println(cuentaNueva1);
				System.out.println(cuentaNueva2);
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
			opcion = pedirEntero(
					"1-Ingresar en la cuenta 001\n2-Ingresar en la cuenta 002\n3-Retirar de la cuenta 001\n4-Retirar de la cuenta 002\n5-Visualizar");
		}
		return opcion;
	}

	public static int pedirEntero(String mensaje) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextInt();
		return num;
	}// Pedir int

	public static double pedirDouble(String mensaje) {
		double num;
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		num = sc.nextDouble();
		return num;
	}// Pedir double
	
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
	}

}// Class
