package com.bitcamp.lab1;

import java.util.Date;



public class DatePrimes {
	
	public static int countPrimes(int a, int b){
		int count = 0;
	
		for(int i = a; i <= b; i++){
			for(int j = 2; j < i; j++){		
				if (i % j != 0) {	
					count++;
			}		
		}		
		}
		return count;
	
	
	}
	
	
	public static void main(String[] args) {
		Date startDate = new Date( );
		int a = 1;
		int b = 20;
		System.out.println(countPrimes(a, b));
		Date endDate = new Date( );
		

	}
	
}
