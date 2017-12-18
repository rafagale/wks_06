import java.util.Scanner;

public class TragaBolas {
	private String color;// Sólo puede ser verde, amarillo, rojo
	private int bolasComidas;
	private int maxBolas;

	/*TragaBolas() {

	}*/

	TragaBolas(String color, int bolasComidas, int maxBolas) {
		color = "";
		bolasComidas = 0;
		maxBolas = 0;
	}

	public String visualizar() { //metodos de instancia
		System.out.println("El hipo es de color " + color + " lleva " + bolasComidas
				+ " bolas comidas y su máximo de bolas es " + maxBolas);
		return "No muestra nada";
	}// visualizar

	public int comer() { //metodos de instancia
		if (bolasComidas < maxBolas) {
			bolasComidas++;
			System.out.println("Ha comido una ñam ñam");
		} else {
			System.out.println("No puedo comer mas necesito dormir");
		}
		return bolasComidas;
	}// comer

	public String trotar() { //metodos de instancia
		if (bolasComidas >= 1) {
			bolasComidas--;
			System.out.println("Estoy trotando");
		} else {
			System.out.println("Estoy esmirriao no me puedo ni mover");
		}
		return "TROTAR";
	}// trotar

	public String dormir() { //metodos de instancia
		String cadena = "";
		if (bolasComidas == maxBolas) {
			bolasComidas = bolasComidas / 2;
			cadena = "Tripa llena. ZZZZZZ";
		} else {
			cadena = "No quiero dormir";
		}
		return cadena;
	}// dormir

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) { //metodos de instancia
		this.color = color;
	}

	/**
	 * @param maxBolas
	 *            the maxBolas to set
	 */
	public void setMaxBolas(int maxBolas) { //metodos de instancia
		this.maxBolas = maxBolas;
	}

}// Class