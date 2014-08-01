package edu.neumont.csc250;

import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public class MyBookcase {

	private Bookcase bookcase;
	private List<Book> books;
	
	public MyBookcase(Bookcase bookcase, List<Book> books){
		this.bookcase = bookcase;
		this.books = books;
	}

	public Bookcase getBookcase() {
		return bookcase;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	
}
