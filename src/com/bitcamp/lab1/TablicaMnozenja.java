package com.bitcamp.lab1;

public class TablicaMnozenja {

	public static void mnozenje(){
		int suma = 0;
		for (int i = 1; i<=10; i++ ){
			for (int j = 1; j<=10; j++ ){
			suma = i * j;
			System.out.printf(i + " * " + j +  " = " + suma%2 + "    ");
		}
			System.out.println();
	}
	
	}
	public static void main(String[] args) {
	
	mnozenje();
	
	}
	
}
