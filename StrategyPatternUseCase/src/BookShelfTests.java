import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BookShelfTests {

	@Test
	public void addingRemovingBooks() {

		try {
			
			Book book1 = new Book("The Martian", 2016);
			Book book2 = new Book("The Hunger Games", 2015);
			Book book3 = new Book("The Great Gatsby", 2017);
			Book book4 = new Book("The Grapes of Wrath", 1);
			Book book5 = new Book("Nineteen Eighty Four", 43);
			Book book6 = new Book("Ulysses", 65);
			Book book7 = new Book("Lolita", 5457745);
			Book book8 = new Book("The Catcher in the Rye", 2);
			Book book9 = new Book("Beloved", 67);
			Book book10 = new Book("The Sound and the Fury", 12);
			Book book11 = new Book("The Lord of the Rings", 23);
			Book book12 = new Book("To Kill a Mockingbird", 655);
			
			BookShelf shelf = new BookShelf();
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			shelf.addBook(book4);
			shelf.addBook(book5);
			shelf.addBook(book6);
			shelf.addBook(book7);
			shelf.addBook(book8);
			shelf.addBook(book9);
			shelf.addBook(book10);
			shelf.addBook(book11);
			shelf.addBook(book12);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book1);
			correctList.add(book2);
			correctList.add(book3);
			correctList.add(book4);
			correctList.add(book5);
			correctList.add(book6);
			correctList.add(book7);
			correctList.add(book8);
			correctList.add(book9);
			correctList.add(book10);
			correctList.add(book11);
			correctList.add(book12);
			
			assertEquals(shelf.getBooks(), correctList);
			
			shelf.removeBook(book1);
			shelf.removeBook(book1);
			shelf.removeBook(book10);
			
			correctList.remove(book1);
			correctList.remove(book10);
			
			assertEquals(shelf.getBooks(), correctList);
			
		} catch (InvalidBookLength e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=InvalidBookLength.class)
	public void negativeLength() throws InvalidBookLength{
		Book book = new Book("The Martian", -1);
	}
	
	@Test
	public void sortByTitle(){
		try {
			Book book1 = new Book("A", 206);
			Book book2 = new Book("Z", 2015);
			Book book3 = new Book("G", 2017);
			
			BookShelf shelf = new BookShelf();
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book1);
			correctList.add(book3);
			correctList.add(book2);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void sortByLength(){
		try {
			Book book1 = new Book("A", 206);
			Book book2 = new Book("Z", 2);
			Book book3 = new Book("G", 2017);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book2);
			correctList.add(book1);
			correctList.add(book3);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void changeStrategy(){
		try {
			Book book1 = new Book("The Martian", 2016);
			Book book2 = new Book("The Hunger Games", 2015);
			Book book3 = new Book("The Great Gatsby", 2017);
			
			BookShelf shelf = new BookShelf();
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book3);
			correctList.add(book2);
			correctList.add(book1);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
			
			SortingStrategy strategy = new LengthSort();
			shelf.setSortStrategy(strategy);
			
			correctList = new ArrayList<Book>();
			correctList.add(book2);
			correctList.add(book1);
			correctList.add(book3);
			
			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
			
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}

	}

	@Test(expected=InvalidBookLength.class)
	public void zeroLength() throws InvalidBookLength{
		Book book = new Book("Zero Length", 0);
	}
	
	@Test
	public void reverseOrdered(){
		try {
			Book book1 = new Book("The Ultimate Pizza", 599);
			Book book2 = new Book("Chocolate Lovers", 432);
			Book book3 = new Book("Cooking 101", 313);
			Book book4 = new Book("Grilling For Dummies", 211);
			Book book5 = new Book("How to Boil Water", 100);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			shelf.addBook(book4);
			shelf.addBook(book5);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book5);
			correctList.add(book4);
			correctList.add(book3);
			correctList.add(book2);
			correctList.add(book1);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void inOrder(){
		try {
			Book book1 = new Book("The Ultimate Pizza", 599);
			Book book2 = new Book("Chocolate Lovers", 432);
			Book book3 = new Book("Cooking 101", 313);
			Book book4 = new Book("Grilling For Dummies", 211);
			Book book5 = new Book("How to Boil Water", 100);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book5);
			shelf.addBook(book4);
			shelf.addBook(book3);
			shelf.addBook(book2);
			shelf.addBook(book1);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book5);
			correctList.add(book4);
			correctList.add(book3);
			correctList.add(book2);
			correctList.add(book1);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void zeroBooks(){
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			List<Book> correctList = new ArrayList<Book>();

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);

	}
	
	@Test
	public void oneBook(){
		try {
			Book book1 = new Book("A", 206);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book1);

			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book1);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void sameBook(){
		try {
			Book book1 = new Book("A", 206);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book1);
			shelf.addBook(book1);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book1);
			correctList.add(book1);

			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void largeShelfTitles(){
		try {
			
			Book book1 = new Book("The Martian", 2016);
			Book book2 = new Book("The Hunger Games", 2015);
			Book book3 = new Book("The Great Gatsby", 2017);
			Book book4 = new Book("The Grapes of Wrath", 1);
			Book book5 = new Book("Nineteen Eighty Four", 43);
			Book book6 = new Book("Ulysses", 65);
			Book book7 = new Book("Lolita", 5457745);
			Book book8 = new Book("The Catcher in the Rye", 2);
			Book book9 = new Book("Beloved", 67);
			Book book10 = new Book("The Sound and the Fury", 12);
			Book book11 = new Book("The Lord of the Rings", 23);
			Book book12 = new Book("To Kill a Mockingbird", 655);
			
			BookShelf shelf = new BookShelf();
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			shelf.addBook(book4);
			shelf.addBook(book5);
			shelf.addBook(book6);
			shelf.addBook(book7);
			shelf.addBook(book8);
			shelf.addBook(book9);
			shelf.addBook(book10);
			shelf.addBook(book11);
			shelf.addBook(book12);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book9);
			correctList.add(book7);
			correctList.add(book5);
			correctList.add(book8);
			correctList.add(book4);
			correctList.add(book3);
			correctList.add(book2);
			correctList.add(book11);
			correctList.add(book1);
			correctList.add(book10);
			correctList.add(book12);
			correctList.add(book6);
			
			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
			
		} catch (InvalidBookLength e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void largeShelfLength(){
		try {
			
			Book book1 = new Book("The Martian", 2016);
			Book book2 = new Book("The Hunger Games", 2015);
			Book book3 = new Book("The Great Gatsby", 2017);
			Book book4 = new Book("The Grapes of Wrath", 1);
			Book book5 = new Book("Nineteen Eighty Four", 43);
			Book book6 = new Book("Ulysses", 65);
			Book book7 = new Book("Lolita", 5457745);
			Book book8 = new Book("The Catcher in the Rye", 2);
			Book book9 = new Book("Beloved", 67);
			Book book10 = new Book("The Sound and the Fury", 12);
			Book book11 = new Book("The Lord of the Rings", 23);
			Book book12 = new Book("To Kill a Mockingbird", 655);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			shelf.addBook(book4);
			shelf.addBook(book5);
			shelf.addBook(book6);
			shelf.addBook(book7);
			shelf.addBook(book8);
			shelf.addBook(book9);
			shelf.addBook(book10);
			shelf.addBook(book11);
			shelf.addBook(book12);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book4);
			correctList.add(book8);
			correctList.add(book10);
			correctList.add(book11);
			correctList.add(book5);
			correctList.add(book6);
			correctList.add(book9);
			correctList.add(book12);
			correctList.add(book2);
			correctList.add(book1);
			correctList.add(book3);
			correctList.add(book7);
			
			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
			
		} catch (InvalidBookLength e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void smallShelf(){
		
	}
	
	@Test
	public void sameTitle(){
		try {
			Book book1 = new Book("The Martian", 2016);
			Book book2 = new Book("Nineteen Eighty-Four", 206);
			Book book3 = new Book("Nineteen Eighty-Four", 2068);
			Book book4 = new Book("The Hunger Games", 2015);
			Book book5 = new Book("Zelda", 2017);
			
			BookShelf shelf = new BookShelf();
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			shelf.addBook(book4);
			shelf.addBook(book5);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book2);
			correctList.add(book3);
			correctList.add(book4);
			correctList.add(book1);
			correctList.add(book5);
			
			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void sameLength(){
		try {
			Book book1 = new Book("Brave New World", 206);
			Book book2 = new Book("To the Lighthouse", 206);
			Book book3 = new Book("Invisible Man", 206);
			
			BookShelf shelf = new BookShelf();
			shelf.setSortStrategy(new LengthSort());
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void symbolsInTitle(){
		try {
			Book book1 = new Book("~!@#$%^&*()_+{}|:?><.,", 206);
			Book book2 = new Book("1984", 206);
			Book book3 = new Book("Nineteen Eighty-Four", 206);
			Book book4 = new Book("@", 2657);
			
			BookShelf shelf = new BookShelf();
			
			shelf.addBook(book1);
			shelf.addBook(book2);
			shelf.addBook(book3);
			shelf.addBook(book4);
			
			List<Book> correctList = new ArrayList<Book>();
			correctList.add(book2);
			correctList.add(book4);
			correctList.add(book3);
			correctList.add(book1);
			
			shelf.sortBookShelf();
			
			assertEquals(shelf.getBooks(), correctList);
		} catch (InvalidBookLength e) {

			e.printStackTrace();
		}
	}
}
