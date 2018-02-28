5) Crearemos una clase llamada Serie con las siguientes características:

Sus atributos son titulo, numero de temporadas, entregado, genero y creador.
Por defecto, el numero de temporadas es de 3 temporadas y entregado false. El resto de atributos serán valores por defecto según el tipo del atributo.
Los constructores que se implementaran serán:
Un constructor por defecto.
Un constructor con el titulo y creador. El resto por defecto.
Un constructor con todos los atributos, excepto de entregado.
Los métodos que se implementara serán:
Métodos get de todos los atributos, excepto de entregado.
Métodos set de todos los atributos, excepto de entregado.
Sobrescribe los métodos toString.
Crearemos una clase Videojuego con las siguientes características:

Sus atributos son titulo, horas estimadas, entregado, genero y compañia.
Por defecto, las horas estimadas serán de 10 horas y entregado false. El resto de atributos serán valores por defecto según el tipo del atributo.
Los constructores que se implementaran serán:
Un constructor por defecto.
Un constructor con el titulo y horas estimadas. El resto por defecto.
Un constructor con todos los atributos, excepto de entregado.
Los métodos que se implementara serán:
Métodos get de todos los atributos, excepto de entregado.
Métodos set de todos los atributos, excepto de entregado.
Sobrescribe los métodos toString.
Como vemos, en principio, las clases anteriores no son padre-hija, pero si tienen en común, por eso vamos a hacer una interfaz llamada Entregable con los siguientes métodos:

entregar(): cambia el atributo prestado a true.
devolver(): cambia el atributo prestado a false.
isEntregado(): devuelve el estado del atributo prestado.
Método compareTo (Object a), compara las horas estimadas en los videojuegos y en las series el numero de temporadas. Como parámetro que tenga un objeto, no es necesario que implementes la interfaz Comparable. Recuerda el uso de los casting de objetos.
Implementa los anteriores métodos en las clases Videojuego y Serie. Ahora crea una aplicación ejecutable y realiza lo siguiente:

Crea dos arrays, uno de Series y otro de Videojuegos, de 5 posiciones cada uno.
Crea un objeto en cada posición del array, con los valores que desees, puedes usar distintos constructores.
Entrega algunos Videojuegos y Series con el método entregar().
Cuenta cuantos Series y Videojuegos hay entregados. Al contarlos, devuélvelos.
Por último, indica el Videojuego tiene más horas estimadas y la serie con mas temporadas. Muestralos en pantalla con toda su información (usa el método toString()).


–Clase Serie

/**
 * Clase Serie
 *
 * Contiene informacion sobre una serie (en general)
 * @author DiscoDurodeRoer
 *
 */
public class Serie implements Entregable{
  
    //Constantes
  
    /**
     * Numero de temporadas por defecto
     */
    private final static int NUM_TEMPORADAS_DEF=3;
  
    /**
     * Constante que indica que un objeto es mayor que otro
     */
    public final static int MAYOR=1;
  
    /**
     * Constante que indica que un objeto es menor que otro
     */
    public final static int MENOR=-1;
  
    /**
     * Constante que indica que un objeto es igual que otro
     */
    public final static int IGUAL=0;
  
    //Atributos
  
    /**
     * Titulo de la serie
     */
    private String titulo;
  
    /**
     * Numero de temporadas de la serie
     */
    private int numeroTemporadas;
  
    /**
     * Indica si esta entregado la serie
     */
    private boolean entregado;
  
    /**
     * Genero de la serie
     */
    private String genero;
  
    /**
     * Creador de la serie
     */
    private String creador;
  
    //Métodos publicos
  
    /**
     * Devuelve el titulo de la serie
     * @return titulo de la serie
     */
    public String getTitulo() {
        return titulo;
    }
  
    /**
     * Modifica el titulo de la serie
     * @param titulo a cambiar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
  
    /**
     * Devuelve la numeroTemporadas de la serie
     * @return numeroTemporadas de la serie
     */
    public int getnumeroTemporadas() {
        return numeroTemporadas;
    }
  
    /**
     * Modifica la numeroTemporadas de la serie
     * @param numeroTemporadas a cambiar
     */
    public void setnumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }
  
    /**
     * Devuelve el genero de la serie
     * @return genero de la serie
     */
    public String getGenero() {
        return genero;
    }
  
    /**
     * Modifica el genero de la serie
     * @param genero a cambiar
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
  
    /**
     * Devuelve el creador de la serie
     * @return creador de la serie
     */
    public String getcreador() {
        return creador;
    }
  
    /**
     * Modifica el creador de la serie
     * @param creador a cambiar
     */
    public void setcreador(String creador) {
        this.creador = creador;
    }
  
    /**
     * Cambia el estado de entregado a true
     */
    public void entregar() {
        entregado=true;
    }
  
    /**
     * Cambia el estado de entregado a false
     */
    public void devolver() {
        entregado=false;
    }
  
    /**
     * Indica el estado de entregado
     */
    public boolean isEntregado() {
        if(entregado){
            return true;
        }
        return false;
    }
  
    /**
     * Compara dos series segun su numero de temporadas
     * @param objeto a comparar
     * @return codigo numerico
     * <ul>
     * <li>1: La Serie 1 es mayor que la Serie 2</li>
     * <li>0: Las Series son iguales</li>
     * <li>-1: La Serie 1 es menor que la Serie 2</li></ul>
     */
    public int compareTo(Object a) {
        int estado=MENOR;
  
        //Hacemos un casting de objetos para usar el metodo get
        Serie ref=(Serie)a;
        if (numeroTemporadas>ref.getnumeroTemporadas()){
            estado=MAYOR;
        }else if(numeroTemporadas==ref.getnumeroTemporadas()){
            estado=IGUAL;
        }
  
        return estado;
    }
  
    /**
     * Muestra informacion de la Serie
     * @return cadena con toda la informacion de la Serie
     */
    public String toString(){
        return "Informacion de la Serie: n" +
                "tTitulo: "+titulo+"n" +
                "tNumero de temporadas: "+numeroTemporadas+"n" +
                "tGenero: "+genero+"n" +
                "tCreador: "+creador;
    }
  
    /**
     * Indica si dos Series son iguales, siendo el titulo y creador iguales
     * @param a Serie a comparar
     * @return true si son iguales y false si son distintos
     */
    public boolean equals(Serie a){
        if (titulo.equalsIgnoreCase(a.getTitulo()) && creador.equalsIgnoreCase(a.getcreador())){
            return true;
        }
        return false;
    }
  
    //Constructor
  
    /**
     * Constructor por defecto
     */
    public Serie(){
        this("",NUM_TEMPORADAS_DEF, "", "");
    }
  
    /**
     * Contructor con 2 parametros
     * @param titulo de la Serie
     * @param creador de la Serie
     */
    public Serie(String titulo, String creador){
        this(titulo,NUM_TEMPORADAS_DEF, "", creador);
    }
  
    /**
     * Constructor con 4 parametros
     * @param titulo de la Serie
     * @param numeroTemporadas de la Serie
     * @param genero de la Serie
     * @param creador de la Serie
     */
    public Serie(String titulo, int numeroTemporadas, String genero, String creador){
        this.titulo=titulo;
        this.numeroTemporadas=numeroTemporadas;
        this.genero=genero;
        this.creador=creador;
        this.entregado=false;
    }
  
}
–Clase Videojuego

/**
 *
 * Clase videojuego
 *
 * Contiene la informacion sobre un videojuego
 *
 * @author DiscoDurodeRoer
 */
public class Videojuego implements Entregable{
  
    //Constantes
  
    /**
     * Horas estimadas por defecto
     */
    private final static int HORAS_ESTIMADAS_DEF=100;
  
    /**
     * Constante que indica que un objeto es mayor que otro
     */
    public final static int MAYOR=1;
  
    /**
     * Constante que indica que un objeto es menor que otro
     */
    public final static int MENOR=-1;
  
    /**
     * Constante que indica que un objeto es igual que otro
     */
    public final static int IGUAL=0;
  
    //Atributos
  
    /**
     * Titulo del videojuego
     */
    private String titulo;
  
    /**
     * Horas estimadas del videojuego
     */
    private int horasEstimadas;
  
    /**
     * Indica si esta o no entregado el videojuego
     */
    private boolean entregado;
  
    /**
     * Genero del videojuego
     */
    private String genero;
  
    /**
     * Compañia del videojuego
     */
    private String compañia;
  
    //Métodos publicos
  
    /**
     * Devuelve el titulo del videojuego
     * @return titulo del videojuego
     */
    public String getTitulo() {
        return titulo;
    }
  
    /**
     * Modifica el titulo del videojuego
     * @param titulo a cambiar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
  
    /**
     * Devuelve el numero de paginas del videojuego
     * @return numero de paginas del videojuego
     */
    public int getHorasEstimadas() {
        return horasEstimadas;
    }
  
    /**
     * Modifica el numero de paginas del videojuego
     * @param horasEstimadas
     */
    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }
  
    /**
     * Devuelve el genero del videojuego
     * @return genero del videojuego
     */
    public String getGenero() {
        return genero;
    }
  
    /**
     * Modifica el genero del videojuego
     * @param genero a cambiar
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
  
    /**
     * Devuelve el compañia del videojuego
     * @return compañia del videojuego
     */
    public String getcompañia() {
        return compañia;
    }
  
    /**
     * Modifica el compañia del videojuego
     * @param compañia a cambiar
     */
    public void setcompañia(String compañia) {
        this.compañia = compañia;
    }
  
    /**
     * Cambia el estado de entregado a true
     */
    @Override
    public void entregar() {
        entregado=true;
    }
  
    /**
     * Cambia el estado de entregado a false
     */
    @Override
    public void devolver() {
        entregado=false;
    }
  
    /**
     * Indica el estado de entregado
     * @return 
     */
    @Override
    public boolean isEntregado() {
        if(entregado){
            return true;
        }
        return false;
    }
  
    /**
     * Compara dos videojuegos segun el numero de paginas
     * @return codigo numerico
     * <ul>
     * <li>1: El videojuego 1 es mayor que el videojuego 2</li>
     * <li>0: Los videojuegos son iguales</li>
     * <li>-1: El videojuego 1 es menor que el videojuego 2</li></ul>
     */
    @Override
    public int compareTo(Object a) {
        int estado=MENOR;
  
        //Hacemos un casting de objetos para usar el metodo get
        Videojuego ref=(Videojuego)a;
        if (horasEstimadas>ref.getHorasEstimadas()){
            estado=MAYOR;
        }else if(horasEstimadas==ref.getHorasEstimadas()){
            estado=IGUAL;
        }
  
        return estado;
    }
  
    /**
     * Muestra informacion del videojuego
     * @return cadena con toda la informacion del videojuego
     */
    @Override
    public String toString(){
        return "Informacion del videojuego: n" +
                "tTitulo: "+titulo+"n" +
                "tHoras estimadas: "+horasEstimadas+"n" +
                "tGenero: "+genero+"n" +
                "tcompañia: "+compañia;
    }
  
    /**
     * Indica si dos videojuegos son iguales, siendo el titulo y compañia iguales
     * @param a videojuego a comparar
     * @return true si son iguales y false si son distintos
     */
    public boolean equals(Videojuego a){
        if (titulo.equalsIgnoreCase(a.getTitulo()) && compañia.equalsIgnoreCase(a.getcompañia())){
            return true;
        }
        return false;
    }
  
    //Constructor
  
    /**
     * Constructo por defecto
     */
    public Videojuego(){
        this("",HORAS_ESTIMADAS_DEF, "", "");
    }
  
    /**
     * Constructor con 2 parametros
     * @param titulo del videojuego
     * @param compañia del videojuego
     */
    public Videojuego(String titulo, String compañia){
        this(titulo,HORAS_ESTIMADAS_DEF, "", compañia);
    }
  
    /**
     * Constructor con 4 parametros
     * @param titulo del videojuego
     * @param horasEstimadas
     * @param genero del videojuego
     * @param compañia del videojuego
     */
    public Videojuego(String titulo, int horasEstimadas, String genero, String compañia){
        this.titulo=titulo;
        this.horasEstimadas=horasEstimadas;
        this.genero=genero;
        this.compañia=compañia;
        this.entregado=false;
    }
 
  
}

–Interfaz Entregable

public interface Entregable {
  
    public void entregar();
  
    public void devolver();
  
    public boolean isEntregado();
  
    public int compareTo(Object a);
}

–Clase ejecutable


public class EntregablesApp {
  
    public static void main(String[] args) {
  
        //Creamos dos arrays de cada tipo de objeto
        Serie listaSeries[]=new Serie[5];
        Videojuego listaVideojuegos[]=new Videojuego[5];
  
        //Creamos un objeto en cada posicion del array
        listaSeries[0]=new Serie();
        listaSeries[1]=new Serie("Juego de tronos", "George R. R. Martin ");
        listaSeries[2]=new Serie("Los Simpsons", 25, "Humor", "Matt Groening");
        listaSeries[3]=new Serie("Padre de familia", 12 ,"Humor", "Seth MacFarlane");
        listaSeries[4]=new Serie("Breaking Bad", 5, "Thriller", "Vince Gilligan");
  
        listaVideojuegos[0]=new Videojuego();
        listaVideojuegos[1]=new Videojuego("Assasin creed 2", 30, "Aventura", "EA");
        listaVideojuegos[2]=new Videojuego("God of war 3", "Santa Monica");
        listaVideojuegos[3]=new Videojuego("Super Mario 3DS", 30, "Plataforma", "Nintendo");
        listaVideojuegos[4]=new Videojuego("Final fantasy X", 200, "Rol", "Square Enix");
  
        //entregamos algunos videojuegos y series
        listaSeries[1].entregar();
        listaSeries[4].entregar();
        listaVideojuegos[0].entregar();
        listaVideojuegos[3].entregar();
  
        //Recorremos los arrays para contar cuantos entregados hay, tambien los devolvemos
  
        int entregados=0;
  
        for(int i=0;i<listaSeries.length;i++){
            if(listaSeries[i].isEntregado()){
                entregados+=1;
                listaSeries[i].devolver();
  
            }
            if(listaVideojuegos[i].isEntregado()){
                entregados+=1;
                listaVideojuegos[i].devolver();
            }
        }
  
        System.out.println("Hay "+entregados+" articulos entregados");
  
        //Creamos dos objetos con la primera posicion de cada array
        Serie serieMayor=listaSeries[0];
        Videojuego videojuegoMayor=listaVideojuegos[0];
  
        //Recorremos el array desde la posicion 1 (no 0), comparando el mayor con las posiciones del array
        for(int i=1;i<listaSeries.length;i++){
            if(listaSeries[i].compareTo(serieMayor)==Serie.MAYOR){
                serieMayor=listaSeries[i];
            }
            if(listaVideojuegos[i].compareTo(videojuegoMayor)==Videojuego.MAYOR){
                videojuegoMayor=listaVideojuegos[i];
            }
  
        }
  
        //Mostramos toda la informacion del videojuego y serie mayor
        System.out.println(videojuegoMayor);
        System.out.println(serieMayor);
    }
  
}