package com.bitcamp.lab1;

import java.util.Date;



public class DatePrimes {
	
	static double start;
	static double end;
	int counter;
	static int a;
	static int b;

	// static int counter;
	static double resultTime;

	public static void main(String[] args) {

		a = 1;
		b = 2000000;
		startDate();
		int counter;
		counter = countPrimes(a, b);
		endDate();
		calculateTime(start, end);
		System.out.println(resultTime);
		System.out.println(counter);

	}

	private static void calculateTime(double start, double end) {
		resultTime = end - start;

	}

	private static void startDate() {

		Date beginingDate = new Date();
		start = beginingDate.getTime();

	}

	private static void endDate() {
		Date beginingDate = new Date();
		end = beginingDate.getTime();

	}

	public static int countPrimes(int a, int b) {
		boolean prime = true;
		int counter = 0;
		for (int i = a; i < b; i++) {
			prime = true;
			for (int j = a + 1; j < i && prime == true; j++)
				if (i % j == 0)
					prime = false;
			if (prime == true)
				counter++;

		}
		return counter;

	}

}
