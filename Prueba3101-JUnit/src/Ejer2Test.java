import static org.junit.Assert.*;

import org.junit.Test;

public class Ejer2Test {

	@Test
	public void testContar_letra() {
		Ejer2 test2 = new Ejer2();
		assertEquals("Deberia ser 1", 1, test2.contar_letra("hola", 'o'));
	}

	@Test
	public void testContar_letra2() {
		Ejer2 test2 = new Ejer2();
		assertEquals("Deberia ser 0", 0, test2.contar_letra("", 'o'));
	}

	@Test
	public void testContar_letra3() {
		Ejer2 test2 = new Ejer2();
		assertEquals("Deberia ser 0", 0, test2.contar_letra("hola", 'z'));
	}

	@Test
	public void testContar_letra4() {
		Ejer2 test2 = new Ejer2();
		assertEquals("Deberia ser 1", 1, test2.contar_letra("h", 'h'));
	}

}
