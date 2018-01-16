/**
 * 
 */

/**
 * @author yo
 *
 */
public class GestionCuentas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuentacorriente [] cuentas;
		cuentas = new Cuentacorriente[10];
		String cliente;
		Double saldo;
		Leer.mostrarEnPantalla(cuentas.toString());
		for (int i=0; i<cuentas.length; i++){
			Leer.mostrarEnPantalla(""+cuentas[i]);
		//	Leer.mensaje(cuentas[i].visualiza());
		//	Leer.mensaje(cuentas[i].toString());
		}
		for (int i=0; i<2; i++){
			cliente=Leer.pedirCadena("Nombre del cliente ");
			saldo=Leer.pedirDouble("Saldo inicial ");
			cuentas[i]=new Cuentacorriente(saldo, cliente);
		}
		Leer.mostrarEnPantalla(cuentas.toString());
		for (int i=0; i<cuentas.length; i++){
			Leer.mostrarEnPantalla(""+cuentas[i]);
			if (i<Cuentacorriente.getSiguiente()-1){
				//Leer.mostrarEnPantalla(cuentas[i].visualiza());
				System.out.println((cuentas[i]));
			}
		}
		//Menu
		int opcion;
		do {
			Leer.mostrarEnPantalla(" 1.- Crear cuenta");
			Leer.mostrarEnPantalla(" 2.- Visualizar las cuentas");
			Leer.mostrarEnPantalla(" 3.- Ingresar en una cuenta");
			Leer.mostrarEnPantalla(" 4.- Sacar de una cuenta");
			Leer.mostrarEnPantalla(" 0.- Fin");

			opcion=Leer.pedirEntero("Elija opción ");
			Double importe= -1.0;
			String cuenta;
			Boolean existe=false, saldosuf;
			switch(opcion){
			case 1://Crear cuenta
				if(Cuentacorriente.getSiguiente()==11){
					Leer.mostrarEnPantalla("Límite de cuentas alcanzado");
				}else{
					cliente=Leer.pedirCadena("Nombre del cliente ");
					saldo=Leer.pedirDouble("Saldo inicial ");
					cuentas[Cuentacorriente.getSiguiente()-1]=new Cuentacorriente(saldo, cliente);					
				}
				break;
			case 2://visualizar cuentas
				for(int i=0; i<cuentas.length; i++){
					if (cuentas[i]!=null){
						Leer.mostrarEnPantalla(cuentas[i].visualiza());
					}
				}
				break;
			case 3://ingresar en cuenta
				while (importe < 0){
					importe=Leer.pedirDouble("Teclee importe a ingresar (mayor que cero: ");
				}
				cuenta=Leer.pedirCadena("Código de cuenta en la que ingresar");
				for(int i=0; i<Cuentacorriente.getSiguiente()-1; i++){
					if( cuentas[i].getNumero().equals(cuenta)){
						cuentas[i].ingresarEfectivo(importe);
						existe=true;
					}
				}
				if (!existe){
					Leer.mostrarEnPantalla("Cuenta no existente "+cuenta);
				}
				break;
			case 4://sacar de cuenta
				while (importe < 0){
					importe=Leer.pedirDouble("Teclee importe a retirar (mayor que cero: ");
				}
				cuenta=Leer.pedirCadena("Código de cuenta en la que ingresar");
				for(int i=0; i<Cuentacorriente.getSiguiente()-1; i++){
					if( cuentas[i].getNumero().equals(cuenta)){
						saldosuf=cuentas[i].retirarEfectivo(importe);
						if(!saldosuf){
							Leer.mostrarEnPantalla("No hay saldo suficiente");
						}
						existe=true;
					}
				}
				if (!existe){
					Leer.mostrarEnPantalla("Cuenta no existente "+cuenta);
				}
				break;
			}
		}while (opcion!=0);
	}
}
