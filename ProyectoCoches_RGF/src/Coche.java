/**
 * @author Rafael Gale
 * @category Ejercicio 2
 */
public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private Fecha fechaFabricacion;
	private Boolean disponible;
	private Integer precioDiario;

	/**
	 * Constructor coche
	 * 
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param fechaFabricacion
	 * @param disponible
	 * @param precioDiario
	 */
	public Coche(String matricula, String marca, String modelo, Fecha fechaFabricacion, Boolean disponible,
			Integer precioDiario) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaFabricacion = fechaFabricacion;
		this.disponible = disponible;
		this.precioDiario = precioDiario;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void alquilar() {
		//Se verifica que el estado sea disponible y se cambia a false si se cumple
		if (disponible) {
			disponible = false;
		}
	}// Alquilar

	public Integer devolver(Integer diasAlquilado) {
		Integer precioDeAlquiler;
		precioDeAlquiler = precioDiario * diasAlquilado;
		disponible = true;
		return precioDeAlquiler;
	}// devolver

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", fechaFabricacion="
				+ fechaFabricacion + ", disponible=" + disponible + ", precioDiario=" + precioDiario + "]";
	}

}
