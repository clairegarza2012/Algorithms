package edu.neumont.csc250;

import java.util.List;
import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;

public class DynamicShelver implements Shelver{

	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {

		QuickSorter<Book> sorter = new QuickSorter<Book>();
		sorter.sort(books);

		shelveBooksHelper(bookcase, books, bookcase.getShelfWidth());
	}

	private void shelveBooksHelper(Bookcase bookcase, List<Book> books, int bookshelfWidth) {

		int[][]  extras = new int[books.size() + 1][books.size() + 1];
		int[][]  lc = new int[books.size() + 1][books.size() + 1];

		int[] costArray = new int[books.size() + 1];
		int[] positionArray = new int[books.size() + 1];

		int max = (int) Math.sqrt(Integer.MAX_VALUE);

		for (int i = 1; i <= books.size(); i++){
			extras[i][i] = bookshelfWidth - books.get(i - 1).getWidth();

			for (int j = i + 1; j <= books.size(); j++){
				extras[i][j] = extras[i][j-1] - books.get(j - 1).getWidth(); //
			}
		}

		for (int i = 1; i <= books.size(); i++){
			for (int j = i; j <= books.size(); j++){

				if (extras[i][j] < 0){
					lc[i][j] = max;
				}
				else if (j == books.size() && extras[i][j] >= 0){
					lc[i][j] = 0;
				}
				else{
					lc[i][j] = extras[i][j] * extras[i][j];
				}
			}
		}

		costArray[0] = 0;

		for (int j = 1; j <= books.size(); j++){
			costArray[j] = max;

			for (int i = 1; i <= j; i++){
				if (costArray[i - 1] != max && lc[i][j] != max && costArray[i-1] + lc[i][j] < costArray[j]){
					costArray[j] = costArray[i - 1] + lc[i][j];
					positionArray[j] = i;
				}
			}
		}

		populateBookcase(bookcase, positionArray, books, books.size());
	}

	private int populateBookcase(Bookcase bookcase, int[] positionArray, List<Book> books, int n){

		int k = 0;
		if (positionArray[n] == 1){
			k = 1;
		}
		else{
			k = populateBookcase(bookcase, positionArray, books, positionArray[n] - 1) + 1;
		}
		for (int i = positionArray[n] - 1; i < n; i++){
			bookcase.getBookshelf(k - 1).addBook(books.get(i));
		}

		return k;
	}
}
