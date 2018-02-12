/*Crea una clase que sea abstracta y lleva a cabo las siguientes comprobaciones: 
1. Inserta m�todos no abstractos.
2. Inserta m�todos abstractos.
3. Pon cuerpo a un m�todo abstracto.
4. Declara un objeto con ese tipo de clase.
5. Instancia un objeto de dicha clase.
6. Declara un atributo abstracto.
7. Crea una nueva clase que no sea abstracta y prueba a insertar un m�todo que sea 
abstracto.
Haz que esa clase herede de la clase abstracta y comprueba que te obliga a insertar los
m�todos abstractos que tiene dicha clase.
*/
public abstract class PruebaClaseAbstract {
	private String atributo;
	public String metodoNoAbstracto() {
		return "hola";
	}
	
/*	public abstract String metodoAbstracto() {
		return "hola";
		Abstract methods do not specify a body
	}*/
	
	public abstract String metodoAbstracto();
}
