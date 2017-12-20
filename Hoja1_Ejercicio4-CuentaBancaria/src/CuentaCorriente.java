/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorriente {
	private String numCuenta;
	private double saldo;

	CuentaCorriente(String numCuenta, double saldo) {
		numCuenta="Amancio Ortega";
		saldo=95541554;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}


	/**
	 * metodo para ingresar efectivo
	 * 
	 * @param cantidad
	 *            se sumara al saldo
	 * @return el saldo
	 */
	public double ingresaEfectivo(double cantidad) {
		saldo += cantidad;
		return saldo;
	}

	/**
	 * metodo para retirar efectivo
	 * 
	 * @param cantidad
	 *            se restara del saldo
	 * @return true si hay dinero. false si no hay dinero
	 */
	public boolean retiraEfectivo(double cantidad) {
		if (cantidad <= saldo) {
			saldo -= cantidad;
			System.out.println("Se ha ingresado " + cantidad + " en la cuenta");
			return true;
		} else {
			System.out.println("No hay tanto dinero en la cuenta");
			return false;
		}
	}

	/**
	 * Mostrará por pantalla la información de la cuenta corriente: Número de
	 * cuenta y saldo.
	 */

}// Class
