package com.wipro.microservices.solid;

public class book {
	String name;
	String authorName;
	int year;
	int price;
	String isbn;
 
	public void Book(String name, String authorName, int year, int price, String isbn) {
		this.name = name;
		this.authorName = authorName;
		this.year = year;
        this.price = price;
		this.isbn = isbn;
	}

}
