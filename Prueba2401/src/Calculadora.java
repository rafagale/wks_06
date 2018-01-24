
public class Calculadora {
	private Integer num1, num2;

	public int suma() {
		int resul;
		resul = num1 + num2;
		return resul;
	}

	public int resta() {
		int resul;
		if (resta2()) {
			resul = num1 - num2;
		} else {
			resul = num2 - num1;
		}
		return resul;
	}
	
	public boolean resta2() {
		int resul;
		if (num1>=num2) {
			return true;
		} else {
			return false;
		}
	}
	

	public int multi() {
		int resul;
		resul = num1 * num2;
		return resul;
	}
	
	
	public int div() {
		int resul;
		resul = num1 / num2;
		return resul;
	}
	
	public Integer div2() {
		if (num2==0) {
			return null;
		}
		int resul = num1 / num2;
		return resul;
	}
	
	
	
	
} 