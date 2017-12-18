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

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas
	 *            the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @param minutos
	 *            the minutos to set
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 * @return the segundos
	 */
	public int getSegundos() {
		return segundos;
	}

	/**
	 * @param segundos
	 *            the segundos to set
	 */
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int ponerEnHora(int hora, int minuto, int segundo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una hora");
		horas = sc.nextInt();
		System.out.println("Introduce los minutos");
		minutos = sc.nextInt();
		System.out.println("Introduce los segundos");
		segundos = sc.nextInt();
		return hora;
	}

	public int ajustarHora(int hora, int minuto, int segundo) {
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
		return hora;
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
		return hora;
	}

}// Class