import java.util.*;
public class HoraTest {

	public static void main(String[] args) {
		int n;
		String ajustar="";
		Hora unaHora;
		Scanner sc = new Scanner(System.in);
		unaHora = new Hora();

		System.out.println("La hora es: ");
		System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		System.out.println("\nEl reloj no tiene pilas ponlo en hora");

		System.out.println("Introduce una hora");
		n = sc.nextInt();
		unaHora.setHoras(n);
		System.out.println("Introduce los minutos");
		n = sc.nextInt();
		unaHora.setMinutos(n);
		System.out.println("Introduce los segundos");
		n = sc.nextInt();
		unaHora.setSegundos(n);

		System.out.print("\nHas introducido la hora: ");
		System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());

		System.out.println("\nQuieres ajustarlo? (s/n)");
		sc.nextLine();
		ajustar = sc.nextLine();
		if (ajustar.toLowerCase().equals("s")) {
			System.out.println("Que quieres ajustarle?");
			System.out.println("1-Hora\n2-Minutos\n3-Segundos\n4-Todo");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("horas a sumar");
				n = sc.nextInt();
				unaHora.setHoras(unaHora.getHoras()+n);
				break;
			case 2:
				System.out.println("minutos a sumar");
				n = sc.nextInt();
				unaHora.setMinutos(unaHora.getMinutos()+n);
				break;
			case 3:
				System.out.println("segundos a sumar");
				n = sc.nextInt();
				unaHora.setSegundos(unaHora.getSegundos()+n);
				break;
			case 4:
				System.out.println("horas a sumar");
				n = sc.nextInt();
				unaHora.setHoras(unaHora.getHoras()+n);
				System.out.println("minutos a sumar");
				n = sc.nextInt();
				unaHora.setMinutos(unaHora.getMinutos()+n);
				System.out.println("segundos a sumar");
				n = sc.nextInt();
				unaHora.setSegundos(unaHora.getSegundos()+n);
			}//switch
			System.out.print("\nLa nueva hora es: ");
			System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		}else{
			System.out.println("Ya esta en hora");
			System.out.printf("%02d:%02d:%02d", unaHora.getHoras(), unaHora.getMinutos(), unaHora.getSegundos());
		}//fi


	}//main

}//Class
