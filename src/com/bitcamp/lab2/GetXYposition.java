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

public class GetXYposition {

	private static class MouseListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("Mouse moved x" + e.getX() + " Moue moved Y"
					+ e.getY());

		}

	}

	public static void main(String[] args) throws AWTException {
		JFrame window = new JFrame("Trazi x, y");
		JPanel content = new JPanel();
		//prvi dio zadatka da ispisuje koordinate, ako hoces da radi odkomentarisi 
		//content.addMouseMotionListener(new MouseListener());
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120, 70);
		window.setSize(350, 250);
		window.setVisible(true);
		
		// drugi dio zadatka da pomjeri mis na koordinate koje unesemo
		Scanner in = new Scanner(System.in);
		Robot r = new Robot();
		while(true){
			System.out.println("Enter x, y");
			int x = in.nextInt();
			int y = in.nextInt();
			r.mouseMove(x, y);
		}
		
	}

}
