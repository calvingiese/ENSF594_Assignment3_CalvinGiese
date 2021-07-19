
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnagramReader {

	private String anagramString;
	
	public AnagramReader() {
		this.anagramString = null;
	}
	
	public String readText() throws FileNotFoundException {
		
		File file = new File("input.txt");
		StringBuffer b1 = new StringBuffer();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			
			b1.append(sc.nextLine());
			b1.append('\n');
		}
		
		this.anagramString = b1.toString();
		
		return this.anagramString;
	}
}
