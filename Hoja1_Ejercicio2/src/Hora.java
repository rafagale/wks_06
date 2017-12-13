import java.util.Scanner;

public class Hora {
	private int horas;
	private int minutos;
	private int segundos;

	Hora() { // Constructor para hh, mm, ss
		hora = 0;
		minutos = 0;
		segundos = 0;
	}

	public int ponerEnHora(int horass, int minuto, int segundo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una hora");
		horass = sc.nextInt();
		System.out.println("Introduce los minutos");
		minutos = sc.nextInt();
		System.out.println("Introduce los segundos");
		segundos = sc.nextInt();
		
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
			hora += n;
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
			hora += n;
			System.out.println("minutos a sumar");
			n = sc.nextInt();
			minutos += n;
			System.out.println("segundos a sumar");
			n = sc.nextInt();
			segundos += n;
		}// switch
		return hora;
	}

	public int getHoras() {
		return hora;
	}

	public void setHoras(int hora) {
		this.hora = hora % 24;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos % 60;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos % 60 ;
	}
	
}// Class