import java.util.Scanner;

/**
 * 
 * @author Rafa
 *
 */
public class TragabolasTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String color = "";
		int maxBolas = 0;
		int bolasComidas = 0;
		int jugar;
		TragaBolas hipopotamo = null;
		// hipopotamo = new TragaBolas();
		System.out.println("1-Crear Hipopotamo\n2-Comer\n3-Dormir\n4-Trotar\n5-Visualizar\n0-Salir");
		jugar = sc.nextInt();
		while (jugar != 0) {
			switch (jugar) {
			case 1:
				hipopotamo = new TragaBolas(color, maxBolas); // Crear
				dibujoHipo();
				break;
			case 2:
				System.out.println(hipopotamo.comer());
				break;
			case 3:
				System.out.println(hipopotamo.dormir());
				break;
			case 4:
				System.out.println(hipopotamo.trotar());
				break;
			case 5:
				System.out.println(hipopotamo.visualizar());
				break;
			}// Switch
			System.out.println("2-Comer\n3-Dormir\n4-Trotar\n5-Visualizar\n0-Salir");
			jugar = sc.nextInt();
		}
		
	}// main

	/**
	 * 
	 */
	public static void dibujoHipo() {
		System.out.println(",-\'\'\'\'\'-.:-^-._ ");
		System.out.println("/      \'  ( `  \\ _");
		System.out.println("\\      \\   _ .,-\'");
		System.out.println(")_|-._-._((_(");
	}

}// Class
