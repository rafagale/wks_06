public class SuperClase {
	private int datoClase;

	public SuperClase(int datoEnv) {

		datoClase = datoEnv;
		System.out.println("\n\tHemos entrado en la funci�n constructora de la superclase");
	}

	public void visualDatoSuperClase() {
		System.out.println("\n\n\n\tEl dato de la s�per clase es " + datoClase);
	}
}
