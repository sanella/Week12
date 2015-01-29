package com.bitcamp.lab4.Xpath;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {
		// docReader vraca objekat Document
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		// u xmldoc dajem lokaciju filea sa kojeg citamo
		Document xmldoc = docReader.parse(new File("./XML/people2.xml"));

		XPath xPath = XPathFactory.newInstance().newXPath();

		String expression = "(//person[age > 3])[2]";
		NodeList xmlPeople = (NodeList) xPath.compile(expression).evaluate(
				xmldoc, XPathConstants.NODESET);

		LinkedList people = new LinkedList<Person>();

		// petlja da prodjemo kroz Node listu
		for (int i = 0; i < xmlPeople.getLength(); i++) {
			Node current = xmlPeople.item(i);

			if (current instanceof Element) {

				Element currentElement = (Element) current;
				String name = currentElement.getAttribute("name");
				String surname = currentElement.getAttribute("surname");
				NodeList childNodes = currentElement.getChildNodes();
				int age = 0;
				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeName().equals("age"))
						age = Integer.parseInt(childNodes.item(j)
								.getTextContent());
				}
				Person personTemp = new Person(name, surname, age);
				NodeList xmlChildren = current.getChildNodes();
				for (int j = 0; j < xmlChildren.getLength(); j++) {
					Node currentChild = xmlChildren.item(j);
					if(currentChild.getNodeName().equals("age"))
						continue;
					if (currentChild instanceof Element) {
						Element currentChildElement = (Element) currentChild;
						String childName = currentChildElement
								.getAttribute("name");
						String childSurname = currentChildElement
								.getAttribute("surname");
						int ageChilde = Integer.parseInt(currentChildElement
								.getAttribute("age"));
						// dodajemo nove atribute na roditelje tj childe
						personTemp.addChild(new Person(childName, childSurname,
								ageChilde));
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
