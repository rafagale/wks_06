/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorriente {
	private String numCuenta;
	private Double saldo;
	private String nombreCliente;
	private static int totalCuentas=1;

	public CuentaCorriente() {

	}

	public CuentaCorriente(Double saldo, String nombreCuenta) {
		this.numCuenta=""+totalCuentas;
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

	public void ingresaEfectivo(double cantidad) {
		saldo += cantidad;
	}// Ingresar


	public String getNombreCuenta() {
		return nombreCliente;
	}

	public boolean retiraEfectivo(double cantidad) {
		if (cantidad <= saldo) {
			saldo -= cantidad;
			return true;
		} else {
			return false;
		}
	}// Retirar

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
		if (unaCuenta.getNombreCuenta().equals(otraCuenta.getNombreCuenta())) {
			cuentaFusionada.saldo = unaCuenta.getSaldo() + otraCuenta.getSaldo();
		}
		return cuentaFusionada;
	}// fusiona

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}// Class
