Clase Fecha en Java
Crear una Clase Fecha en Java. La clase tendrá tres atributos privados dia, mes y año de tipo int. La clase contendrá los siguientes métodos:
Constructor por defecto.
Constructor con tres parámetros para crear objetos con valores iniciales.
Métodos set y get para asignar y obtener los valores de los atributos de la clase.
Método fechaCorrecta() que comprueba si la fecha es correcta. Devuelve un valor de tipo boolean indicando si la fecha es correcta o no. Este método a su vez utilizará un método privado de la clase llamado esBisiesto que calcula si el año es o no bisiesto. El método esBisiesto devuelve true si el año es bisiesto y false si no lo es.
Método diaSiguiente() que cambia la fecha actual por la del día siguiente. El objeto de la clase Fecha al que se le aplique este método deberá quedar siempre en un estado consistente, es decir, la nueva fecha deberá ser correcta.
Modificar el método toString() heredado de Object para mostrar las fechas de la forma dd-mm-aaaa. El día y el mes se deben mostrar con dos cifras. Si el dia o el mes tienen solo una cifra se escribirá un cero delante. Por ejemplo si la fecha es dia=1, mes=6, año= 2015 la fecha que se mostrará será: 01-06-2015
Escribe un programa para probar la clase Fecha. El método diaSiguiete() pruébalo dentro de un bucle que imprima la fecha durante cada iteración del bucle.
Solución:
//Clase Fecha Java
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    //setters y getters
    public void setDia(int d) {
        dia = d;
    }
    public void setMes(int m) {
        mes = m;
    }
    public void setAño(int a) {
        año = a;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAño() {
        return año;
    }

    //Método para comprobar si la fecha es correcta
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = año > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }

    //Método privado para comprobar si el año es bisiesto
    //Este método lo utiliza el método fechaCorrecta
    private boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }

    //Método que modifica la fecha cambiándola por la del día siguiente
    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                año++;
            }

        }
    }

    //Método toString para mostrar la fecha
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia < 10) {
            sb.append("0");
        }
        sb.append(dia);
        sb.append("-");
        if (mes < 10) {
            sb.append("0");
        }
        sb.append(mes);
        sb.append("-");
        sb.append(año);
        return sb.toString();
    }
} //Fin de la clase Fecha

Un programa para probar la clase Fecha podría ser este:
public class ProyectoFecha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d, m, a;

        //Se pide por teclado el dia, mes y año
        System.out.println("Introduce fecha: ");
        System.out.print("dia: ");
        d = sc.nextInt();
        System.out.print("mes: ");
        m = sc.nextInt();
        System.out.print("año: ");
        a = sc.nextInt();

        //Se crea un objeto Fecha utilizando el consructor con parámetros
        Fecha fecha = new Fecha(d,m,a);

        if (fecha.fechaCorrecta()) { //si la fecha es correcta

           //Se muestra utilizando el método toString()
            System.out.println("Fecha introducida: " + fecha);

            //Se muestran los 10 días siguientes utilizando el método diaSiguiente()
            System.out.println("Los 10 días siguientes son:");
            for (int i = 1; i <= 10; i++) {
                fecha.diaSiguiente();
                System.out.println(fecha);
            }

        } else { //Si la fecha no es correcta
            System.out.println("Fecha no valida");
        }
    }
}

Ejemplo de ejecución del programa:

Introduce fecha:
dia: 28
mes: 12
año: 2015
Fecha introducida: 28-12-2015
Los 10 días siguientes son:
29-12-2015
30-12-2015
31-12-2015
01-01-2016
02-01-2016
03-01-2016
04-01-2016
05-01-2016
06-01-2016
07-01-2016
