import java.util.ArrayList;
import java.util.List;

/** Sorts all Books in a BookShelf alphabetically using Insertion Sort */
public class TitleSort implements SortingStrategy {

	public TitleSort(){};
	
	/** 
	 * @param currentShelf - a List of Books
	 * 
	 * Sorts the given list of books into alphabetical order by book title.
	 * Uses Insertion Sort.
	 * 
	 * @return a sorted list of books
	 * */
	public List<Book> sort(List<Book> currentShelf) {
		List<Book> newShelf = new ArrayList<Book>();
		
		for(Book currBook : currentShelf){
			
			if(newShelf.size() == 0){
				newShelf.add(currBook);
				continue;
			}
			
			for(int i = 0; i <= newShelf.size(); i++){
				
				if(i == newShelf.size()){
					newShelf.add(currBook);
					break;
				}
				
				if(alphaOrder(currBook.getTitle(), newShelf.get(i).getTitle())){
					newShelf.add(i, currBook);
					break;
				}
			}
		}
		
		return newShelf;
	}
	
	/** 
	 * @param firstString - A string from the first book
	 * @param secondString - A string from the second book
	 * 
	 * method is used to compare two strings and determine which one comes first alphabetically.
	 * 
	 * @return boolean - False if the second string comes after the first string or if the strings are equal,
	 * 				     True if the second string goes before the first string
	 * */
	private boolean alphaOrder(String firstString, String secondString){
		
		for(int i = 0; i < firstString.length(); i++){
			
			char character = firstString.charAt(i);
			
			if(character < secondString.charAt(i)){
				return true;
				
			}else if(character > secondString.charAt(i)){
				return false;
			}
		}
		return false;
	}
}
