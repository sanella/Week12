package com.bitcamp.lab1;

public class sabiranjeMatrica {

	public static int[][] sumaMatrica(int[][] a, int[][] b){
		int[][] suma = new int [3][3];
		for(int i =0; i < a.length; i++){
			for(int j = 0; j< a[i].length; j++){
				suma[i][j] = a[i][j] + b[i][j];
			}
		}
		return suma;
	}
	int[][] multi = new int[5][];
	
	public static void main(String[] args) {
		int matricaA[][]={{1,2,3},{1,0,3},{1, 1, 1}};
		int matricaB[][]={{1,2,3},{1,0,3},{1, 1, 1}};
		
		int[][] suma = sumaMatrica(matricaA, matricaB);
		
		//ispis
		for(int i =0; i < suma.length; i++){
			for(int j = 0; j< suma[i].length; j++){
			System.out.print(suma[i][j] + ", ");
			}
			System.out.println();
			}
	}
	
}
