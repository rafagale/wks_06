/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorriente {
	private String numCuenta="";
	private Double saldo;
	private String nombreCliente;
	private static int totalCuentas=0;

	public CuentaCorriente() {

	}

	public CuentaCorriente(Double saldo, String nombreCuenta) {
		for (int i = 0; i < totalCuentas; i++) {
			this.numCuenta = "" + i ;
		}
		this.saldo = saldo;
		this.nombreCliente = nombreCuenta;
		totalCuentas++; 
	}// Constructor

	/**
	 * @return the totalCuentas
	 */
	public static int getTotalCuentas() {
		return totalCuentas;
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
	public void ingresaEfectivo(double cantidad) {
		saldo += cantidad;
	}// Ingresar

	/**
	 * @return the nombreCuenta
	 */
	public String getNombreCuenta() {
		return nombreCliente;
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
	}// Retirar

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CuentaCorriente [numCuenta=" + numCuenta + ", saldo=" + saldo + "€, nombreCliente=" + nombreCliente + "]";
	}

	public void cerrarCuenta() {
		nombreCliente = nombreCliente + "(CERRADA)";
		saldo = 0.0;
		totalCuentas--; 
	}

	public static CuentaCorriente fusiona(CuentaCorriente unaCuenta, CuentaCorriente otraCuenta) {
		CuentaCorriente cuentaFusionada = null;
		if (unaCuenta.getNombreCuenta() == otraCuenta.getNombreCuenta()) {
			cuentaFusionada.saldo = unaCuenta.getSaldo() + otraCuenta.getSaldo();
		}
		return cuentaFusionada;
	}// fusiona

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}// Class
