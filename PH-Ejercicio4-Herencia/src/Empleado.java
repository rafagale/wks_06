
public class Empleado extends Empresa {
	private String nombre;
	private Integer edad;
	private Integer sueldoBase;
	private Integer incrementoSueldo;
	/**
	 * @param nombreEmpresa
	 * @param nombre
	 * @param edad
	 * @param sueldoBase
	 * @param incrementoSueldo
	 */
	public Empleado(String nombreEmpresa, String nombre, Integer edad, Integer sueldoBase, Integer incrementoSueldo) {
		super(nombreEmpresa);
		this.nombre = nombre;
		this.edad = edad;
		this.sueldoBase = 1000;
		this.incrementoSueldo = sueldoBase*incrementoSueldo/100;
	}
	public void setSueldoBase(Integer sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldoBase=" + sueldoBase + ", incrementoSueldo="
				+ incrementoSueldo + ", " + super.toString() + "]";
	}
	
	public String visualizar(){
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldoBase=" + sueldoBase + ", incrementoSueldo="
				+ incrementoSueldo + ", " + super.toString() + "]";
	}
}
