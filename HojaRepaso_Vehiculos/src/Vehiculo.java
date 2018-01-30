
public class Vehiculo {
	private Integer numeroDeRuedas;
	private Double velocidadMax;
	private Double velocidadActual;
	private Double peso;
	public static int contadorVehiculos;

	public Vehiculo(Integer numeroDeRuedas, Double velocidadMax, Double velocidadActual, Double peso) {
		this.numeroDeRuedas = numeroDeRuedas;
		this.velocidadMax = velocidadMax;
		this.velocidadActual = velocidadActual;
		this.peso = peso;
		contadorVehiculos++;
	}// Constructor

	public boolean esIgual(Vehiculo vehiculo) {
		if (vehiculo.numeroDeRuedas.equals(this.numeroDeRuedas) && vehiculo.velocidadMax.equals(this.velocidadMax)
				&& vehiculo.velocidadActual.equals(this.velocidadActual) && vehiculo.peso.equals(this.peso)) {
			return true;
		} else {
			return false;
		}
	}// esIgual

	/**
	 * Este método se utilizará para copiar los valores de los atributos del
	 * objeto desde el que se está llamando al método en los atributos del
	 * objeto que recibe como parámetro. *
	 * 
	 * @param vehiculo
	 */
	public void copia(Vehiculo vehiculo) {
		vehiculo.numeroDeRuedas = this.numeroDeRuedas.intValue();
		vehiculo.velocidadMax = this.velocidadMax.doubleValue();
		vehiculo.velocidadActual = this.velocidadActual.doubleValue();
		vehiculo.peso = this.peso.doubleValue();
	}// copia
	
		

	@Override
	public String toString() {
		return "El vehiculo tiene " + numeroDeRuedas + " ruedas y pesa " + peso + " Kg\nSu velocidad maxima es "
				+ velocidadMax + " Km/h y su velocidad actual es de " + velocidadActual + " Km/h";
	}

	public Integer getNumeroDeRuedas() {
		return numeroDeRuedas;
	}

	public void setNumeroDeRuedas(Integer numeroDeRuedas) {
		this.numeroDeRuedas = numeroDeRuedas;
	}

	public Double getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(Double velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	public Double getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(Double velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
