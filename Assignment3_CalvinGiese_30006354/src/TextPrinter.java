import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class Name: TextPrinter
 * 
 * Prints the list of anagrams to an output text file.
 * 
 * The main purpose of this class is to print lists of anagrams to a text file. It also turns an array of words into a properly formatted string to print.
 * 
 * @author Calvin Giese
 * @version version 1.0
 * @since July 18, 2021
 *
 */

public class TextPrinter {

	/**
	 * The array of linked lists.
	 */
	private String[] arr;
	
	/**
	 * The array of linked lists in string formatted that can be printed to a text file.
	 */
	private String printArray;
	
	/**
	 * Constructs the TextPrinter with the array of linked lists being passed to the class and the print string being set to null to begin.
	 * 
	 * @param array is the array of linked lists that is to be printed.
	 */
	public TextPrinter(String[] array) {
		this.arr = array;
		this.printArray = null;
	}
	
	/**
	 * This method converts the array of linked lists to a string with a blank line between each linked list.
	 */
	public String toString() {
		
		StringBuffer b1 = new StringBuffer();
		
		for(int i = 0; i < this.arr.length; i++) {
			b1.append(this.arr[i]);
			if(i < this.arr.length - 1) {
				b1.append('\n');
				b1.append('\n');
			}
		}
		this.printArray = b1.toString();
		return this.printArray;
	}
	
	/**
	 * Prints the converted anagram array in the proper string format to an output text file.
	 * 
	 * @param outputString is the string to be printed.
	 */
	public void Print(String outputString) {
		
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter("output.txt");
			writer.println(outputString);
			writer.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
