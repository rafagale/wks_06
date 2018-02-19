package rDojo_Empleados;

import utilidades.Fecha;
import utilidades.Leer;

public class Responsable extends Empleado {
	private Float bono;
	private String departamento;
	private Integer personasACargo;
	private static Float plusResponsabilidad = 250f;

	public Responsable(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso, Float bono,
			String departamento, Integer personasACargo) {
		super(nombre, fechaNacimiento, numeroEmpleado, fechaIngreso);
		this.bono = bono;
		this.departamento = departamento;
		this.personasACargo = personasACargo;
		this.plusResponsabilidad = plusResponsabilidad;
	}



	public Float getBono() {
		return bono;
	}



	public void setBono(Float bono) {
		this.bono = bono;
	}



	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public Integer getPersonasACargo() {
		return personasACargo;
	}



	public void setPersonasACargo(Integer personasACargo) {
		this.personasACargo = personasACargo;
	}



	public Float getPlusResponsabilidad() {
		return plusResponsabilidad;
	}



	public void setPlusResponsabilidad(Float plusResponsabilidad) {
		this.plusResponsabilidad = plusResponsabilidad;
	}



	public Float calculoNomina() {

		return Empleado.getSalarioBase() + (personasACargo * plusResponsabilidad) + bono;
	}
	
	
}
