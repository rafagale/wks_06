
public class Comedor {

	public static void main(String[] args) {
		Plato platos[] = new Plato[6];
		Ingrediente ingredientes[] = new Ingrediente[16];
		Carta carta = new Carta();
		Menu menus[] = new Menu[20];
		Mesa mesas[] = new Mesa[100];
		crearIngredientes(ingredientes);
		crearPlatos(platos, ingredientes);
		generarCarta(carta, platos);
		mostrarCarta(carta);
		generarMenus(platos, menus);
		mostarMenus(menus);
		generarMesas(platos, menus, mesas);
		consultarMesas(mesas);
		Leer.mostrarEnPantalla("FIN DEL PROGRAMA");
	}

	public static void crearIngredientes(Ingrediente[] ingredientes) {
		String[] ingredientes1 = { "Pepinillo", "Patata", "Picante", "Zanahoria", "Cebolla", "Calabaza", "Mayonesa",
				"Ajo", "Perejil", "Judias", "Albahaca", "Lentejas", "Lechuga", "Huevo duro", "Espinacas", "Brocoli" };
		Float[] ingredientes1Precio = { 0.10f, 0.15f, 0.20f, 0.14f, 0.25f, 0.10f, 0.30f, 0.17f, 0.40f, 0.22f, 0.30f,
				0.12f, 0.10f, 0.23f, 0.14f, 0.20f };

		for (int i = 0; i < ingredientes1.length; i++) {
			ingredientes[i] = new Ingrediente(ingredientes1[i], ingredientes1Precio[i]);
		}
	}

	public static void crearPlatos(Plato platos[], Ingrediente[] ingredientes) {

		for (int i = 0; i < 6; i++) {// creamos los 6 platos
			String[] vectorComprobacion = new String[ingredientes.length]; // reseteamos el vector cada vez que creamos unplato
			platos[i] = new Plato();
			int numero = 0;
			for (int j = 0; j < 4; j++) { // añadimos los 4 ingredientes al
											// plato "i"
				Boolean comprobar = false;
				numero = (int) (Math.random() * ingredientes.length);

				do {// para no repetir el ingrediente
					if (vectorComprobacion[numero] == null) {
						vectorComprobacion[numero] = "S";
						comprobar = true;
					} else {
						numero = (int) (Math.random() * ingredientes.length);
						comprobar = false;
					}
				} while (!comprobar);						//metemos la cantidad con random
				platos[i].añadirIng(ingredientes[numero], (float) (Math.random() * (200 - 40) + 40));
			}
			platos[i].calcularPvp();//cuando ya metemos los 4 ingredientes al plato, llamamos al metodo calcularPvp para calcular el precio total.
		}
	}

	public static void generarCarta(Carta carta, Plato[] platos) {
		carta.meterPlatos(platos);
	}

	public static void mostrarCarta(Carta carta) {
		Leer.mostrarEnPantalla(carta.visualizarCarta());
	}

	public static void generarMenus(Plato platos[], Menu menus[]) {
		String[] postres = { "Flan de huevo", "Yogurt natural", "Melocoton en almibar", "Arroz con leche",
				"Helado de vainilla", "Gofre con chocolate", "Crêpe con nata", "Rosquillas", "Pastel de Hojaldre",
				"Batido de Fresa" };
		for (int i = 0; i < menus.length; i++) {
			int plato1, plato2;
			plato1 = (int) (Math.random() * platos.length);
			do {
				plato2 = (int) (Math.random() * platos.length);
			} while (plato1 == plato2);
			menus[i] = new Menu(platos[plato1], platos[plato2], postres[(int) (Math.random() * postres.length)]);
		}
	}

	public static void mostarMenus(Menu menus[]) {
		Leer.mostrarEnPantalla("\n\n\t\t\t\t\t>>>>MENUS<<<<");

		for (int i = 0; i < menus.length; i++) {
			Leer.mostrarEnPantalla("\tMENU " + (i + 1));
			Leer.mostrarEnPantalla(menus[i].visualizarMenu() + "\n");
		}
	}

	public static void generarMesas(Plato platos[], Menu menus[], Mesa mesas[]) {
		Leer.mostrarEnPantalla("\n\n\t****ELECCION DE MENUS****");
		boolean salir = false;
		for (int i = 0; i < 100 && !salir; i++) {
			Float importe;
			
			int numComensales = (int) (Math.random() * (4 - 1) + 1);
			Menu guardarMenus[] = new Menu[numComensales];//vector comodin
			String continuar = "";
			
			Leer.mostrarEnPantalla("\nMesa " + (i + 1));
			Leer.mostrarEnPantalla("La mesa consta de " + numComensales + " comensales");

			for (int j = 0; j < numComensales; j++) {
				int menu = 0;
				do{
					menu = Leer.pedirEntero("Menu de la persona " + (j + 1) + " de la mesa " + (i + 1));
				}while(menu > 20 || menu <= 0);
				guardarMenus[j] = menus[menu - 1];

			}
			mesas[i] = new Mesa(guardarMenus);//guardo la mesa con sus menus en la posicion "i", indice de mesas

			Leer.mostrarEnPantalla("El total a pagar de la mesa " + (i + 1) + " es " + mesas[i].getPrecioTotal() + "€");
			importe = Leer.pedirFloat("Cuanto te ha pagado el cliente?");
			while (importe < mesas[i].getPrecioTotal()) {
				importe = Leer.pedirFloat("Te ha dado menos"
						+ " de lo que tiene que pagar\nCuanto te ha pagado el cliente?");
			}

			continuar = Leer.pedirCadena("Correcto, le tienes que devolver " + (Math.round((importe - mesas[i].getPrecioTotal()) * 100d) / 100d) + "€" //(Math.round((importe - mesas[i].getPrecioTotal()) * 100d) / 100d)
					+ "\nPulsa ENTER para continuar o escribe SALIR para no inscribir más mesas");
			if(continuar.equalsIgnoreCase("SALIR")){
				salir = true;
			}
			
		}
	}
	
	public static void consultarMesas(Mesa mesas[]){
		Boolean salir = false;
		do {
			String continuar = "";
			int pedirMesa = 0;
			pedirMesa = Leer.pedirEntero("Que mesa quieres mostrar");
			if(mesas[pedirMesa - 1] == null) {
				Leer.mostrarEnPantalla("No existe esa mesa");
			}else{
				Leer.mostrarEnPantalla("La mesa " + pedirMesa + " tomó lo siguiente");
				mesas[pedirMesa - 1].visulizarMesa();
			}
			
			continuar = Leer.pedirCadena("\nPulsa ENTER para consultar otra mesa o escribe SALIR para no inscribir más mesas");
			if(continuar.equalsIgnoreCase("SALIR")){
				salir = true;
			}
		} while (!salir);
	}

}
