
public class Jefe extends Empleado {
	private static Integer plusJefe;
	private String departamento;



	public Jefe(String nombre, Integer edad, Integer porcentaje, String departamento) {
		super(nombre, edad, porcentaje);
		this.departamento = departamento;
		plusJefe = 250;
	}


	public static Integer getPlusJefe() {
		return plusJefe;
	}


	public static void setPlusJefe(Integer plusJefe) {
		Jefe.plusJefe = plusJefe;
	}

	public String getDepartamento() {
		return departamento;
	}


	@Override
	public String toString() {
		return "Jefe [departamento=" + departamento + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public String visualizar(){
		return "Jefe [departamento=" + departamento + ", toString()=" + super.visualizar() + "]";
	}

}
