
public class Clase3101 {
	/**
	 * Dado una clase con metodos, analizarlos desde el punto de vista de caja
	 * blanca y caja negra y plantear los test unitarios con JUnit. Prueba de
	 * camino basico: complejidad ciclomatica y cassos de prueba necesarios para
	 * los caminos indicados en el resultado
	 */
	public int metodo(boolean a, boolean b) {
		int resultado = 0;
		if (a && b) {
			resultado = 1;
		} else {
			resultado = 2;
		}
		return resultado;

	}// metodo

}// Class
