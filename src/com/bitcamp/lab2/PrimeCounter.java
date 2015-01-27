package com.bitcamp.lab2;

import java.util.Date;

public class PrimeCounter extends Thread {
	private int start;
	private int end;
	private int counter;
	private Date startTime;
	private Date endTime;
	
	public PrimeCounter(int start, int end){
		super();
		this.start = start;
		this.end = end;
		counter = 0;
	}
	
	@Override
	public void run(){
		startTime = new Date();
		for(int i = this.start; i < this.end; i++){
			if( isPrime(i) == true){
				this.counter++;
			}
		}
		endTime = new Date();
		printResult();
	}
	
	public int getCount(){
		return counter;
	}
	
	public void printResult(){
		System.out.printf("From %7d to %7d counted: %5d\n", start, end, counter);
		System.out.println(" Thread time: " + ((double)(endTime.getTime() - startTime.getTime())/1000));
	}
	
	/**
	 * Metoda koja provjerava koliko ima prime brojeva od 1 do num
	 * @param num - broj do kojeg zadamo da se provjerava da li su brojevi prime
	 * @return -vraca da li je broj prime ili ne
	 */
	private boolean isPrime(int num){
		for(int i = 2; i < num; i++){
			if( num % i == 0)
				return false;
		}
		return true;
	}

}
 