package visibilidad1;

public class Empleado {
	private int sueldo;
	String nombre;
	protected String direccion;
	public int edad;
	@Override
	public String toString() {
		return "Empleado [sueldo=" + sueldo + ", nombre=" + nombre + ", direccion=" + direccion + ", edad=" + edad
				+ "]";
	}
}