
public class Ejer2 {

	/**
	 * Metodo que dice las veces que aparece una letra en la palabra
	 * @param cadena
	 * @param letra
	 * @return
	 * 1: longitud 0
	 * 2: longitud 1
	 * 3: longitud >1 y letra en cadena
	 * 4: longitud >1 y letra no esta en cadena
	 * 
	 */
	public int contar_letra(String cadena, char letra) {
		int longitud, contador = 0, n = 0;
		longitud = cadena.length();
		if (longitud > 0) {
			do {
				if (cadena.charAt(contador) == letra) {
					n++;
				}
				longitud--;
				contador++;
			} while (longitud > 0);
		}
		return n;
	}//Ejer2
	
}//Class
