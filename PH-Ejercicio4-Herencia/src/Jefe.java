
public class Jefe extends Empleado {
	private Integer plusJefe;
	private Integer numeroDepartamento;
	/**
	 * @param nombreEmpresa
	 * @param nombre
	 * @param edad
	 * @param sueldoBase
	 * @param incrementoSueldo
	 * @param plusJefe
	 * @param numeroDepartamento
	 */
	public Jefe(String nombreEmpresa, String nombre, Integer edad, Integer sueldoBase, Integer incrementoSueldo,
			Integer plusJefe, Integer numeroDepartamento) {
		super(nombreEmpresa, nombre, edad, sueldoBase, incrementoSueldo);
		this.plusJefe = 250;
		this.numeroDepartamento = numeroDepartamento;
	}
	@Override
	public String toString() {
		return "Jefe [plusJefe=" + plusJefe + ", numeroDepartamento=" + numeroDepartamento + ", "
				+ super.toString() + "]";
	}
	public void setPlusJefe(Integer plusJefe) {
		this.plusJefe = plusJefe;
	}
	

}
