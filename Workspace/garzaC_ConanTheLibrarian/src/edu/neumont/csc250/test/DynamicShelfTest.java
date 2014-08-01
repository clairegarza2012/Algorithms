package edu.neumont.csc250.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.neumont.csc250.DynamicShelver;
import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public class DynamicShelfTest {

	private int numberOfShelves = 3;
	private int shelfWidth = 6;
	private Bookcase bookcase = new Bookcase(numberOfShelves, shelfWidth);

	private DynamicShelver shelver = new DynamicShelver();

	@Test
	public void test() {

		List<Book> books = new ArrayList<Book>();

		Book book1 = new Book("super", 3, 4);
		Book book2 = new Book("is", 2, 5);
		Book book3 = new Book("Claire", 3, 6);
		Book book4 = new Book("amazing", 4, 3);
		Book book5 = new Book("duper", 1, 5);

		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);

		shelver.shelveBooks(bookcase, books);

		Assert.assertEquals(2, bookcase.getBookshelf(0).getBookCount());
		Assert.assertEquals(2, bookcase.getBookshelf(1).getBookCount());
		Assert.assertEquals(1, bookcase.getBookshelf(2).getBookCount());
		
		Assert.assertEquals(1, bookcase.getBookshelf(0).getSpaceLeft());
		Assert.assertEquals(2, bookcase.getBookshelf(1).getSpaceLeft());
		Assert.assertEquals(2, bookcase.getBookshelf(2).getSpaceLeft());
		
		System.out.println(bookcase);
	}

}