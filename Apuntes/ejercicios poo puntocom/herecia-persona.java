Ejemplo de relaciones entre clases Java: Relación de Composición. Clase Persona y Clase Fecha
Crea una clase Persona con los siguientes atributos: nombre, dirección, códigoPostal, ciudad y fechaNacimiento.
El atributo fechaNacimiento es un objeto de la clase Fecha creada en esta entrada.
Las clases Persona y Fecha tienen por tanto una relación de composición.

A la clase Fecha que ya tenemos le añadiremos un método boolean esMayorQue(Fecha f) que nos será útil en este ejercicio. Este método devuelve true si la fecha que contiene el objeto es mayor que la fecha que recibe como parámetro y false en caso contrario.
La clase Persona contendrá los siguientes métodos:
Constructor
Métodos get y set
Método boolean esMayorDeEdad() que devuelve true si la persona es mayor de edad y false en caso contrario. Para sabre si la persona es mayor de edad se comparará la fecha de nacimiento con la fecha actual obtenida del sistema.
Método toString() que muestre los datos de la siguiente forma:
Nombre: Adolfo Pérez Clavarana
Fecha Nacimiento: 12-07-1987
Dirección: C/ La Isla 19 2-B
03030 Elche
La clase Persona se va a utilizar en un programa que pida por teclado los datos de varias personas y las guarde en un ArrayList de objetos de tipo Persona y a continuación muestre información sobre ellas.
La clase principal del proyecto y el método main serán estos:
public class Main {
    //se crea el ArrayList de Personas
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //se leen las personas y se introducen en el ArrayList
        leerPersonas();
        if (numeroDePersonas() > 0) {
            //se muestran todas las personas introducidas
            System.out.println("\nPersonas introducidas: ");
            mostrar();
            //se muestra la persona de mayor edad
            System.out.println("\nPersona de mayor edad: ");
            System.out.println(personaMayorEdad());
            //se muestran todas las personas que viven en Elche
            System.out.println("\nNúmero de personas que viven en Elche: "
                                          + cuantasPersonasVivenEn(“Elche”));
            //se muestra el número de personas mayores de edad
            System.out.println("\nNúmero de personas mayores de edad : "
                                          + personasMayoresDeEdad());         
        }
    }
     //Resto de métodos
}
A continuación del método main se escribirá el código del resto de métodos:
Método leerPersonas(): pide por teclado los datos de las personas y las añade al array.
Método mostrar(): muestra los datos de todas las personas introducidas.
Método númeroDePersonas(): devuelve el número de personas que contiene el array.
Método personaMayorEdad(): devuelve la persona de mayor edad. Si hay varias devuelve la primera encontrada.
Método cuantasPersonasVivenEn(String): método que recibe el nombre de una población y devuelve cuántas de esas personas viven en ella.
Método personasMayoresDeEdad(): método que devuelve cuántas de esas personas son mayores de edad.
Solución:
///////////////////////////////////////////////////////////////////////////////////////////
//Clase Fecha
///////////////////////////////////////////////////////////////////////////////////////////
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

    //Métodos get y set
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

    //Comprobar si la fecha es correcta
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

    //Comprobar si el año es bisiesto
    //Método privado invocado desde el método fechaCorrecta
    private boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }

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

    //Método para comprobar si la fecha es mayor que la que se recibe
    public boolean esMayorQue(Fecha f){
        if(año > f.año) {
            return true;
        }
        else if(año==f.año && mes > f.mes) {
            return true;
        }
        else if(año==f.año && mes == f.mes && dia > f.dia) {
            return true;
        }
        return false;
    }
   
    //Método para mostrar la fecha
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
} //Final de la Clase Fecha


///////////////////////////////////////////////////////////////////////////////////////////
//Clase Persona
///////////////////////////////////////////////////////////////////////////////////////////
import java.util.Calendar;

public class Persona {

    private String nombre;
    private String direccion;
    private int codigoPostal;
    private String ciudad;
    private Fecha fechaNacimiento;

    //Constructor por defecto
    public Persona() {
        fechaNacimiento = new Fecha();
    }

    //Métodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fecha) {
        fechaNacimiento.setDia(fecha.getDia());
        fechaNacimiento.setMes(fecha.getMes());
        fechaNacimiento.setAño(fecha.getAño());
    }

    //Método para mostrar los datos de las personas según el formato pedido
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ");
        sb.append(nombre);
        sb.append("\nFecha de Nacimiento: ");
        sb.append(fechaNacimiento);
        sb.append("\nDireccion: ");
        sb.append(direccion);
        sb.append("\n");
        sb.append(codigoPostal);
        sb.append("\n");
        sb.append(ciudad);
        sb.append("\n");
        return sb.toString();
    }

    //Método que comprueba si la persona es mayor de edad
    public boolean esMayorDeEdad() {
        Calendar hoy = Calendar.getInstance();
        int añoActual = hoy.get(Calendar.YEAR);
        int mesActual = hoy.get(Calendar.MONTH) + 1;
        int diaActual = hoy.get(Calendar.DAY_OF_MONTH);
        if (añoActual - fechaNacimiento.getAño() > 18) {
            return true;
        } else if (añoActual - fechaNacimiento.getAño() == 18 &&
                      mesActual > fechaNacimiento.getMes()) {
            return true;
        } else if (añoActual - fechaNacimiento.getAño() == 18 &&
                     mesActual == fechaNacimiento.getMes() &&
                     diaActual >= fechaNacimiento.getDia()) {
            return true;
        }
        return false;
    }
} //Final de la clase Persona

///////////////////////////////////////////////////////////////////////////////////////////
//Clase Principal
///////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //se crea el ArrayList de Personas
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //se leen las personas y se introducen en el ArrayList
        leerPersonas();
        if (numeroDePersonas() > 0) {
            //se muestran todas las personas introducidas
            System.out.println("\nPersonas introducidas: ");
            mostrar();
            //se muestra la persona de mayor edad
            System.out.println("\nPersona de mayor edad: ");
            System.out.println(personaMayorEdad());
            //se muestran todas las personas que viven en Elche
            System.out.println("\nNúmero de personas que viven en Elche: "
                                          + cuantasPersonasVivenEn(“Elche”));
            //se muestra el número de personas mayores de edad
            System.out.println("\nNúmero de personas mayores de edad : "
                                          + personasMayoresDeEdad());         
        }
    }

    //Método que lee los datos de cada persona y las añade al ArrayList
    public static void leerPersonas() {

        String nombre, direccion, ciudad;
        Fecha fecha;
        Persona p;
        int codigoPostal, N, i, dia, mes, año;

        do {
            System.out.print("Número de personas? ");
            N = sc.nextInt();
        } while (N < 0);
        sc.nextLine(); //limpiar el buffer de entrada

        for (i = 1; i <= N; i++) {
            System.out.println("Persona " + i);
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            do {
                System.out.println("Fecha de Nacimiento: ");
                System.out.print("Dia: ");
                dia = sc.nextInt();
                System.out.print("Mes: ");
                mes = sc.nextInt();
                System.out.print("Año: ");
                año = sc.nextInt();
                fecha = new Fecha(dia, mes,año);
            } while (!fecha.fechaCorrecta());

            sc.nextLine();
            System.out.print("Dirección: ");
            direccion = sc.nextLine();
            System.out.print("Codigo Postal: ");
            codigoPostal = sc.nextInt();
            sc.nextLine();
            System.out.print("Ciudad: ");
            ciudad = sc.nextLine();

            //se crea una nueva instancia de Persona
            p = new Persona();
            p.setNombre(nombre);
            p.setFechaNacimiento(fecha);
            p.setDireccion(direccion);
            p.setCodigoPostal(codigoPostal);
            p.setCiudad(ciudad);

            //se añade el objeto al array
            personas.add(p);
        }
    }

    //Mostrar todas las personas
    public static void mostrar() {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i));
        }
    }

    //Devuelve el número de personas que contiene el array
    public static int numeroDePersonas() {
        return personas.size();
    }

    //Devuelve la persona de mayor edad
    //En este método se utiliza el método esMayorQue() añadido a la clase Fecha
    public static Persona personaMayorEdad() {
        Persona aux = personas.get(0);
        for (int i = 1; i < personas.size(); i++) {
            if (personas.get(i).getFechaNacimiento().esMayorQue(aux.getFechaNacimiento())) {
                aux = personas.get(i);
            }
        }
        return aux;
    }

    //Calcula y devuelve el número de personas que viven
    //en la ciudad que se recibe como parámetro
    public static int cuantasPersonasVivenEn(String ciudad) {
        int cont = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCiudad().equalsIgnoreCase(ciudad)) {
                cont++;
            }
        }
        return cont;
    }

    //Calcula y devuelve el número de personas mayores de edad
    public static int personasMayoresDeEdad() {
        int cont = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).esMayorDeEdad()) {
                cont++;
            }
        }
        return cont;
    }
} //Fin de la Clase Principal
