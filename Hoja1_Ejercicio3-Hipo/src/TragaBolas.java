import java.util.Scanner;

public class TragaBolas {
	private String color;// Sólo puede ser verde, amarillo, rojo
	private Integer bolasComidas;
	private Integer maxBolas;


	public TragaBolas(String color, int maxBolas) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Color del hipopotamo?");
			this.color = sc.nextLine();
		} while (!this.color.toLowerCase().equals("verde") && !this.color.toLowerCase().equals("rojo")
				&& !this.color.toLowerCase().equals("amarillo"));
		System.out.println("Bolas máximas?");
		this.maxBolas = sc.nextInt();
		this.bolasComidas = 0;
	}

	public String visualizar() { // metodos de instancia
		String visualizacion;
		visualizacion = "El hipo es de color " + color + " lleva " + bolasComidas
				+ " bolas comidas y su máximo de bolas es " + maxBolas;
		return visualizacion;
	}// visualizar

	public String comer() { // metodos de instancia
		String mensaje;
		if (bolasComidas < maxBolas) {
			bolasComidas++;
			mensaje = "Ha comido una ñam ñam";
		} else {
			mensaje = "No puedo comer mas necesito dormir";
		}
		return mensaje;
	}// comer

	public String trotar() { // metodos de instancia
		String mensajeTrotar;
		if (bolasComidas >= 1) {
			bolasComidas--;
			mensajeTrotar="Estoy trotando";
		} else {
			mensajeTrotar="Estoy esmirriao no me puedo ni mover";
		}
		return mensajeTrotar;
	}// trotar

	public String dormir() { // metodos de instancia
		String cadena = "";
		if (bolasComidas == maxBolas) {
			bolasComidas = bolasComidas / 2;
			cadena = "Tripa llena. ZZZZZZ";
		} else {
			cadena = "No quiero dormir";
		}
		return cadena;
	}// dormir


}// Class