/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorriente {
	private String numCuenta;
	private Double saldo;
	private String nombreCuenta;

	public CuentaCorriente(String numCuenta, Double saldo, String nombreCuenta) {
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.nombreCuenta = nombreCuenta;
	}//Constructor

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
	public void ingresaEfectivo(double cantidad) {
		saldo += cantidad;
	}//Ingresar

	/**
	 * @return the nombreCuenta
	 */
	public String getNombreCuenta() {
		return nombreCuenta;
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
			return true;
		} else {
			return false;
		}
	}//Retirar

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CuentaCorriente [numCuenta=" + numCuenta + ", saldo=" + saldo + "€, nombreCuenta=" + nombreCuenta + "]";
	}

}// Class
