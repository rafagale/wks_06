8) Queremos representar con programación orientada a objetos, un aula con estudiantes y un profesor.
Tanto de los estudiantes como de los profesores necesitamos saber su nombre, edad y sexo. De los estudiantes, queremos saber también su calificación actual (entre 0 y 10) y del profesor que materia da.
Las materias disponibles son matemáticas, filosofía y física.
Los estudiantes tendrán un 50% de hacer novillos, por lo que si hacen novillos no van a clase pero aunque no vayan quedara registrado en el aula (como que cada uno tiene su sitio).
El profesor tiene un 20% de no encontrarse disponible (reuniones, baja, etc.)
Las dos operaciones anteriores deben llamarse igual en Estudiante y Profesor (polimorfismo).
El aula debe tener un identificador numérico, el número máximo de estudiantes y para que esta destinada (matemáticas, filosofía o física). Piensa que más atributos necesita.
Un aula para que se pueda dar clase necesita que el profesor esté disponible, que el profesor de la materia correspondiente en el aula correspondiente (un profesor de filosofía no puede dar en un aula de matemáticas) y que haya más del 50% de alumnos.
El objetivo es crear un aula de alumnos y un profesor y determinar si puede darse clase, teniendo en cuenta las condiciones antes dichas.
Si se puede dar clase mostrar cuantos alumnos y alumnas (por separado) están aprobados de momento (imaginad que les están entregando las notas).
NOTA: Los datos pueden ser aleatorios (nombres, edad, calificaciones, etc.) siempre y cuando tengan sentido (edad no puede ser 80 en un estudiante o calificación ser 12).

— Clase Persona

//Clase Persona
public abstract class Persona {
     
    /*Atributos*/
    private String nombre;
    private char sexo;
    private int edad;
    private boolean asistencia;
     
    /*Contantes*/
    private final String[] NOMBRES_CHICOS={"Pepe", "Fernando", "Alberto", "Nacho", "Eustaquio"}; 
    private final String[] NOMBRES_CHICAS={"Alicia", "Laura", "Clotilde", "Pepa", "Elena"}; 
    private final int CHICO=0;
    private final int CHICA=1;
     
    /*Constructores*/
    public Persona(){
         
        //entre 0 y 1
        int determinar_sexo=MetodosSueltos.generaNumeroAleatorio(0,1);
         
        //Si es 0 es un chico
        if(determinar_sexo==CHICO){
            nombre=NOMBRES_CHICOS[MetodosSueltos.generaNumeroAleatorio(0,4)];
            sexo='H';
        }else{
            nombre=NOMBRES_CHICAS[MetodosSueltos.generaNumeroAleatorio(0,4)];
            sexo='M';
        }
         
        //Indicamos la disponibilidad
        disponibilidad();
         
    }
 
    /*Metodos*/
     
    /**
     * Devuelve el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
 
    /**
     * Modifica el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    /**
     * Devuelve el sexo de la persona
     * @return 
     */
    public char getSexo() {
        return sexo;
    }
 
    /**
     * Modifica el sexo de la persona
     * @param sexo 
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
 
    /**
     * Devuelve la edad de la persona
     * @return 
     */
    public int getEdad() {
        return edad;
    }
 
    /**
     * Modifica la edad de la edad
     * @param edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    /**
     * Indica la asistencia de la persona
     * @return 
     */
    public boolean isAsistencia() {
        return asistencia;
    }
 
    /**
     * Modifica la asistencia de la persona
     * @param asistencia 
     */
    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
     
    //abtracto, las clases hijas deben implementarlo
    public abstract void disponibilidad();
     
}

— Clase Alumno

//Clase Alumno, hereda de la clase Persona
public class Alumno extends Persona{
     
    /*Atributos*/
    private int nota;
     
    /*Constructor*/
    public Alumno(){
        super();
         
        nota=MetodosSueltos.generaNumeroAleatorio(0,10);
         
        super.setEdad(MetodosSueltos.generaNumeroAleatorio(12,15));
         
    }
 
    /*Metodos*/
     
    /**
     * Devuelve la nota
     * @return nota del alumno
     */
     
    public int getNota() {
        return nota;
    }
 
    /**
     * Modifica la nota del alumno
     * @param nota 
     */
    public void setNota(int nota) {
        this.nota = nota;
    }
 
    /**
     * Indica si el alumno esta disponible (50%)
     */
    @Override
    public void disponibilidad() {
         
        int prob=MetodosSueltos.generaNumeroAleatorio(0, 100);
         
        if(prob<50){
            super.setAsistencia(false);
        }else{
            super.setAsistencia(true);
        }
         
    }
     
    /**
     * Muestra la informacion del alumno
     * @return informacion
     */
    public String toString(){
         
        return "Nombre: "+super.getNombre()+" ,sexo: "+super.getSexo()+" , nota: "+nota;
        
    }
     
     
     
     
}
— Clase Profesor

//Clase profesor que hereda de la clase Persona
public class Profesor extends Persona{
     
    /*Atributos*/
    private String materia;
    
    /*Constructores*/
    public Profesor(){
       super(); //Llama al constructor padre
        
       super.setEdad(MetodosSueltos.generaNumeroAleatorio(25,50)); //llama al metodo padre
        
       materia=Constantes.MATERIAS[MetodosSueltos.generaNumeroAleatorio(0,2)];
    }
 
    /*Metodos*/
     
    /**
     * Devuelve la materia del profesor
     * @return 
     */
    public String getMateria() {
        return materia;
    }
 
    /**
     * Modifica la materia del profesor
     * @param materia 
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }
 
    /**
     * Calcula la disponibilidad del profesor(20%)
     */
    @Override
    public void disponibilidad() {
        
        int prob=MetodosSueltos.generaNumeroAleatorio(0, 100);
         
        if(prob<20){
            super.setAsistencia(false);
        }else{
            super.setAsistencia(true);
        }
         
    }
    
}
— Clase Aula

public class Aula {
     
    /*Atributos*/
    private int id;
    private Profesor profesor;
    private Alumno[] alumnos;
    private String materia;
     
    /*Constantes*/
    private final int MAX_ALUMNOS=20;
     
    /*Constructores*/
    public Aula(){
         
        id=1;
         
        profesor=new Profesor();
        alumnos= new Alumno[MAX_ALUMNOS];
        creaAlumnos();
        materia=Constantes.MATERIAS[MetodosSueltos.generaNumeroAleatorio(0,2)];
         
    }
     
    /*Metodos*/
     
    /**
     * Crea los alumnos para el aula
     */
    private void creaAlumnos(){
         
        for(int i=0;i<alumnos.length;i++){
            alumnos[i]=new Alumno();
        }
         
    }
     
     
    /**
     * Indica si la asistencia de los alumnos es mayor del 50%
     * @return 
     */
    private boolean asistenciaAlumnos(){
         
        int cuentaAsistencias=0;
         
        //contamos las asistencias
        for(int i=0;i<alumnos.length;i++){
             
            if(alumnos[i].isAsistencia()){
                cuentaAsistencias++;
            }
             
        }
         
        //Muestro la asistencia total
        System.out.println("Hay "+cuentaAsistencias+" alumnos");
         
        return cuentaAsistencias>=((int)(alumnos.length/2));
         
    }
     
    /**
     * Indicamos si se puede dar clase
     * @return 
     */
    public boolean darClase(){
         
        //Indicamos las condiciones para que se pueda dar la clase
         
        if(!profesor.isAsistencia()){
            System.out.println("El profesor no esta, no se puede dar clase");
            return false;
        }else if(!profesor.getMateria().equals(materia)){
            System.out.println("La materia del profesor y del aula no es la misma, no se puede dar clase");
            return false;
        }else if (!asistenciaAlumnos()){
            System.out.println("La asistencia no es suficiente, no se puede dar clase");
            return false;
        }
         
        System.out.println("Se puede dar clase");
        return true;
         
    }
     
    /**
     * Indicamos las notas de los alumnos aprobados, chicos y chicas
     */
    public void notas(){
         
        int chicosApro=0;
        int chicasApro=0;
         
         for(int i=0;i<alumnos.length;i++){
            
           //Comprobamos si el alumno esta aprobado
           if(alumnos[i].getNota()>=5){
               //Segun el sexo, aumentara uno o otro
               if(alumnos[i].getSexo()=='H'){
                   chicosApro++;
               }else{
                   chicasApro++;
               }
                
               System.out.println(alumnos[i].toString());
                
           }
             
        }
          
        System.out.println("Hay "+chicosApro+" chicos y "+chicasApro+" chicas aprobados/as");
         
    }
     
}
— Clase Constantes

//Clase constantes
public class Constantes {
     
    public static final String[] MATERIAS={"Matematicas", "Filosofia", "Fisica"};
     
}
— Clase MetodosSueltos

public class MetodosSueltos {
     
    /**
     * Genera un numero aleatorio entre dos numeros.
     * Entre el minimo y el maximo
     * @param minimo
     * @param maximo
     * @return numero entre minimo y maximo
     */
    public static int generaNumeroAleatorio(int minimo, int maximo){
         
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
     
}

— Clase Principal

public class Principal {
 
    public static void main(String[] args) {
        
        //Creamos el objeto
        Aula aula=new Aula();
         
        //Indicamos si se puede dar la clase
        if(aula.darClase()){
            aula.notas();
        }
         
    }
     
}