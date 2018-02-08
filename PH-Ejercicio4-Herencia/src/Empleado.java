
public class Empleado {
	private String nombre;
	private Integer edad;
	private Integer porcentaje;
	private static Integer sueldoBase;
	final private static String nombreEmpresa = "Eléctrica, SA";

	public Empleado(String nombre, Integer edad, Integer porcentaje) {
		this.nombre = nombre;
		this.edad = edad;
		this.porcentaje = porcentaje;
		sueldoBase = 1000;
	}

	public static void setSueldoBase(Integer sueldoBase) {
		Empleado.sueldoBase = sueldoBase;
	}

	public Double getSueldoReal() {
		double sueldoReal;
		sueldoReal = sueldoBase * (1 + (double)porcentaje / 100);
		return sueldoReal;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public Integer getPorcentaje() {
		return porcentaje;
	}

	public static Integer getSueldoBase() {
		return sueldoBase;
	}

	public static String getNombreempresa() {
		return nombreEmpresa;
	}

	public String visualizar() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", porcentaje=" + porcentaje + ", sueldo real = "
				+ getSueldoReal() + "]";
	}
}
