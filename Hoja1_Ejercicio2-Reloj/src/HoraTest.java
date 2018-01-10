import java.util.Scanner;
/**
 * @author Rafa
 * @version 0.1
 */
public class HoraTest {

	public static void main(String[] args) {
		int hora = 0, minuto = 0, segundo = 0;
		int n;
		String ajustar = "";
		Hora unaHora;
		Scanner sc = new Scanner(System.in);
		unaHora = new Hora();

		System.out.println("La hora es: ");
		unaHora.verHora(hora, minuto, segundo);
		
		System.out.println("\nEl reloj no tiene pilas ponlo en hora");
		unaHora.ponerEnHora(hora, minuto, segundo);
		
		System.out.print("\nHas introducido la hora: ");
		unaHora.verHora(hora, minuto, segundo);
		
		System.out.println("\nQuieres ajustarlo? (s/n)");
		ajustar = sc.nextLine();
		if (ajustar.toLowerCase().equals("s")) {
			System.out.println(unaHora.ajustarHora(hora, minuto, segundo));
			System.out.print("\nLa nueva hora es: ");
			unaHora.verHora(hora, minuto, segundo);
		} else {
			System.out.println("Ya esta en hora");
			unaHora.verHora(hora, minuto, segundo);
		}
	}// main

}// Class
