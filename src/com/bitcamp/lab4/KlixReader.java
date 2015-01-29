package com.bitcamp.lab4;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bitcamp.lab3.Person;

public class KlixReader {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document xmldoc = docReader.parse(new URL(
				"http://www.klix.ba/rss/svevijesti").openStream());

		NodeList xmlTitle = xmldoc.getElementsByTagName("title");
		NodeList xmlClanak = xmldoc.getElementsByTagName("clanak");

		HashMap<String, String> hm = new HashMap<String, String>();
		// petlja sa dva uslova
		for (int i = 0, j = 2; i < xmlClanak.getLength()
				&& j < xmlTitle.getLength(); i++, j++) {
			String title = xmlTitle.item(j).getTextContent();
			String clanak = xmlClanak.item(i).getTextContent();
			// OVO JE BENJINA HASHMAPA <3
			hm.put(title, clanak);
			
		}
		// napravili smo Set koji ima keye-ve
		Set<String> keys = hm.keySet();
		// da bi prosli kroz set treba na iterator
		Iterator<String> it = keys.iterator();
		String first = it.next();
		//ispisuje mi naslov - keye
		System.out.println(first);
		//ispisuje mi clanak koristeci hashmapu i kez koji imamo
		System.out.println(hm.get(first));
	}
}