/**
 * 
 * @author Rafa
 *
 */
public class Fecha {

	private int dia;
	private int mes;
	private int anio;

	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}// Constructor

	public boolean esBisiesto() {
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			return true;
		} else {
			return false;
		}

	}// Bisiesto

	public boolean esCorrecta() {
		int numDiasMes;
		if (anio < 0) {
			return false;
		}
		if (mes < 1 || mes > 12) {
			return false;
		}
		if (dia < 1 || dia > 31) {
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
				numDiasMes = 31;
			} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				numDiasMes = 30;
				if (dia > numDiasMes) {
					return false;
				}
			} else if (mes == 2 && !esBisiesto()) {
				numDiasMes = 28;
				if (dia > numDiasMes) {
					return false;
				}
			} else if (mes == 2 && esBisiesto()) {
				numDiasMes = 29;
				if (dia > numDiasMes) {
					return false;
				}
			}
			return false;
		} else {
			return true;
		}
	} // Fechacorrecta

	/**
	 * 
	 * @returnuna cadena que contiene el mes con letras: enero, febrero, marzo,
	 *            etc.
	 */
	public String getCadenaMes() {
		String nombreMes = "";
		if (mes == 1) {
			nombreMes = "Enero";
		} else if (mes == 2) {
			nombreMes = "Febrero";
		} else if (mes == 3) {
			nombreMes = "Marzo";
		} else if (mes == 4) {
			nombreMes = "Abril";
		} else if (mes == 5) {
			nombreMes = "Mayo";
		} else if (mes == 6) {
			nombreMes = "Junio";
		} else if (mes == 7) {
			nombreMes = "Julio";
		} else if (mes == 8) {
			nombreMes = "Agosto";
		} else if (mes == 9) {
			nombreMes = "Septiembre";
		} else if (mes == 10) {
			nombreMes = "Octubre";
		} else if (mes == 11) {
			nombreMes = "Noviembre";
		} else if (mes == 12) {
			nombreMes = "Diciembre";
		}
		return nombreMes;
	} // getCadenaMes

	/**
	 * 
	 * @return el n�mero de d�as que tiene el mes
	 */
	public int getDiasMes() {
		int numDiasMes = 0;
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			numDiasMes = 31;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			numDiasMes = 30;
		} else if (mes == 2 && !esBisiesto()) {
			numDiasMes = 28;
		} else if (mes == 2 && esBisiesto()) {
			numDiasMes = 29;
		}
		return numDiasMes;
	}// getDiasMes

	/**
	 * 
	 * @return cadena con la fecha en formato'dd-mm-yyyy'.
	 */
	public String getCadenaFecha1() {
		String fecha1;
		fecha1 = dia + "/" + mes + "/" + anio;
		return fecha1;
	}// getCadenaFecha1

	/**
	 * 
	 * @return cadena con la fecha en formato �5 de Mayo de 2016�.
	 */
	public String getCadenaFecha2() {
		String fecha2;
		fecha2 = dia + " de " + getCadenaMes() + " de " + anio;
		return fecha2;
	}// getCadenaFecha2

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnyo(int anio) {
		this.anio = anio;
	}

	
/*	while (!fechaBien){ //Filtrado
		System.out.println("Dia");
		dia = sc.nextInt();
		if (dia<1 || dia>31){
			fechaBien=false;
		}
		System.out.println("Mes");
		mes = sc.nextInt();
		if (mes==1 || mes ==3 || mes==5 || mes==7  || mes==8 || mes==10 || mes==12){
			numDiasMes=31;
			fechaBien=true;
		}else if (mes==4 || mes ==6 || mes==9 || mes==11){
			numDiasMes=30;
			if (dia>numDiasMes){
				fechaBien=false;
			}else{
				fechaBien=true;
			}
		}else if (mes==2){
			numDiasMes=28;
			if (dia>numDiasMes){
				fechaBien=false;
			}else{
				fechaBien=true;
			}
		}
		System.out.println("A�o");
		anyo = sc.nextInt();
		if (anyo<1900 || anyo>2020){
			fechaBien=false;
		}*/
	
	
}// Class