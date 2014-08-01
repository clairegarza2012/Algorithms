package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public class DynamicShelver implements Shelver{

	private int numberOfShelves;
	private int shelfWidth;
	
	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {

		numberOfShelves = bookcase.getNumberOfShelves();
		shelfWidth = bookcase.getShelfWidth();
		
		QuickSorter<Book> sorter = new QuickSorter<Book>();
		sorter.sort(books);
		
		shelveBooksHelper(bookcase, books);
	}

	private void shelveBooksHelper(Bookcase bookcase, List<Book> books) {

		List<Book> soFar = new ArrayList<>();
		HashMap<Integer, MyBookcase> successes = new HashMap<>();

		findPermutations(soFar, books, successes);

		MyBookcase mostEvenness = successes.get(0);
		
		for (int i = 1; i < successes.size(); i++){
			if (mostEvenness.getBookcase().scoreShelfEvenness() > successes.get(i).getBookcase().scoreShelfEvenness()){
				mostEvenness = successes.get(i);
			}
		}
	
		int bookIndex = 0;
		for (int shelfIndex = 0; shelfIndex < mostEvenness.getBookcase().getNumberOfShelves(); shelfIndex++){

			while(bookIndex < mostEvenness.getBooks().size() && bookcase.getBookshelf(shelfIndex).addBook(mostEvenness.getBooks().get(bookIndex))){
				bookIndex ++;
			}	
		}		
		
	}
	private int count = 0;
	private void findPermutations(List<Book> soFar, List<Book> toGo, HashMap<Integer, MyBookcase> successes){
		
		if (toGo.isEmpty() ){
			Bookcase bookcase = new Bookcase(numberOfShelves, shelfWidth);
			
			int bookIndex = 0;
			for (int shelfIndex = 0; shelfIndex < bookcase.getNumberOfShelves(); shelfIndex++){

				while(bookIndex < soFar.size() && bookcase.getBookshelf(shelfIndex).addBook(soFar.get(bookIndex))){
					bookIndex ++;
				}

			}
			MyBookcase mB = new MyBookcase(bookcase, soFar);
			successes.put(count++, mB);
			return;
		}

		for (int index = 0; index < toGo.size(); index++){

			Book i  = toGo.get(index);
			List<Book> newSoFar = new ArrayList<Book>(soFar);
			newSoFar.add(i);

			List<Book> newToGo = new ArrayList<Book>();
			newToGo.addAll(toGo);
			newToGo.remove(i);

			findPermutations(newSoFar, newToGo, successes);
		}
	}

}
