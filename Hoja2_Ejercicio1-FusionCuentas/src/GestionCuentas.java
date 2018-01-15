import java.util.Scanner;

public class GestionCuentas {

	public static void main(String[] args) {
		int opcion;
		while (opcion!=0) {
			switch (opcion) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;

			default:
				break;
			}
			
			
		}

		
		
		
		
		
		

		
		
		
	}//main
	
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
	}//Billetico
	
	
	
}//Class