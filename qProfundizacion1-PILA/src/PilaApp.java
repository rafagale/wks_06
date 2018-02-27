
public class PilaApp {

	public static void main(String[] args) {
		Pila origen = new Pila();
		Pila destino = new Pila();
		for (int i = 0; i < 20; i++){
			origen.apilar();
		}
		origen.copiar(destino);
		for (int i = origen.getCima()-1; i >= 0; i--){
			if(!origen.estaVacia()){
				Leer.mostrarEnPantalla("" + origen.desApilar());
				//Leer.mostrarEnPantalla(origen.pop().toString());
			}
		}
		if(origen.estaVacia()){
			Leer.mostrarEnPantalla("La pila origen esta vacia");
		}
		Leer.mostrarEnPantalla("Vamos a ver la pila destino");
		for (int i = destino.getCima()-1; i >= 0; i--){
			if(!destino.estaVacia()){
				Leer.mostrarEnPantalla("" + destino.desApilar());
			}
		}
	}// main

}// class
