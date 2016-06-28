/** A Book is made up of a Title and a Length (number of pages) */
public class Book {

	private String title;
	private int length;
	
	public Book(String title, int length) throws InvalidBookLength{
		this.title = title;
		
		if(length < 1){
			throw new InvalidBookLength(length);
		}else {
			this.length = length;
		}
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getLength(){
		return this.length;
	}
	
}
