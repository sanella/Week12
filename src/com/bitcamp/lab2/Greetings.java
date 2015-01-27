package com.bitcamp.lab2;

public class Greetings extends Thread {
	private int id;
	
	public Greetings(int id){
		this.id = id;
	}
	
	public void greetingCount(){
		for(int i =0; i < 20; i++){
			System.out.printf("Hello fro %d! Just counted to: %d\n", id, i);
		}
			
	}
	
	@Override
	public void run(){
		greetingCount();
	}
	public static void main(String[] args) {
		
		Greetings[] gr = new Greetings[5];
		
		
		for (int i =0; i < gr.length; i ++){
			gr[i] = new Greetings(i);
				gr[i].start();
			
				// ako direktono pozovemo metodu run necemo implementirati Thread,
				//zato  pozivamo metodu start
				//start medoda je it Thread metode, ona poziva run
			}
		for(Greetings g :gr){
			try {
				//metodu join pozivamo ovako jer drugacije ne bi funkcionisao threading
				g.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Gotovo");
		}
	}

