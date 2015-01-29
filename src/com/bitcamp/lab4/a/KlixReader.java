package com.bitcamp.lab4.a;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

import com.bitcamp.lab3.Person;

public class KlixReader {
	public static void main(String[] args) throws ParserConfigurationException,
			MalformedURLException, SAXException, IOException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document xmldoc = docReader.parse(new URL(
				"http://www.klix.ba/rss/svevijesti").openStream());

		NodeList xmlKlix = xmldoc.getElementsByTagName("item");

		LinkedList<Article> articles = new LinkedList<Article>();

		for (int i = 0; i < xmlKlix.getLength(); i++) {
			Node current = xmlKlix.item(i);

			if (current instanceof Element) {
				Element currentElement = (Element) current;

				//drugi dio
				if (currentElement.hasChildNodes()) {

					NodeList titleList = currentElement
							.getElementsByTagName("title");
					NodeList contentList = currentElement
							.getElementsByTagName("clanak");

					for (int j = 0; j < titleList.getLength(); j++) {

						Node currentTitle = titleList.item(j);
						Node currentClanak = contentList.item(j);
							
							String title = currentTitle.getTextContent();
							String content = currentClanak.getTextContent();

							articles.add(new Article(title, content));
						
					}
				}
			}
		}
		Iterator<Article> it = articles.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());			
			

		}

	}
}