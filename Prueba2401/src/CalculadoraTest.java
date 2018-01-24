import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void suma() {
		Calculadora  calcu = new Calculadora();
		int num1, num2;
		int resultado = calcu.suma();
		assertEquals(resultado, 2);
	}
	
	@Test
	public void resta() {
		
	}
	
	@Test
	public void multi() {
		
	}
	
	@Test
	public void divide() {
		
	}

}
