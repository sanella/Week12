package com.bitcamp.lab2;

/**
 * Priprema za predavanja u petak 12.1, 12.2, 12.3.
 * 
 * @author Sanela Grcic
 *
 */
public class Greetings extends Thread {
	private int id;
	private static int totalCount = 0;

	// Konstruktor
	public Greetings(int id) {
		this.id = id;
	}

	public void greetingCount() {
		for (int i = 0; i < 5; i++) {
			System.out.printf(
					"Hello fro %d! Just counted to: %d, Total Count is: %d\n",
					id, i, totalCount);
			increaseCount();
		}

	}

	// Override-ovana metoda Thread
	// ako je ne koristimo nece ni raditi Thread
	@Override
	public void run() {
		greetingCount();
	}

	public synchronized void increaseCount() {
		totalCount++;
	}

	public static void main(String[] args) {

		Greetings[] gr = new Greetings[5];

		for (int i = 0; i < gr.length; i++) {
			gr[i] = new Greetings(i);
			gr[i].start();

			// ako direktono pozovemo metodu run necemo implementirati Thread,
			// zato pozivamo metodu start
			// start medoda je it Thread metode, ona poziva run
		}
		for (Greetings g : gr) {
			try {
				// metodu join pozivamo ovako jer drugacije ne bi funkcionisao
				// threading
				g.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Gotovo");
	}
}
