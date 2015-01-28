package com.bitcamp.lab3;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		// docReader vraca objekat Document
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document xmldoc = docReader.parse(new File("./XML/people.xml"));
		NodeList xmlPeople = xmldoc.getElementsByTagName("person");
		LinkedList people = new LinkedList<Person>();
		for (int i = 0; i < xmlPeople.getLength(); i++) {

			Node current = xmlPeople.item(i);

			if (current instanceof Element) {
				Element currentElement = (Element) current;
				String name = currentElement.getAttribute("name");
				String surname = currentElement.getAttribute("surname");
				people.add(new Person(name, surname));
			}

		}
		Iterator<Person> it = people.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
