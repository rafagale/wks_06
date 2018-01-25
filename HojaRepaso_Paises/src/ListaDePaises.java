import java.util.Arrays;

public class ListaDePaises {
	/*
	 * El constructor recibir� como par�metro el n�mero m�ximo de nombres que se
	 * pueden guardar en la lista. Para guardar los nombres se utilizar� un
	 * vector. Los nombres se almacenar�n en elementos consecutivos del vector.
	 */
	private Integer numeroPaises;
	private String[] nombrePais;
	public static int contadorPaises = 0;
	/**
	 * @param numeroPaises
	 * @param nombrePais
	 */
	public ListaDePaises(Integer numeroPaises) {
		this.numeroPaises = numeroPaises;
		this.nombrePais = nombrePais;
	}
	public String[] getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String[] nombrePais) {
		this.nombrePais = nombrePais;
	}
	public static int getContadorPaises() {
		return contadorPaises;
	}

	

	
}
