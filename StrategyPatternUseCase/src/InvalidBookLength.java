
public class InvalidBookLength extends Exception {
	
	private int length;
	
	public InvalidBookLength(int length){
		this.length = length;
	}
	
	public int getInvalidLength(){
		return this.length;
	}
	
}
