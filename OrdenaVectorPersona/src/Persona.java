public class Persona {
	
   private final String nombre;
   private final int edad;
   private final float altura;
   private final String dni;

   public Persona(String nombre, int edad,float altura,String dni) {
      this.nombre = nombre;
      this.edad = edad;
      this.altura=altura;
      this.dni=dni;
   }
   
   public String getNombre() {
      return nombre;
   }
   
   public int getEdad() {
      return edad;
   }
   
   public float getAltura() {
      return altura;
   }
   
   public String getDni() {
      return dni;
   }
   
}
