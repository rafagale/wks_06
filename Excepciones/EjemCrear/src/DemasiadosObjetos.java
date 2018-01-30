
public class DemasiadosObjetos extends Exception{
	void informeError(String tipoClase){
		System.out.println("Ya hay en memoria el máximo número de objetos de tipo "+tipoClase);
	}
}
