package com.bitcamp.lab2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Napravi da se na consloi ispisuju koordinate misa, i napravi da posaljes
 * koordinate za mis i da se on momjeri na zadate koordinate
 * 
 * @author sanelagrcic
 *
 */
public class GetXYposition {

	// privatna clasa koja implementira MouseMotionListener
	private static class MouseListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		/**
		 * override-ana metoda MouseMotionaListenera koja mi salje koordinate x
		 * i y na kojem se mis nalazi
		 */
		@Override
		public void mouseMoved(MouseEvent e) {

			System.out.println("Mouse moved x" + e.getX() + " Moue moved Y"
					+ e.getY());

		}

	}

	// Main
	public static void main(String[] args) throws AWTException {
		// kreiraj frame
		JFrame window = new JFrame("Trazi x, y");
		// kreira panel
		JPanel content = new JPanel();

		// prvi dio zadatka da ispisuje koordinate, ako hoces da radi
		// odkomentarisi
		// content.addMouseMotionListener(new MouseListener());

		// dodaje panel na frame
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120, 70);
		window.setSize(350, 250);
		window.setVisible(true);

		// drugi dio zadatka da pomjeri mis na koordinate koje unesemo
		Scanner in = new Scanner(System.in);
		Robot r = new Robot();
		while (true) {
			System.out.println("Enter x, y");
			int x = in.nextInt();
			int y = in.nextInt();
			r.mouseMove(x, y);
		}

	}

}
