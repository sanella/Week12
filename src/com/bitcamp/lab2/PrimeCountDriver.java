package com.bitcamp.lab2;

import java.util.Date;

public class PrimeCountDriver {
public static void main(String[] args) {
	

	int numThreads = 1;
	int startInterval = 1, endInterval = 20;
	int step = (endInterval - startInterval)/numThreads;
	
	Date startTime = new Date();
	PrimeCounter[] threads = new PrimeCounter[numThreads];
	for (int i = 0; i < threads.length; i++) {
		threads[i] = new PrimeCounter(startInterval + i*step, startInterval + (i+1)*step);
		
		threads[i].start();
		
	}
	
	for(int i =0; i <threads.length; i++){
		threads[i].join();
	}
	
}
}
