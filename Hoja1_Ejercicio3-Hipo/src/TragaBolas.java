import java.util.Scanner;

public class TragaBolas {
	private String color;//Sólo puede ser verde, amarillo, rojo
	private int bolasComidas;
	private int maxBolas;
	
	TragaBolas(){

	}
	TragaBolas(String color, int bolasComidas, int maxBolas){
		color="";
		bolasComidas=0;
		maxBolas=0;
	}
	
	public String visualizar() {
		System.out.println("El hipo es de color " +color + " lleva " +bolasComidas + " bolas comidas y su máximo de bolas es " + maxBolas);
		return "No muestra nada";
	}//visualizar

	public int comer() {
		if (bolasComidas<maxBolas) {
			bolasComidas++;
			System.out.println("Ha comido una ñam ñam");
		}else{
			System.out.println("No puedo comer mas necesito dormir");
		}
		return bolasComidas;
	}//comer
	
	public String trotar() {
		if (bolasComidas>=1) {
			bolasComidas--;
			System.out.println("Estoy trotando");
		}else{
			System.out.println("Estoy esmirriao no me puedo ni mover");
		}
		return "TROTAR";
	}//trotar
	
	public String dormir() {
		if (bolasComidas==maxBolas) {
			bolasComidas=bolasComidas/2;
			System.out.println("Tripa llena. ZZZZZZ");
		}else{
			System.out.println("Aun no estoy lleno");
		}
		return "DORMIR";
	}//dormir
	
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @param maxBolas the maxBolas to set
	 */
	public void setMaxBolas(int maxBolas) {
		this.maxBolas = maxBolas;
	}
	
}//Class
