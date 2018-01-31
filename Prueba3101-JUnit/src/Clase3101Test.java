import static org.junit.Assert.*;

import org.junit.Test;

public class Clase3101Test {

	@Test
	public void testMetodo() {
		Clase3101 clasePrueba = new Clase3101();
		assertEquals("Deberia dar 1", 1, clasePrueba.metodo(true, true));
	}

	@Test
	public void testMetodo2() {
		boolean a = true, b = false, c = false;
		Clase3101 clasePrueba = new Clase3101();
		assertEquals("Deberia dar 2", 2, clasePrueba.metodo(true, false));
	}
}
