/**
 * Class Name: AnagramList
 * 
 * Constructs a new AnagramList with an empty array to fill with the list of anagrams from the text file.
 * 
 * The main purpose of this class is to create linked lists for the words in the input text file and fill the anagram array with the lists.
 * 
 * @author Calvin Giese
 * @version version 1.0
 * @since July 18, 2021
 *
 */
public class AnagramList {
	
	/**
	 * Original array of strings found in the text file.
	 */
	private String[] orig;
	
	/**
	 * Array of sorted words from the text file (e.g. car in the original is acr in the sorted array).
	 */
	private String[] sort;
	
	/**
	 * Array to be filled with linked list words.
	 */
	private String[] anagram;

	/**
	 * Constructor for the class, setting the original and sorted arrays to what's being passed to the class and making an empty anagram array.
	 * 
	 * @param orig is the original array of words
	 * @param sort is the sorted words array
	 */
	public AnagramList(String[] orig, String[] sort) {
		this.orig = orig;
		this.sort = sort;
		this.anagram = null;
	}
	
	/**
	 * This class is used to create the linked lists and return an array where each element is a list of anagrams.
	 * 
	 * @return the array of anagram word lists
	 */
	public String[] makeLinkedList() {
		
		// Start by finding the length of the anagram array by seeing how many anagrams are present
		int length = this.sort.length;
		
		for(int i = 0; i < this.sort.length; i++) {
			for(int j = i; j < this.sort.length; j++) {
				if(i != j) {
					if(this.sort[i].equals(this.sort[j])) {
						length--;
						j = this.sort.length;
					}
				}
			}
		}
		
		// Build anagram array with the corrected length and temporary ones to fill with all lists of words, sorted and original
		this.anagram = new String[length];
		String[] temp = new String[this.orig.length];
		
		for(int i = 0; i < this.sort.length; i++) {
			LinkedList list = new LinkedList();
			list.insertAtStart(new Word(this.sort[i]));
			for(int j = 0; j < this.sort.length; j++) {
				if(i != j) {
					if(this.orig[i].equals(this.orig[j])) {
						break;
					}
					else if(this.sort[i].equals(this.sort[j])) {
						list.insertAtStart(new Word(this.sort[j]));
					}
				}
			}
			temp[i] = list.toString();
		}
		
		String[] temp2 = new String[this.orig.length];
		
		for(int i = 0; i < this.sort.length; i++) {
			LinkedList list2 = new LinkedList();
			list2.insertAtStart(new Word(this.orig[i]));
			for(int j = 0; j < this.sort.length; j++) {
				if(i != j) {
					if(this.orig[i].equals(this.orig[j])) {
						break;
					}
					else if(this.sort[i].equals(this.sort[j])) {
						list2.insertAtStart(new Word(this.orig[j]));
					}
				}
			}
			temp2[i] = list2.toString();
		}
		
		// Builds empty return array to fill with list of anagrams
		this.anagram = new String[length];
		int count = 0;
		
		// Fill anagram array with lists of anagrams, not repeating from the temp array
		for(int i = 0; i < temp.length; i++) {
			int test = 0;
			for(int j = 0; j < temp.length; j++) {
				if(i != j) {
					if(i < j) {
						if(temp2[i].equals(temp2[j])) {
						test = 1;
						j = temp.length;
						}
					}
				}
			}
			if(count < length) {
				if(test == 0) {
					this.anagram[count] = temp2[i];
					count += 1;
				}
			}
		}
		
		return this.anagram;
	}
}
