
public class Empleado {
	protected String nombre;
	protected Double sueldo;
	
	public Empleado(String nombre, Double sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
	}//Constructor

	public String getNombre() {
		return nombre;
	}



	public Double getSueldo() {
		return sueldo;
	}



	@Override
	public String toString() {
		return " [Nombre: " + nombre + ", Sueldo: " + sueldo + "€]";
	}
	
}
