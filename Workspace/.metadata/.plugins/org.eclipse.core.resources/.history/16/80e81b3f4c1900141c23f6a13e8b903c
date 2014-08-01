package edu.neumont.csc250;

import java.util.Iterator;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookshelf;

public class BookshelfIterator extends Bookshelf implements Iterator<Book>{

	int bookIndex = 0;
	
	public BookshelfIterator(int width) {
		super(width);
	}

	@Override
	public boolean hasNext() {
		return bookIndex + 1 < super.books.size();
	}

	@Override
	public Book next() {
		
		return super.books.get(bookIndex++);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	
}
