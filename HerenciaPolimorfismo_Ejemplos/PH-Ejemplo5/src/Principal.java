import utilidades.Leer;
public class Principal {

	public static void main(String [] args) {
		int alto, largo, grosor;
		Leer.mostrarEnPantalla("Vamos a ver la dimension de una línea: ");
		VerUnaDimension lin1 = new VerUnaDimension(); // aqui se ejecuta el constructor de la clase Linea
		lin1.verLinea();
		
		Leer.mostrarEnPantalla("\nVamos a ver las dimensiones de un rectangulo: ");
		VerDosDimensiones rect1 = new VerDosDimensiones();//se ejecuta el constructor de la clase Area
								// que llama primero al constructor de la clase Linea
		rect1.verArea();
		
		Leer.mostrarEnPantalla("\nVamos a ver las dimensiones de una caja: ");
		VerTresDimensiones caja1 = new VerTresDimensiones();//primero se ejecuta el constructor de la clase AreaPoli
									// que llama al constructor de la clase Area
									//que llama al constructor de la clase Linea
		caja1.verVolumenPoli();
		
		Leer.mostrarEnPantalla("\nPedimos largo, alto y grosor de una caja." +
				"\nVeremos lo que ocupa una linea de esa caja, el area" +
				" de una de sus caras y el espacio que ocupa la caja.");
		
		largo=Leer.pedirEntero("\nLargo de una cara de la caja?  ");
		
		alto=Leer.pedirEntero("\nAlto de esa cara de la caja?  ");
		
		grosor=Leer.pedirEntero("\nGrosor de la caja?  ");
		VerTresDimensiones caja2 = new VerTresDimensiones(largo, alto, grosor);
		
		caja2.verLinea();
		caja2.verArea();
		caja2.verVolumenPoli();
	}//main

}//class
