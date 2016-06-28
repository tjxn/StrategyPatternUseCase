import java.util.ArrayList;
import java.util.List;

/** 
 * A BookShelf contains a list of books and has a Sorting Strategy
 * A BookShelf's default sorting strategy is by Title 
 * */
public class BookShelf {

	private List<Book> books;
	private SortingStrategy sortStrategy;
	
	public BookShelf() {
		this.books = new ArrayList<Book>();
		this.sortStrategy = new TitleSort();;
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
	
	public void removeBook(Book book){
		this.books.remove(book);
	}
	
	public void addBook(Book book){
		this.books.add(book);
	}
	
	public void setSortStrategy(SortingStrategy strategy){
		this.sortStrategy = strategy;
	}
	
	public void sortBookShelf(){
		this.books = this.sortStrategy.sort(this.books);
	}
	
	
	/** 
	 * @param none
	 * Prints out a list of the books on the shelf in order from first position to last.
	 * @return void
	 * */
	public void showBooks(){
		for(Book book : this.books){
			System.out.println("Title: " + book.getTitle() + ", Length: " + book.getLength());
		}
	}
}
