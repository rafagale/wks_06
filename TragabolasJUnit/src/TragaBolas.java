import java.util.Scanner;

public class TragaBolas {
	private Integer bolasComidas;
	private Integer maxBolas;


	public TragaBolas(int maxBolas, int bolasComidas) {
		this.maxBolas = maxBolas;
		this.bolasComidas = bolasComidas;
	}

	public String visualizar() { 
		String visualizacion;
		visualizacion = "El hipo es de color "  + " lleva " + bolasComidas
				+ " bolas comidas y su máximo de bolas es " + maxBolas;
		return visualizacion;
	}// visualizar

	public String comer() { 
		String mensaje;
		if (bolasComidas < maxBolas) {
			bolasComidas++;
			mensaje = "Ha comido una ñam ñam";
		} else {
			mensaje = "No puedo comer mas necesito dormir";
		}
		return mensaje;
	}// comer

	public int getBolasComidas() {
		return bolasComidas.intValue();
	}

	public int getMaxBolas() {
		return maxBolas.intValue();
	}

	public String trotar() { 
		String mensajeTrotar;
		if (bolasComidas >= 1) {
			bolasComidas--;
			mensajeTrotar="Estoy trotando";
		} else {
			mensajeTrotar="Estoy esmirriao no me puedo ni mover";
		}
		return mensajeTrotar;
	}// trotar

	public String dormir() { 
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