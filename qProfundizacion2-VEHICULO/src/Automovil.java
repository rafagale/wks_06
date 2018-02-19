
public class Automovil {
	private String marca;
	private String modelo;
	private Integer cilindrada;
	private Integer precio;

	public Automovil(String marca, String modelo, Integer cilindrada, Integer precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getCilindrada() {
		return cilindrada;
	}

	public Integer getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Automovil [marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", precio=" + precio
				+ " €]";
	}

	public String visualizar() {
		return "Automovil: marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", precio=" + precio + "€";
	}
}
