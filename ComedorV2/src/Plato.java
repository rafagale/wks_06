public class Plato {
	private Ingrediente[] ingredientes;
	private Float[] cantidades;
	private Float precio;
	private Integer conta = 0;

	public Plato() {
		ingredientes = new Ingrediente[4];
		cantidades = new Float[4];
		precio = 0f;
	}

	public Float getPrecio() {
		return precio; 
	}

	public String toString() {
		return "ingredientes --> " + ingredientes[0].getNombre() + "(" + Math.round(cantidades[0] * 100f) / 100 +  "g), "
				+ ingredientes[1].getNombre() + "(" + Math.round(cantidades[1] * 100f) / 100 +  "g), "
				+ ingredientes[2].getNombre() + "(" + Math.round(cantidades[2] * 100f) / 100 +  "g), "
				+ ingredientes[3].getNombre() + "(" + Math.round(cantidades[3] * 100f) / 100 +  "g) "
				+ "\nPVP= " + precio + "€";
	}

	public Boolean añadirIng(Ingrediente ingrediente, Float cantidad) {
		if (conta == ingredientes.length) {
			return false;
		} else {
			ingredientes[conta] = ingrediente;
			cantidades[conta] = cantidad;
			conta++;
			return true;
		}
	}

	public void calcularPvp() {
		for (int i = 0; i < cantidades.length; i++) {
			precio = precio + (ingredientes[i].getPrecioGramo() * cantidades[i]);
		}
		precio  = (float) (Math.round(precio * 100d) / 100d);
	}

}
