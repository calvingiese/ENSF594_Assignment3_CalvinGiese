import java.io.FileNotFoundException;

public class AnagramsOrganizer {
	
	public static void main(String[] args ) throws FileNotFoundException {
		
		// Reads in the text file
		AnagramReader anagramString = new AnagramReader();
		String displayText = anagramString.readText();
		
		System.out.println(displayText);
		
		// Creates list of anagrams
		String anagramList = displayText;
		
		
		// Exports the text file
		AnagramPrinter printer = new AnagramPrinter(anagramList);
		printer.Print();
		
	}

}
