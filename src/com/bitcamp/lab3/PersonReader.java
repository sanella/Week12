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
		// u xmldoc dajem lokaciju filea sa kojeg citamo
		Document xmldoc = docReader.parse(new File("./XML/people.xml"));
		// NodeList koristimo za xml gdje dodajemo nodove iz xml-a
		NodeList xmlPeople = xmldoc.getElementsByTagName("person");

		LinkedList people = new LinkedList<Person>();

		// petlja da prodjemo kroz Node listu
		for (int i = 0; i < xmlPeople.getLength(); i++) {
			Node current = xmlPeople.item(i);

			// moramo provjeriti da bi mogli koristiti metode npr getAttribute
			if (current instanceof Element) {
				// ako jeste onda kastamo:
				Element currentElement = (Element) current;
				// Uzimamo od prvog noda atribute name i surname
				String name = currentElement.getAttribute("name");
				String surname = currentElement.getAttribute("surname");
				// pravimo novi objekat kojem dodajemo atribute
				Person personTemp = new Person(name, surname);
				// DIO ZA CHILDE:
				// Pravimo novu NodeListu koja je lista od prve liste
				NodeList xmlChildren = current.getChildNodes();
				// sve isto kao i prvi put
				for (int j = 0; j < xmlChildren.getLength(); j++) {
					Node currentChild = xmlChildren.item(j);
					if (currentChild instanceof Element) {
						Element currentChildElement = (Element) currentChild;
						String childName = currentChildElement
								.getAttribute("name");
						String childSurname = currentChildElement
								.getAttribute("surname");
						// dodajemo nove atribute na roditelje tj childe
						personTemp
								.addChild(new Person(childName, childSurname));
					}
				}
				people.add(personTemp);
			}

		}
		// prolazak kroz LinkedListu
		Iterator<Person> it = people.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
