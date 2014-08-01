package edu.neumont.csc250;

import java.util.ArrayList;
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
		List<Bookcase> successes = new ArrayList<>();

		findPermutations(soFar, books, successes);

		Bookcase mostEvenness = successes.get(0);
		
		for (int i = 1; i < successes.size(); i++){
			if (mostEvenness.scoreShelfEvenness() > successes.get(i).scoreShelfEvenness()){
				mostEvenness = successes.get(i);
			}
		}
		//System.out.println(mostEvenness);
		
//		System.out.println(bookcase);		
//		for (int shelfIndex = 0; shelfIndex < mostEvenness.getNumberOfShelves(); shelfIndex++){
//
//			mostEvenness.getBookshelf(shelfIndex).ge
//			
//		}
		
		System.out.println(bookcase);
		
		bookcase.mostEvenness;
		
		System.out.println(bookcase);
	}
	
	private void findPermutations(List<Book> soFar, List<Book> toGo, List<Bookcase> successes){
		
		if (toGo.isEmpty() ){
			Bookcase bookcase = new Bookcase(numberOfShelves, shelfWidth);
			
			int bookIndex = 0;
			for (int shelfIndex = 0; shelfIndex < bookcase.getNumberOfShelves(); shelfIndex++){

				while(bookIndex < soFar.size() && bookcase.getBookshelf(shelfIndex).addBook(soFar.get(bookIndex))){
					bookIndex ++;
				}

			}
			
			successes.add(bookcase);
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
