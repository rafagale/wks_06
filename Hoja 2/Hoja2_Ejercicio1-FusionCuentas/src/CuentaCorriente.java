/**
 * 
 * @author Rafa
 *
 */
public class CuentaCorriente {
	private String numCuenta;
	private Double saldo;
	private String nombreCliente;
	private static int totalCuentas = 1;

	public CuentaCorriente() {
	}

	public CuentaCorriente(Double saldo, String nombreCuenta) {
		this.numCuenta = "" + totalCuentas;
		this.saldo = saldo;
		this.nombreCliente = nombreCuenta;
		totalCuentas++;
	}// Constructor con parámetros

	public static int getTotalCuentas() {
		return totalCuentas;
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

	public void cerrarCuenta() {
		nombreCliente += "(CERRADA)";
		saldo = 0.0;
		totalCuentas--;
	} // cerrarCuenta

	public static CuentaCorriente fusiona(CuentaCorriente unaCuenta, CuentaCorriente otraCuenta) {
		Double saldoDeFusion;
		if (unaCuenta.nombreCliente.equals(otraCuenta.nombreCliente)) {
			if (!unaCuenta.numCuenta.equals(otraCuenta.numCuenta)) {
				saldoDeFusion = (unaCuenta.saldo + otraCuenta.saldo);
				CuentaCorriente cuentaFusionada = new CuentaCorriente(saldoDeFusion, unaCuenta.nombreCliente);
				cuentaFusionada.numCuenta = "" + (totalCuentas-1);
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
