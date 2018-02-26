public class Carta {
	private String nombre;
	private Plato platos[] = new Plato[6];
	
	public Carta() {
		nombre = "RESTAURANTE `CASA VIEJA´";
	}

	public void meterPlatos(Plato[] platos2){
		for (int i = 0; i < platos.length; i++) {
			platos[i] = platos2[i];
		}
	}

	
	public String visualizarCarta() {
		return "\t" + getNombre() + "\n" +
				"Plato 1: " + platos[0].toString()+
				"\n\nPlato 2: " + platos[1].toString()+
				"\n\nPlato 3: " + platos[2].toString()+
				"\n\nPlato 4: " + platos[3].toString()+
				"\n\nPlato 5: " + platos[4].toString()+
				"\n\nPlato 6: " + platos[5].toString();
	}

	public String getNombre() {
		return nombre;
	}


	
}
