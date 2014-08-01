package edu.neumont.csc250;

import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;
import edu.neumont.csc250.lab4.Bookshelf;

public class GreedyShelver implements Shelver{

	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {
		
		QuickSorter<Book> sorter = new QuickSorter<Book>();
		sorter.sort(books);
		
		shelveBooksHelper(bookcase, books);
	}

	private void shelveBooksHelper(Bookcase bookcase, List<Book> books) {
	
		for (int shelfIndex = 0; shelfIndex < bookcase.getNumberOfShelves(); shelfIndex++){
			
			for (int bookIndex = 0; bookIndex < books.size(); bookIndex++){
				bookcase.addBook(bookcase.getBookshelf(shelfIndex), books.get(i));
			}
		}
		
	}

}
