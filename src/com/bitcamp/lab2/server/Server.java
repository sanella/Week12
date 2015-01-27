package com.bitcamp.lab2.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
/**
 * 
 * @author Sanela Grcic
 * Zadatak: Napravi server i klijenta, server treba da salje klijentu neki broj. 
 */
public class Server {
	// port preko kojeg cu se spojiti
	public static final int port = 1717;

	/**
	 * Metoda za pokretanje servera
	 * @throws IOException
	 */
	public static void serverStart() throws IOException {

		ServerSocket server = null;

		try {
			
			server = new ServerSocket(port);
			while (true) {
				System.out.println("Waiting for connection");
				Socket user = server.accept();
				System.out.println("Connected");

				OutputStream os = user.getOutputStream();

				while (true) {

					String message = "Welcome!\n";
					// pozivam metodu koja mi daje neki broj
					String number = getNumber();
					message += number + "\n";
					// saljem je korisniku
					os.write(message.getBytes());
					os.flush();
					break;

				}
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			server.close();

		}
	}

	// metoda za slanje nekog broja
	private static String getNumber() {
		int rand = (int) (1 + Math.random() * 15);
		String str = Integer.toString(rand);
		return str;
	}

	// uvijek moras pokrenuti server u main metodi
	public static void main(String[] args) {
		try {
			serverStart();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
