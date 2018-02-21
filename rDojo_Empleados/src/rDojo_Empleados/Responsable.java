package rDojo_Empleados;


public class Responsable extends Empleado {
	private Float bono;
	private String departamento;
	private Integer personasACargo;
	private static Float plusResponsabilidad = 250f;
	private static int contaResp = 0;
	
	public Responsable(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso, Float bono,
			String departamento, Integer personasACargo) {
		super(nombre, fechaNacimiento, numeroEmpleado, fechaIngreso);
		this.bono = bono;
		this.departamento = departamento;
		this.personasACargo = personasACargo;
		contaResp++;
	}

	public Float calculoNomina() {
		return Empleado.getSalarioBase() + bono + (plusResponsabilidad * personasACargo);
	}

	@Override
	public String toString() {
		return super.toString() + " bono:" + bono + ", departamento:" + departamento + ", personasACargo="
				+ personasACargo + " (Responsable)";
	}

	public Integer getPersonasACargo() {
		//To-do
		return personasACargo;
	}

	public static int getContaResp() {
		return contaResp;
	}

}
