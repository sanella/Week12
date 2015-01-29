package com.bitcamp.lab4.Xpath;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

import org.omg.CORBA.Any;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

public class Test {

	public static void main(String[] args) {

		Person person1 = new Person("Sanela", "Grcic", 3);
		Person person2 = new Person("Benjamin", "Talic", 2);
		Person person3 = new Person("Amra", "Poprzanovic", 4);
		Person person4 = new Person("Jesenko", "Gavric", 5);
		Person person5 = new Person("Nedzad", "Hamzic", 6);

		person1.addChild(new Person("Child", "1", 2));
		person2.addChild(new Person("Child", "1", 3));
		person3.addChild(new Person("Child", "1", 4));
		person4.addChild(new Person("Child", "1", 5));
		person5.addChild(new Person("Child", "1", 6));
		
		LinkedList<Person> persons = new LinkedList<Person>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);
		
		//LinkedList<Person> children = new LinkedList<Person>();
		
		try {
			
			Person.personToXML(persons, new FileOutputStream("./XML/people2.xml"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
