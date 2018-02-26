
public class Ingrediente {

	private String nombre;
	private Float precioGramo;
	
	public Ingrediente(String nombre, Float precioGramo) {
		this.nombre = nombre;
		this.precioGramo = precioGramo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecioGramo() {
		return precioGramo;
	}

	public void setPrecioGramo(Float precioGramo) {
		this.precioGramo = precioGramo;
	}
	
	
}
