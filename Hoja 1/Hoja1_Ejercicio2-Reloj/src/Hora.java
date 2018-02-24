import java.util.Scanner;
/*Desarrollar un programa en Java que utilice una clase que se llame Hora con miembros de
tipo Integer para hora, minutos y segundos. 
Deberá tener un constructor para inicializar la hora a 0 y otro para incializar a una hora determinada (hora, minutos, segundos. La hora
deberá ser una hora con valores posibles que hemos de controlar).Se deberá poder sumar
y restar horas, así como imprimir una hora, ver la conversión a segundos de una hora dada,
sumar segundos a una hora dada.
El formato de impresión y lectura será hh:mm:ss, todo en modo 24 horas.*/

public class Hora {
	private Integer horas;
	private Integer minutos;
	private Integer segundos;

	public Hora() { // Constructor para hh, mm, ss
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
	}

	public String ponerEnHora(int hora, int minuto, int segundo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una hora");
		horas = sc.nextInt();
		System.out.println("Introduce los minutos");
		minutos = sc.nextInt();
		System.out.println("Introduce los segundos");
		segundos = sc.nextInt();
		return "Hora inicializada";
	}

	public String ajustarHora(int hora, int minuto, int segundo) {
		
		int n, opcion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Que quieres ajustarle?");
		System.out.println("1-Hora\n2-Minutos\n3-Segundos");
		n = sc.nextInt();
		switch (n) {
		case 1:
			do {
				System.out.println("Sumar o restar horas?\n1.-Sumar\n2.-Restar");
				opcion = sc.nextInt();
			} while (opcion!=1 && opcion!=2);

			if (opcion==1) {
				System.out.println("Horas a sumar?");
				n = sc.nextInt();
				horas += n;
			} else {
				System.out.println("Horas a restar?");
				n = sc.nextInt();
				horas -= n;
			}
			break;
		case 2:
			do {
				System.out.println("Sumar o restar minutos?\n1.-Sumar\n2.-Restar");
				opcion = sc.nextInt();
			} while (opcion!=1 && opcion!=2);

			if (opcion==1) {
				System.out.println("minutos a sumar?");
				n = sc.nextInt();
				minutos += n;
			} else {
				System.out.println("minutos a restar?");
				n = sc.nextInt();
				minutos -= n;
			}
			break;
		case 3:
			do {
				System.out.println("Sumar o restar segundos?\n1.-Sumar\n2.-Restar");
				opcion = sc.nextInt();
			} while (opcion!=1 && opcion!=2);

			if (opcion==1) {
				System.out.println("segundos a sumar?");
				n = sc.nextInt();
				segundos += n;
			} else {
				System.out.println("segundos a restar?");
				n = sc.nextInt();
				segundos -= n;
			}
			break;
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
		System.out.println("\nLa suma de la hora en segundos es: " + (horas * 3600 + minutos * 60 + segundos));
		return hora;
	}// verHora

}// Class