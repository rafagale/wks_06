import java.util.*;

/**
 * 
 * @author rafagale
 * @version 0.1
 *
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
		System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		System.out.println("\nEl reloj no tiene pilas ponlo en hora");
		unaHora.ponerEnHora(hora, minuto, segundo);
		System.out.print("\nHas introducido la hora: ");
		System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		System.out.println("\nQuieres ajustarlo? (s/n)");
		ajustar = sc.nextLine();
		if (ajustar.toLowerCase().equals("s")) {
			unaHora.ajustarHora(hora, minuto, segundo);
			System.out.print("\nLa nueva hora es: ");
			System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		} else {
			System.out.println("Ya esta en hora");
			System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		}

	}// main

}// Class
