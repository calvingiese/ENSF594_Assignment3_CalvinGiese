import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AnagramPrinter {

	private String anagramString;
	
	public AnagramPrinter(String anagramString) {
		
		this.anagramString = anagramString;
	}
	
	public void Print() {
		
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter("output.txt");
			writer.println(anagramString);
			writer.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
