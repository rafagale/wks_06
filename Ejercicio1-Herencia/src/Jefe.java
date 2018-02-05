
public class Jefe extends Empleado {
	 private String titulo;
	 private String nombreDpto;
	 
	public Jefe(String nombre, Double sueldo, String titulo, String nombreDpto) {
		super(nombre, sueldo);
		this.titulo = titulo;
		this.nombreDpto = nombreDpto;
	}//Constructor



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombreDpto() {
		return nombreDpto;
	}

	public void setNombreDpto(String nombreDpto) {
		this.nombreDpto = nombreDpto;
	}
	
	@Override
	public String toString() {
		return "Jefe [titulo=" + titulo + ", nombreDpto=" + nombreDpto + "]";
	}
}
