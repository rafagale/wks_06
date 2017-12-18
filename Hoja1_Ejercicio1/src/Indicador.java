
public class Indicador {
    private int capacidadmax=0;
    private int capacidadmin=0;
    private int valorActual=0;
    private double resultado;

    public int incrementarUnValor(int cantidad){
	int valorSumado=0;
	//String valor;
	if(cantidad>0){
	    valorSumado=cantidad;
	    if(valorActual + cantidad > capacidadmax){
		    valorSumado = (capacidadmax - valorActual);
		    valorActual = capacidadmax;
		}else{
		    valorActual = valorActual +cantidad;
		}
	}
	//valor = String.valueOf(valorSumado);
	return valorSumado;
    }//incrementarUnValor
    //-------------------------------------------------------------------
    public int reduceUnValor(int cantidad){
	int valorRestado=0;
	//String valor;
	if(cantidad>0){
	    valorRestado=cantidad;
	    if(valorActual - cantidad < capacidadmin){
		    valorRestado = valorActual;
		    valorActual = capacidadmin;
		}else{
		    valorActual = valorActual -cantidad;
		}
	}
	//valor = String.valueOf(valorSumado);
	return valorRestado;
    }//incrementarUnValor
    //-------------------------------------------------------------------
    public int getCapacidadmax() {
	return capacidadmax;
    }

    public void setCapacidadmax(int capacidadmax) {
	this.capacidadmax = capacidadmax;
    }



    public int getCapacidadmin() {
	return capacidadmin;
    }



    public void setCapacidadmin(int capacidadmin) {
	this.capacidadmin = capacidadmin;
    }



    public int getValorActual() {
	return valorActual;
    }



    public void setValorActual(int valorActual) {
	if(valorActual > capacidadmax){
	    this.valorActual = capacidadmax;
	}else{
	    this.valorActual = valorActual;
	}
    }//



    public double getResultado() { //Porcentaje
	if (valorActual>=capacidadmin && valorActual<=capacidadmax){
	    resultado = ((double)valorActual/capacidadmax)*100;
	}
	return (int)resultado; //Muestra el porcentaje en caso de que este bien escrito
    }

}
