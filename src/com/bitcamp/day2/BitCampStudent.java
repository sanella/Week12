package com.bitcamp.day2;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

public class BitCampStudent {
	public static int numberOfStudents = 22;
	public ArrayList<Student> students = new ArrayList<Student>();
	
	public BitCampStudent(int numberOfStudents, ArrayList<Student> students ){
		this.numberOfStudents = numberOfStudents;
		this.students = students;
		
	}

	

	public String toXML() {
		String str = "";
		str = "<numberOfStudents>" + numberOfStudents + "</numberOfStudents>\n";
		for (Student st : students) {
			str += "<student>" + st.toXML() + "</student>\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Student st1 = new Student("hanifa", "lola");
		Student st2 = new Student("hani", "lo");
		
		ArrayList<Student> students1 = new ArrayList<Student>();
		students1.add(st1);
		students1.add(st2);
		
		BitCampStudent test = new BitCampStudent(numberOfStudents, students1);
		System.out.println(test.toXML());
		Document xmldoc;
		File selectedFile = new File("xml.txt");
		DocumentBuilder docReader 
        = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmldoc = docReader.parse(new InputSource(new StringReader(".xml.txt")));
	}
}
