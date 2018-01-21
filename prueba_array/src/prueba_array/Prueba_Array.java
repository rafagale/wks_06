package prueba_array;

public class Prueba_Array {

	public static void main(String[] args) {
		int uno[] = new int[2];
		int dos[][] = new int[2][2];
		int conta=0;
		
		for (int i = 0; i < uno.length; i++) {
			conta++;
			uno[i]=conta;
			System.out.printf("%5d", uno[i]);
		}
		
		
		System.out.println();
		for (int i = 0; i < dos.length; i++) {
			System.out.println();
			for (int j = 0; j < dos.length; j++) {
				System.out.printf("%5d", dos[i][j]);
			}
		}
		
		for (int i = 0; i < uno.length; i++) {
			dos[i][0]=uno[i];
		}
		
		
		System.out.println();
		for (int i = 0; i < dos.length; i++) {
			System.out.println();
			for (int j = 0; j < dos.length; j++) {
				System.out.printf("%5d", dos[i][j]);
			}
		}
		
		
		
	}

}
