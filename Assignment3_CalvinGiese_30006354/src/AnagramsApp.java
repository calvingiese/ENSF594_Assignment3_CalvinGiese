import java.io.FileNotFoundException;

/**
 * Class Name: AnagramsApp
 * 
 * Runs the anagram program through the main method, reading words from text and then printing them as a list of anagrams
 * 
 * The main purpose of this class is to read in the words in the input text file, find which words are anagrams and then print the list
 * of anagrams to a new (output) text file.
 * 
 * @author Calvin Giese
 * @version version 1.0
 * @since July 18, 2021
 *
 */

public class AnagramsApp {
	
	public static void main(String[] args ) throws FileNotFoundException {
		
		// Reads in the text file and keeps words in unsorted format
		TextReader readText = new TextReader();
		String[] textArray = readText.getTextArray();
		
		// Reads in the text file and sorts words
		TextReader sortText = new TextReader();
		String[] sortArray = sortText.getTextArray();
		String[] sortedArray = sortText.sortArray(sortArray);
		
		// Creates list of anagrams
		AnagramList list = new AnagramList(textArray, sortedArray);
		
		// Exports the text file
		TextPrinter printer = new TextPrinter(list.makeLinkedList());
		printer.Print(printer.toString());
	}
}
