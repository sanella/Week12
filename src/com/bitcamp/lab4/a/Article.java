package com.bitcamp.lab4.a;

public class Article {
	public static String title;
	public static String clanak;
	
	public Article(String title, String clanak){
		this.title = title;
		this.clanak = clanak;
	}

	@Override
	public String toString() {
		return "Article []";
	}

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Article.title = title;
	}

	public static String getClanak() {
		return clanak;
	}

	public static void setClanak(String clanak) {
		Article.clanak = clanak;
	}
	
	
}
