Ejemplo de Clase Java con un atributo static o atributo de clase: Clase Empleado
Crea una clase Empleado que tenga los siguientes atributos privados:
Nif.
Nombre.
Sueldo base.
Horas extra realizadas en el mes.
Tipo de IRPF (%).
Casado o no.
Número de hijos.
Importe de la hora extra. Este será un atributo static o atributo de clase.
Los objetos Empleado se podrán crear con un constructor por defecto o con un constructor con un solo parámetro correspondiente al DNI.
Además de los métodos getter/setter la clase Empleado tendrá estos métodos:
Método para el cálculo del complemento correspondiente a las horas extra realizadas.
Método para calcular el sueldo bruto (sueldo base + complemento por horas extras)
Método para calcular las retenciones por IRPF. El porcentaje de IRPF se aplica sobre el sueldo bruto, teniendo en cuenta que el porcentaje que hay que aplicar es el tipo menos 2 puntos si el empleado está casado y menos 1 punto adicional por cada hijo que tenga.
Método toString() para mostrar los datos de los empleados de la siguiente forma:
12345678A Lucas Guerrero Arjona
Sueldo Base: 1150.0
Horas Extras: 4
tipo IRPF: 15.0
Casado: S
Número de Hijos: 2
Una vez creada la clase Empleado, la utilizaremos en un programa que lea empleados y los guarde en un array estático. El número total de empleados se pide por teclado. El número máximo de empleados es de 20.
Después de leer los datos de los empleados se pedirá que se introduzca el importe correspondiente al pago por hora extra asignándoselo al atributo estático de la clase.
A continuación el programa mostrará:
- El empleado que más cobra y el que menos
- El empleado que cobra más por horas extra y el que menos.
- Todos los empleados ordenados por salario de menor a mayor.
Solución:
//Clase Empleado
public class Empleado {
   
    private static double pagoPorHoraExtra; //atributo de clase
    private String nif;
    private String nombre;
    private double sueldoBase;
    private int horasExtras;
    private double tipoIRPF;
    private char casado;  //S ó N
    private int numeroHijos;
   
    //Constructor por defecto
    public Empleado() {
    }

    //Constructor con un parámetro
    public Empleado(String nif) {
        this.nif = nif;
    }

    //Métodos get/set
    public char getCasado() {
        return casado;
    }

    public void setCasado(char casado) {
        this.casado = casado;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getTipoIRPF() {
        return tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    //métodos get/set para el atributo static
    public static double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        Empleado.pagoPorHoraExtra = pagoPorHoraExtra;
    }
   
   
    //calcular el importe de las horas extra
    public double calcularImporteHorasExtras(){
        return horasExtras * pagoPorHoraExtra;
    }
   
    //calcular el sueldo bruto
    public double calcularSueldoBruto(){
        return sueldoBase + calcularImporteHorasExtras();
    }
   
    //calcular el importe de las retencion por IRPF
    public double calcularRetencionIrpf(){
        double tipo = tipoIRPF;
        if(casado == 's' || casado == 'S') {
            tipo = tipo - 2; //2 puntos menos si está casado
        }
        tipo = tipo - numeroHijos; //un punto menos por cada hijo
        if(tipo<0){
            tipo = 0;
        }
        return calcularSueldoBruto() * tipo / 100;
    }
   
    //calcular el importe liquido a cobrar
    public double calcularSueldo(){
        return calcularSueldoBruto() - calcularRetencionIrpf();
    }

    //mostrar los datos de un trabajador
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNif: ");
        sb.append(nif);
        sb.append("\nSueldo Base: ");
        sb.append(sueldoBase);
        sb.append("\nHoras Extras: ");
        sb.append(horasExtras);
        sb.append("\ntipo IRPF: ");
        sb.append(tipoIRPF);
        sb.append("\nCasado: ");
        sb.append(casado);
        sb.append("\nNúmero de Hijos: ");
        sb.append(numeroHijos);
        return  sb.toString();
    }
}//Fin de la Clase Empleado


//Clase Principal
import java.io.IOException;
import java.util.Scanner;

public class ProyectoEmpleados {

    final static int MAXIMO_EMPLEADOS = 20;
    static Empleado[] empleados = new Empleado[MAXIMO_EMPLEADOS];
    static int indice = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        double importe;
        Empleado e;
        leerEmpleados();
        if (numeroDeEmpleados() > 0) {

            //mostrar empleados
            System.out.println("\n\nEmpleados introducidos: ");
            mostrar();

            importe = leerImporteHorasExtras();

            //asignar el atributo estático pagoPorHoraExtra
            Empleado.setPagoPorHoraExtra(importe);

            //calcular el empleado que más cobra
            e = empleadoQueMasCobra();
            System.out.println("\n\nEmpleado que más cobra:");
            System.out.println(e);
            System.out.printf("Sueldo: %.2f € %n", e.calcularSueldo());

            //calcular el empleado que menos cobra
            e = empleadoQueMenosCobra();
            System.out.println("\n\nEmpleado que menos cobra:");
            System.out.println(e);
            System.out.printf("Sueldo: %.2f € %n", e.calcularSueldo());

            //calcular el empleado que más cobra por horas extra
            e = empleadoQueMasCobraPorHorasExtras();
            System.out.println("\n\nEmpleado que más cobra por horas extras:");
            System.out.println(e);
            System.out.printf("Total horas extras: %.2f €" , e.calcularImporteHorasExtras());

            //calcular el empleado que menos cobra por horas extra
            e = empleadoQueMenosCobraPorHorasExtras();
            System.out.println("\n\nEmpleado que menos cobra por horas extras:");
            System.out.println(e);
            System.out.printf("Total horas extras: %.2f €" , e.calcularImporteHorasExtras());

            //ordenar por salario de menor a mayor
            ordenarPorSalario();
            System.out.println("\n\nEmpleados ordenados por salario:");
            mostrarEmpleadosYSalarios();

        }
    }

    //método para leer todos los empleados y guardarlos en el array
    public static void leerEmpleados() throws IOException {
        Empleado e;
        String dni, nombre;
        double sueldoBase;
        int horasExtras;
        double tipoIRPF;
        char casado;  // S ó N
        int numeroHijos;
        int i, N;

        do {
            System.out.print("Número de empleados? ");
            N = sc.nextInt();
        } while (N < 0 || N > MAXIMO_EMPLEADOS);
       
        for (i = 1; i <= N; i++) {
            sc.nextLine(); //limpiar el intro
            System.out.println("Empleado " + i);
            System.out.print("Nif: ");
            dni = sc.nextLine();
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            System.out.print("Sueldo Base: ");
            sueldoBase = sc.nextDouble();
            System.out.print("Horas extra: ");
            horasExtras = sc.nextInt();
            System.out.print("Tipo de IRPF: ");
            tipoIRPF = sc.nextDouble();
            System.out.print("Casado (S/N): ");
            casado = (char) System.in.read();
            System.out.print("Número de hijos: ");
            numeroHijos = sc.nextInt();

            e = new Empleado(dni); //crear una nueva instancia de empleado

            e.setNombre(nombre);
            e.setSueldoBase(sueldoBase);
            e.setHorasExtras(horasExtras);
            e.setTipoIRPF(tipoIRPF);
            e.setCasado(Character.toUpperCase(casado));
            e.setNumeroHijos(numeroHijos);

            empleados[indice] = e; //se añade el empleado al array
            indice++;
        }
    }

    //método para mostrar todos los empleados
    public static void mostrar() {
        for (int i = 0; i < indice; i++) {
            System.out.println(empleados[i]);
        }
    }

    //método para pedir el importe de la hora extra
    public static double leerImporteHorasExtras() {
        double importe;
        System.out.print("Introduce el importe a pagar por cada hora extra: ");
        importe = sc.nextDouble();
        return importe;
    }

    //método que devuelve el número total de empleados
    public static int numeroDeEmpleados() {
        return indice;
    }

    //método que devuelve el empleado que más cobra
    public static Empleado empleadoQueMasCobra() {
        Empleado mayor = empleados[0];
        for (int i = 1; i < indice; i++) {
            if (empleados[i].calcularSueldo() > mayor.calcularSueldo()) {
                mayor = empleados[i];
            }
        }
        return mayor;
    }

    //método que devuelve el empleado que menos cobra
    public static Empleado empleadoQueMenosCobra() {
        Empleado menor = empleados[0];
        for (int i = 1; i < indice; i++) {
            if (empleados[i].calcularSueldo() < menor.calcularSueldo()) {
                menor = empleados[i];
            }
        }
        return menor;
    }

    //método que devuelve el empleado que más cobra por horas extra
    public static Empleado empleadoQueMasCobraPorHorasExtras() {
        Empleado mayor = empleados[0];
        for (int i = 1; i < indice; i++) {
            if (empleados[i].calcularImporteHorasExtras() > mayor.calcularImporteHorasExtras()) {
                mayor = empleados[i];
            }
        }
        return mayor;
    }

    //método que devuelve el empleado que menos cobra por horas extra
    public static Empleado empleadoQueMenosCobraPorHorasExtras() {
        Empleado menor = empleados[0];
        for (int i = 1; i < indice; i++) {
            if (empleados[i].calcularImporteHorasExtras() < menor.calcularImporteHorasExtras()) {
                menor = empleados[i];
            }
        }
        return menor;
    }

    //método para ordenar todos los empleados por su salario de menor a mayor
    public static void ordenarPorSalario() {

        int i, j;
        Empleado aux;
        for (i = 0; i < indice - 1; i++) {
            for (j = 0; j < indice - i - 1; j++) {
                if (empleados[j + 1].calcularSueldo() < empleados[j].calcularSueldo()) {
                    aux = empleados[j + 1];
                    empleados[j + 1] = empleados[j];
                    empleados[j] = aux;
                }
            }
        }
    }

    //método para mostrar los datos de cada empleado junto con su sueldo
    public static void mostrarEmpleadosYSalarios() {
        for (int i = 0; i < indice; i++) {
            System.out.println(empleados[i]);
            System.out.printf("Sueldo: %.2f € %n" , empleados[i].calcularSueldo());
        }
    }
}//Fin de la Clase Principal
