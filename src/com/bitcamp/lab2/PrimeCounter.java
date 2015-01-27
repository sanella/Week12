package com.bitcamp.lab2;

import java.util.Date;

public class PrimeCounter extends Thread {

	private int start;
	private  int end;
	private int counter;
	private Date startTime;
	private Date endTime;
	
	public PrimeCounter(){
		this.start = start;
		this.end = end;
		this.counter = counter;
	}
	

	static double resultTime;

	@Override
	public void run() {
		
		countPrimes(a, b);
	}

	private static void calculateTime(double start, double end) {
		resultTime = end - start;

	}

	private static void startDate() {

		Date beginingDate = new Date();
		start = (int) beginingDate.getTime();

	}

	private static void endDate() {
		Date beginingDate = new Date();
		end = (int) beginingDate.getTime();

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

	public static void main(String[] args) {



		for (PrimeCounter p : pc) {
			try {
				p.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Gotovo");

		startDate();
		int counter;
		
		endDate();
		calculateTime(start, end);
		System.out.println(resultTime);


	}
}
