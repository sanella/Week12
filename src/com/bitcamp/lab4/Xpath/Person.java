package com.bitcamp.lab4.Xpath;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Person {

	public String name;
	public String surname;
	public int age;
	public LinkedList<Person> children;
	
	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		children = new LinkedList<Person>();
	}
	
	//Metoda za dodavanje u djece u Person
	public void addChild(Person p){
		children.add(p);
	}
	
	

	// List moze da salje i ArrayList i LinkedList, to je nadobjekat
	

	public static void personToXML(List persons, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		// svaki xml mora da nosi naslov verzije
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<people>");
		// Iterator koristimo da bi prosli kroz List person
		Iterator<Person> it = persons.iterator();

		// petljom prolazimo kroz listu
		while (it.hasNext()) {
			Person temp = it.next();
			// za svaki person iz liste moramo da ispisemo u xml
			pw.println(" <person name = '" + temp.name + "' surname = '"
					+ temp.surname +  "' >");
			pw.println("  <age>" + temp.age +"</age>");
			Iterator<Person> itChild = temp.children.iterator();
			 
			while(itChild.hasNext()){
				Person temp2 = itChild.next();
				pw.println("  <child name = '" + temp2.name + "' surname = '"
						+ temp2.surname + "' age ='" + temp2.age + "' />");
			}
			pw.println("</person>");
		}
		
		// zatvaramo person
		pw.println("</people>");
		// da budemo sigurni da ce ispisati moramo koristiti flush
		pw.flush();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age
				+ ", children=" + children + "]";
	}

}
