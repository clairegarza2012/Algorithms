package edu.neumont.csc250;

import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public interface Shelver {

	public void shelveBooks(Bookcase bookcase, List<Book> books);
	
}
