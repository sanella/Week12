package com.bitcamp.lab2.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Sanela Grcic
 * Zadatak: Napravi server i klijenta, server treba da salje klijentu neki broj. 
 */

public class Client {
	public static final int port = 1717;
	public static final String serverAdress = "127.0.0.1";

	
	public static void connect() throws IOException {
		Socket user = null;

		try {

			user = new Socket(serverAdress, port);

			
			InputStream in = user.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);

			// poruka koju mi je server poslao
			String message = br.readLine();
			System.out.println(message);

			// Poruka, tj broj koji se ispise na consoli
			String number = br.readLine();
			System.out.println(number);

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {

			user.close();
		}
	}

	/**
	 * Main metoda u kojoj moram pozvati konekciju da bi radio program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			connect();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
