
public class Menu {
	private Plato plato1;
	private Plato plato2;
	private String postre;
	private Float precioTotal;
	
	public Menu(Plato plato1, Plato plato2, String postre) {
		super();
		this.plato1 = plato1;
		this.plato2 = plato2;
		this.postre = postre;
		calcularPrecio();
	}
	
	private void calcularPrecio(){
		precioTotal = (float) (Math.round((plato1.getPrecio() + plato2.getPrecio()) * 100d) / 100d);
		
	}

	public String visualizarMenu() {
		return "Primer plato: " + plato1.toString() + "\nSegundo plato: "  + plato2.toString() + "\nPostre: " + postre +  " (invita la casa)\nPrecio total: " + precioTotal + "€";
	}

	public Float getPrecioTotal() {
		return precioTotal;
	}
	
	
	
}
