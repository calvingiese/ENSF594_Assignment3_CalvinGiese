import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Name: TextReader
 * 
 * Reads the input text file and produces an array of words that were in the file.
 * 
 * The main purpose of this class is to read in the words in the input text file and return an array of words that were in the file and can also
 * sort the words in the array to make finding anagrams easier.
 * 
 * @author Calvin Giese
 * @version version 1.0
 * @since July 18, 2021
 *
 */

public class TextReader {
	
	/**
	 * The array of to fill with words in the input file.
	 */
	private String[] arrString;
	
	/**
	 * Constructs the TextReader with a blank array to begin.
	 */
	public TextReader () {
		this.arrString = null;
	}

	/**
	 * This method is used to find the words included in the input text file.
	 * 
	 * @return the array of words found in the file.
	 * @throws FileNotFoundException in case the file is not found
	 */
	public String[] getTextArray() throws FileNotFoundException{
		
		// Reads the input text
		File file = new File("input.txt");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);		
		List<String> lines = new ArrayList<String>();
		
		while(sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		
		String[] array = lines.toArray(new String[0]);
		
		// Counts the number of blank lines
		int nonBlanks = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != "") {
				nonBlanks++;
			}
		}
		
		// Builds an array of words without any blank lines between
		this.arrString = new String[nonBlanks];
		
		for(int j = 0, k = 0; j < array.length; j++) {
			if(array[j] != "") {
				this.arrString[k] = array[j];
				k++;
			}
		}
		
		return this.arrString;
	}
	
	/**
	 * This method takes in array of words in their raw format and sorts the letters from lowest character value to highest
	 * 
	 * @param arr is the array of words from the text file
	 * @return the array of words that have been sorted
	 */
	public String[] sortArray(String[] arr) {
		
		this.arrString = arr;
		
		for(int i = 0; i < this.arrString.length; i++) {
			String temp = sortString(arr[i]);
			this.arrString[i] = temp;
		}
		return this.arrString;
	}
	
	/**
	 * This method converts sorts the letters of a string. It converts the characters of the string to the integer value, sorts the integers and 
	 * converts them back to characters and puts the characters back to string formatting.
	 * 
	 * @param s is the word/string to sort
	 * @return the string with the characters sorted
	 */
	private String sortString(String s) {
		
		int[] charVals = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			charVals[i] = s.charAt(i);
		}
		
		for(int j = 1, k; j < charVals.length; j++) {
			int temp = charVals[j];
			for(k = j; k > 0 && temp < charVals[k - 1]; k--)
				charVals[k] = charVals[k - 1];
			charVals[k] = temp;
		}
		
		StringBuffer b1 = new StringBuffer();
		for(int z = 0; z < charVals.length; z++) {
			b1.append((char)charVals[z]);
		}
			
		String sortedString = b1.toString();
		
		return sortedString;
	}
}
