
public class Mesa {
	private Menu menus[];
	private Float precioTotal = 0f;
	
	public Mesa(Menu[] menus) {
		this.menus = menus;
		calcularPrecioTotal();
	}
	
	private void calcularPrecioTotal(){
		for (int i = 0; i < menus.length; i++) {
			precioTotal = precioTotal + menus[i].getPrecioTotal();
		}
	}

	public Float getPrecioTotal() {
		return precioTotal;
	}

	
	public void visulizarMesa() {
		for (int i = 0; i < menus.length; i++) {
			Leer.mostrarEnPantalla("Menu de la persona " + (i + 1) + "\n");
			Leer.mostrarEnPantalla(menus[i].visualizarMenu() +"\n");
		}
	}
	
	
	
	
}
