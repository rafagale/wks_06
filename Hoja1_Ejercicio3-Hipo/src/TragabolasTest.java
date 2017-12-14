import java.util.*;

/**
 * 
 * @author Rafa
 *
 */
public class TragabolasTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String color = "";
		int maxBolas;
		int bolasComidas = 0;
		int jugar;
		TragaBolas hipopotamo=null; 
		//hipopotamo = new TragaBolas();
		System.out.println("1-Crear Hipopotamo\n2-Comer\n3-Dormir\n4-Trotar\n5-Visualizar\n0-Salir");
		jugar = sc.nextInt();
		while (jugar != 0) {
			switch (jugar) {
			case 1:
				sc.nextLine();
				do {
					System.out.println("Color del hipopotamo?");
					color = sc.nextLine();
				} while (!color.toLowerCase().equals("verde") && !color.toLowerCase().equals("rojo")
						&& !color.toLowerCase().equals("amarillo"));
				System.out.println("Bolas máximas?");
				maxBolas = sc.nextInt();
				hipopotamo = new TragaBolas(color, bolasComidas, maxBolas); // Crear
				hipopotamo.setMaxBolas(maxBolas);// darle valores
				hipopotamo.setColor(color);
				break;
			case 2:
				if(hipopotamo!=null)
				hipopotamo.comer();
				break;
			case 3:
				System.out.println(hipopotamo.dormir());
				break;
			case 4:
				hipopotamo.trotar();
				break;
			case 5:
				hipopotamo.visualizar();
				break;
			}// Switch
			System.out.println("2-Comer\n3-Dormir\n4-Trotar\n5-Visualizar\n0-Salir");
			jugar = sc.nextInt();
		}

	}// main

}// Class
