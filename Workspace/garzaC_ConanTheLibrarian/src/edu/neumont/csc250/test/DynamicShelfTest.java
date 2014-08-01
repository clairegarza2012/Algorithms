package edu.neumont.csc250.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.neumont.csc250.DynamicShelver;
import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public class DynamicShelfTest {

	@Test
	public void test() {

		int numberOfShelves = 3;
		int shelfWidth = 6;

		Bookcase bookcase = new Bookcase(numberOfShelves, shelfWidth);
		DynamicShelver shelver = new DynamicShelver();

		
		List<Book> books = new ArrayList<Book>();

		Book book1 = new Book("duper", 3, 4);
		Book book2 = new Book("is", 2, 5);
		Book book3 = new Book("Claire", 5, 6);
		Book book4 = new Book("amazing", 1, 3);
		Book book5 = new Book("super", 1, 5);

		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);

		shelver.shelveBooks(bookcase, books);

		Assert.assertEquals(1, bookcase.getBookshelf(0).getBookCount());
		Assert.assertEquals(2, bookcase.getBookshelf(1).getBookCount());
		Assert.assertEquals(2, bookcase.getBookshelf(2).getBookCount());
		
		Assert.assertEquals(1, bookcase.getBookshelf(0).getSpaceLeft());
		Assert.assertEquals(3, bookcase.getBookshelf(1).getSpaceLeft());
		Assert.assertEquals(2, bookcase.getBookshelf(2).getSpaceLeft());
		
		System.out.println(bookcase);
	}

	@Test
	public void classTest(){
		
		int numberOfShelves = 3;
		int shelfWidth = 6;

		Bookcase bookcase = new Bookcase(numberOfShelves, shelfWidth);
		DynamicShelver shelver = new DynamicShelver();
		
		List<Book> books = new ArrayList<Book>();

		Book book1 = new Book("class", 2, 4);
		Book book2 = new Book("was", 2, 5);
		Book book3 = new Book("This", 3, 6);
		Book book4 = new Book("example", 5, 3);

		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);

		shelver.shelveBooks(bookcase, books);
		
		Assert.assertEquals(1, bookcase.getBookshelf(0).getBookCount());
		Assert.assertEquals(2, bookcase.getBookshelf(1).getBookCount());
		Assert.assertEquals(1, bookcase.getBookshelf(2).getBookCount());
		
		Assert.assertEquals(3, bookcase.getBookshelf(0).getSpaceLeft());
		Assert.assertEquals(2, bookcase.getBookshelf(1).getSpaceLeft());
		Assert.assertEquals(1, bookcase.getBookshelf(2).getSpaceLeft());
		
		System.out.println(bookcase);
	}

}
