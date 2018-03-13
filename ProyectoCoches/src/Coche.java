
public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private Fecha fechaFabricacion;
	private Boolean disponible;
	private Integer precioDiario;

	public Coche(String matricula, String marca, String modelo, Fecha fechaFabricacion, Integer precioDiario) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaFabricacion = fechaFabricacion;
		this.precioDiario = precioDiario;
		disponible=true;
	}
	
	public void alquilar(){
		disponible=false;
	}
	
	
	public Boolean getDisponible() {
		return disponible;
	}

	public Integer devolver(Integer diasOcupado){
		Integer precioTotal=precioDiario*diasOcupado;
		disponible=true;
		return precioTotal;
	}

	
	public String visualizarCoche() {
		return "Coche [\tmatricula=" + matricula + " \tmarca=" + marca + "\t modelo=" + modelo + "\t fechaFabricacion="
				+ fechaFabricacion + "\t disponible=" + disponible + "\tprecioDiario=" + precioDiario + "]";
	}
	
	

}
