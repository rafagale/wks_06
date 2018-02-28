15) Nos piden realizar una agenda telefónica de contactos.

Un contacto está definido por un nombre y un teléfono (No es necesario de validar). Un contacto es igual a otro cuando sus nombres son iguales.

Una agenda de contactos está formada por un conjunto de contactos (Piensa en que tipo puede ser)

Se podrá crear de dos formas, indicándoles nosotros el tamaño o con un tamaño por defecto (10)

Los métodos de la agenda serán los siguientes:

aniadirContacto(Contacto c): Añade un contacto a la agenda, sino se pueden meter más a la agenda se indicara por pantalla. No se pueden meter contactos que existan, es decir, no podemos duplicar nombres, aunque tengan distinto teléfono.
existeContacto(Conctacto c): indica si el contacto pasado existe o no.
listarContactos(): Lista toda la agenda
buscaContacto(String nombre): busca un contacto por su nombre y muestra su teléfono.
eliminarContacto(Contacto c): elimina el contacto de la agenda, indica si se ha eliminado o no por pantalla
agendaLlena(): indica si la agenda está llena.
huecosLibres(): indica cuantos contactos más podemos meter.
Crea un menú con opciones por consola para probar todas estas funcionalidades.



— Contacto

/**
 * Representa a un contacto
 * @author Discoduroderoer
 */
public class Contacto {
     
    private String nombre;
    private int telefono;
 
    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
     
    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = 0;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getTelefono() {
        return telefono;
    }
 
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
 
    public boolean equals(Contacto c){
         
        if(this.nombre.trim().equalsIgnoreCase(c.getNombre().trim())){
            return true;
        }
         
        return false;
         
    }
     
    @Override
    public String toString() {
        return "nombre=" + nombre + ", telefono=" + telefono;
    }
     
     
}
— Agenda

/**
 * Lleva la gestion de una agenda
 * @author Discoduroderoer
 */
public class Agenda {
 
    //Atributos
    private Contacto[] contactos;
 
    //Constructores
    public Agenda() {
        this.contactos = new Contacto[10]; //por defecto
    }
 
    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio]; //tamaño que nosotros queramos
    }
 
    //Metodos
    /**
     * Añade un contacto a la agenda
     *
     * @param c
     */
    public void aniadirContacto(Contacto c) {
 
        if (existeContacto(c)) { //Indico si existe el contacto
            System.out.println("El contacto con ese nombre ya existe");
        } else if (agendaLlena()) { //Indico si la agenda esta o no llena
            System.out.println("La agenda esta llena, no se pueden meter mas contactos");
        } else {
 
            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) { //controlo los nulos
                    contactos[i] = c; //Inserto el contacto 
                    encontrado = true; //Indico que lo he encontrado
                }
            }
 
            if (encontrado) {
                System.out.println("Se ha añadido");
            } else {
                System.out.println("No se ha podido añadir");
            }
        }
 
    }
 
    /**
     * Indica si existe un contacto
     *
     * @param c
     * @return
     */
    public boolean existeContacto(Contacto c) {
 
        for (int i = 0; i < contactos.length; i++) {
            //Controlo nulos e indico si el contacto es el mismo
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }
        }
        return false;
 
    }
 
    /**
     * Lista los contactos de la agenda
     */
    public void listarContactos() {
 
        if (huecosLibre() == contactos.length) {
            System.out.println("No hay contactos que mostrar");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) { //Controlo nulos
                    System.out.println(contactos[i]);
                }
            }
        }
 
    }
 
    /**
     * Busca un contacto por su nombre
     *
     * @param nombre
     */
    public void buscarPorNombre(String nombre) {
 
        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            //Controlo nulos y cxompruebo que es el contacto buscado (forma mas engorrosa)
            if (contactos[i] != null && contactos[i].getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                System.out.println("Su telefono es " + contactos[i].getTelefono()); //muestro el telefono
                encontrado = true; //Indico que lo he encontrado
            }
        }
 
        if (!encontrado) {
            System.out.println("No se ha encontrado el contacto");
        }
 
    }
 
    /**
     * Indica si la agenda esta llena o no
     *
     * @return
     */
    public boolean agendaLlena() {
 
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { //Controlo nulos
                return false; //indico que no esta llena
            }
        }
 
        return true; //esta llena
 
    }
 
    /**
     * Elimina el contacto de la agenda
     *
     * @param c
     */
    public void eliminarContacto(Contacto c) {
 
        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null; //Controlo nulos
                encontrado = true; //Indico que lo he encontrado
            }
        }
 
        if (encontrado) {
            System.out.println("Se ha eliminado el contacto");
        } else {
            System.out.println("No se ha eliminado el contacto");
 
        }
 
    }
 
    /**
     * Indica cuantos contactos más podemos meter
     *
     * @return
     */
    public int huecosLibre() {
 
        int contadorLibres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { //Controlo nulos
                contadorLibres++; //Acumulo
            }
        }
 
        return contadorLibres;
 
    }
 
}
— Main

import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Ejercicio_POO_DDR_11 {
 
    public static void main(String[] args) {
 
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        Agenda agendaTelefonica = new Agenda(3);
        String nombre;
        int telefono;
 
        Contacto c;
 
        while (!salir) {
 
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Contactos disponibles");
            System.out.println("7. Agenda llena");
            System.out.println("8. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
 
                        //Pido valores
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
 
                        System.out.println("Escribe un telefono");
                        telefono = sn.nextInt();
 
                        //Creo el contacto
                        c = new Contacto(nombre, telefono);
 
                        agendaTelefonica.aniadirContacto(c);
 
                        break;
                    case 2:
 
                        agendaTelefonica.listarContactos();
 
                        break;
                    case 3:
 
                        //pido el nombre
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
 
                        agendaTelefonica.buscarPorNombre(nombre);
 
                        break;
                    case 4:
 
                        //pido el nombre
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
 
                        //Creo el contacto auxiliar
                        c = new Contacto(nombre, 0);
 
                        if (agendaTelefonica.existeContacto(c)) {
                            System.out.println("Existe contacto");
                        } else {
                            System.out.println("No existe contacto");
                        }
 
                        break;
                    case 5:
 
                        //pido el nombre
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
 
                        //Creo el contacto auxiliar
                        c = new Contacto(nombre, 0);
 
                        agendaTelefonica.eliminarContacto(c);
 
                        break;
                    case 6:
 
                        System.out.println("Hay " + agendaTelefonica.huecosLibre() + " contactos libre");
 
                        break;
                    case 7:
 
                        //como devuelve un booleano, lo meto en un if
                        if (agendaTelefonica.agendaLlena()) {
                            System.out.println("La agenda esta llena");
                        } else {
                            System.out.println("Aun puedes meter contactoss");
                        }
 
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
 
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
 
        }
 
    }
 
}