
public class Empleado {
	private String nombre;
	private static Integer sueldoBase;
	private Integer edad;
	private static Integer contaEmpleados = 0;

	public Empleado(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
		sueldoBase = 2000;
		contaEmpleados++;
	}

	public Integer getEdad() {
		return edad;
	}

	public static Integer getContaEmpleados() {
		return contaEmpleados;
	}

	public String toString() {
		return "Nombre: " + nombre + ", edad: " + edad + ", sueldo: " + sueldoBase;
	}

}
