/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorriente {
	private String numCuenta;
	private Double saldo;
	private String nombreCliente;
	private static int totalCuentasAbiertas = 1;
	private static int totalCuentasCreadas = 0;
	public CuentaCorriente() {
	}

	public CuentaCorriente(Double saldo, String nombreCuenta) {
		this.numCuenta = "" + totalCuentasCreadas;
		this.saldo = saldo;
		this.nombreCliente = nombreCuenta;
		totalCuentasAbiertas++;
		totalCuentasCreadas++;
	}// Constructor con parámetros

	public static int getTotalCuentasAbiertas() {
		return totalCuentasAbiertas;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNombreCuenta() {
		return nombreCliente;
	}

	public void ingresaEfectivo(double cantidad) {
		saldo += cantidad;
	}// Ingresar
	
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
		return "CuentaCorriente [numCuenta=" + numCuenta + ", saldo=" + saldo + "€, nombreCliente=" + nombreCliente			+ "]";
	}

	private void cerrarCuenta() {
		nombreCliente += "(CERRADA)";
		saldo = 0.0;
		totalCuentasAbiertas--;
	} // cerrarCuenta

	/**
	 * @return the totalCuentasCreadas
	 */
	public static int getTotalCuentasCreadas() {
		return totalCuentasCreadas;
	}

	public static CuentaCorriente fusiona(CuentaCorriente unaCuenta, CuentaCorriente otraCuenta) {
		Double saldoDeFusion;
		if (unaCuenta.nombreCliente.equals(otraCuenta.nombreCliente)) {
			if (!unaCuenta.numCuenta.equals(otraCuenta.numCuenta)) {
				saldoDeFusion = (unaCuenta.saldo + otraCuenta.saldo);
				CuentaCorriente cuentaFusionada = new CuentaCorriente(saldoDeFusion, unaCuenta.nombreCliente);
				cuentaFusionada.numCuenta = "" + (totalCuentasCreadas);
				totalCuentasCreadas++;
				unaCuenta.cerrarCuenta();
				otraCuenta.cerrarCuenta();
				return cuentaFusionada;
			} else {
				return null;
			}
		}
		return null;
	}// fusiona
	

}// Class
