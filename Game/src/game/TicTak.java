package game;

import java.util.Scanner;

public class TicTak {

	private static char tab[][] = {{'.','.','.'},
								   {'.','.','.'},
								   {'.','.','.'}};
	private static Scanner sc = new Scanner(System.in);
	private static char player ='X';
	
	public static void main(String[] args) {
		

		System.out.println("Rozpoczynamy gr�");
		while(true) {
			TicTak.printTab();
			System.out.println();
			boolean move = swap();
			if(move) {
				boolean winLine = checkLinie(tab, player);
				boolean winColumn = checkColumn(tab, player);
				boolean crossRight = checkCrossRight(tab, player);;
				boolean crossLeft = checkCrossLeft(tab, player);;
				if(winLine || winColumn || crossRight) {
					TicTak.printTab();
					System.out.println("Wygra� gracz " + player);
					break;
				}else {
					System.out.println("Remis");
				}
				changePlayer();
			}
		}
	}
	
	
	private static boolean checkCrossLeft(char[][] tab, char player) {
		if((tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0] && tab[2][0]!= '.') ||
		   (tab[2][0] == tab[1][1] && tab[1][1] == tab[0][2] && tab[0][2] !='.')) {
			System.out.println("Wygra� gracz " + player);
			TicTak.printTab();

	}
		return false;
	}


	private static boolean checkCrossRight(char[][] tab, char player) {
		int size = tab.length;
		for(int i=0; i<size; i++) {
			if(tab[i][i] != player) {
				return false;
			}
		}
		return true;
	}


	private static boolean checkColumn(char[][] tab, char player) {
		int size = tab.length;
		for(int column = 0; column<size; column++) {
			boolean win = true;
			for(int line = 0; line<size; line++) {
				if(tab[line][column] != player) {
					win = false;
					break;
				}
			}
			if(win) {
				return true;
			}
		}
		return false;
	}


	private static boolean checkLinie(char[][] tab, char player) {
		int size = tab.length;
		for(int line = 0; line<size; line++) {
			boolean win = true;
			for(int column = 0; column<size; column++) {
				if(tab[line][column] != player) {
					win = false;
					break;
				}
			}
			if(win) {
				return true;
			}
		}
		return false;
	}
	private static void changePlayer(){
		if(player == 'O') {
				player = 'X';
			}else {
				player = 'O';
			}
	}

			

	private static boolean swap() {
		boolean player = false;
		System.out.println("Podaj wsp�rz�dne np. A1");
		while(!player) {
			String value = sc.next().toUpperCase();
			if(value.length() !=2) {
				System.out.println("Niepoprawna wsp�rz�dna pierwsza");
			}else if(value.charAt(0) != 'A' &&
					 value.charAt(0) != 'B' &&
					 value.charAt(0) != 'C') {
					System.out.println("Niepoprawna piersza wsp�rz�dna ");
			}else if(value.charAt(1) != '1' &&
					 value.charAt(1) != '2' &&
					 value.charAt(1) != '3') {
				System.out.println("Niepoprawna druga warto��");
			}else {
				int a;
				int b ;
				if(value.charAt(0) == 'A') {
					a = 0;
				}else if(value.charAt(0) == 'B') {
					a = 1;
				}else {
					a = 2;
				}
				if(value.charAt(1) == '1') {
					b = 0;
				}else if(value.charAt(1) == '2') {
					b = 1;
				}else  {
					b = 2;
				}
				if (tab[a][b] != '.') {
					System.out.println("To pole jest ju� zaj�te");
					} else  {
					tab[a][b] = TicTak.player; 
						player = true;
					}
			}
		}
		return player;
		
	}

	
	private static void printTab() {

		System.out.println();
		System.out.println("\t1\t2\t3");
		System.out.println("A\t"+tab[0][0]+"\t"+tab[0][1]+"\t"+tab[0][2]);
		System.out.println("B\t"+tab[1][0]+"\t"+tab[1][1]+"\t"+tab[1][2]);
		System.out.println("C\t"+tab[2][0]+"\t"+tab[2][1]+"\t"+tab[2][2]);
	}

}
