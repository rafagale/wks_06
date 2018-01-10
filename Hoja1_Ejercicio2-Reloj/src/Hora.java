import java.util.Scanner;

public class Hora {
	private int horas;
	private int minutos;
	private int segundos;

	Hora() { // Constructor para hh, mm, ss
		horas = 0;
		minutos = 0;
		segundos = 0;
	}

	public String ponerEnHora(int hora, int minuto, int segundo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una hora");
		horas = sc.nextInt();
		System.out.println("Introduce los minutos");
		minutos = sc.nextInt();
		System.out.println("Introduce los segundos");
		segundos = sc.nextInt();
		return "Puesto en hora";
	}

	public String ajustarHora(int hora, int minuto, int segundo) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Que quieres ajustarle?");
		System.out.println("1-Hora\n2-Minutos\n3-Segundos\n4-Todo");
		n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("horas a sumar");
			n = sc.nextInt();
			horas += n;
			break;
		case 2:
			System.out.println("minutos a sumar");
			n = sc.nextInt();
			minutos += n;
			break;
		case 3:
			System.out.println("segundos a sumar");
			n = sc.nextInt();
			segundos += n;
			break;
		case 4:
			System.out.println("horas a sumar");
			n = sc.nextInt();
			horas += n;
			System.out.println("minutos a sumar");
			n = sc.nextInt();
			minutos += n;
			System.out.println("segundos a sumar");
			n = sc.nextInt();
			segundos += n;
		}// switch
		return "Hora ajustada";
	}

	public int verHora(int hora, int minuto, int segundo) {

		if (segundos > (segundos % 60)) {
			minutos += (segundos / 60);
			segundos = segundos % 60;
		}
		if (minutos > (minutos % 60)) {
			horas += (minutos / 60);
			minutos = minutos % 60;
		}
		System.out.printf("%02d:%02d:%02d", horas % 24, minutos, segundos);
		System.out.println("\nLa suma de la hora en segundos es: " +(horas*3600+minutos*60+segundos));
		return hora;
	}

}// Class