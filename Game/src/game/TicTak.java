package game;

import java.util.Scanner;

public class TicTak {

	private static char tab[][] = {{'.','.','.'},
								   {'.','.','.'},
								   {'.','.','.'}};
	private static Scanner sc = new Scanner(System.in);
//	private static char player ='X';
	
	public static void main(String[] args) {
		

		System.out.println("Rozpoczynamy gr�");
		while(true) {
			TicTak.printTab();
			boolean move = swap();

			}
		}

	private static boolean swap() {
		
		System.out.println("Podaj wsp�rz�dne np. A1");
		String value = sc.next().toUpperCase();
			if(value.length() !=2) {
				System.out.println("Niepoprawna wsp�rz�dna");
			}else if(value.charAt(0) != 'A' &&
					 value.charAt(0) != 'B' &&
					 value.charAt(0) != 'C') {
					System.out.println("Niepoprawna piersza wsp�rz�dna ");
			}else if(value.charAt(1) != '1' &&
					 value.charAt(1) != '2' &&
					 value.charAt(1) != '3') {
				System.out.println("Niepoprawna druga warto��");
			}else {
				int a = 0;
				int b = 0;
				if(value.charAt(0) == 'A') {
					a = 0;
				}else if(value.charAt(0) == 'B') {
					a = 1;
				}else if(value.charAt(0) == 'C'){
					a = 2;
				}
				if(value.charAt(1) == 1) {
					b = 0;
				}else if(value.charAt(1) == 2) {
					b = 1;
				}else if(value.charAt(1) ==3) {
					b = 3;
				}
				if(tab[a][b] =='X') {
					tab[a][b] ='O';
				}else {
					tab[a][b] = 'X';
				}
			}
			
			return false;
		
	}

	
	private static void printTab() {

		System.out.println();
		System.out.println("\t1\t2\t3");
		System.out.println("A\t"+tab[0][0]+"\t"+tab[0][1]+"\t"+tab[0][2]);
		System.out.println("B\t"+tab[1][0]+"\t"+tab[1][1]+"\t"+tab[1][2]);
		System.out.println("C\t"+tab[2][0]+"\t"+tab[2][1]+"\t"+tab[2][2]);
	}

}
