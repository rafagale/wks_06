
public class Jefe extends Empleado {
	private String titulo;
	private String nombreDpto;

	public Jefe(String nombre, Double sueldo, String titulo, String nombreDpto) {
		super(nombre, sueldo);
		this.titulo = titulo;
		this.nombreDpto = nombreDpto;
	}// Constructor

	@Override
	public String toString() {
		return " [Nombre: " + nombre + ", Sueldo: " + sueldo + "€, Titulo: " + titulo + ", Nombre departamento: " + nombreDpto + "]";
	}
	
}
