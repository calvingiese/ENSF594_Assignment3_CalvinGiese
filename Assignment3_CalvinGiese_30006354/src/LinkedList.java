/**
 * Class Name: LinkedList
 * 
 * Creates a linked list of words, allowing a word to be added to the start of the list.
 * 
 * The main purpose of this class is to create a linked list and allow words to be added to the list.
 * 
 * @author Calvin Giese
 * @version version 1.0
 * @since July 18, 2021
 *
 */

public class LinkedList {
	
	/**
	 * Head is the first element of a linked list.
	 */
	private Word head;
	
	/**
	 * Constructs a linked list with the head being empty.
	 */
	public LinkedList() {
		head = null;
	}
	
	/**
	 * This method inserts a word to the linked list, setting the word as the head if it's the only element.
	 * 
	 * @param word is the word to be added.
	 */
	public void insertAtStart(Word word) {
		
		if(head == null) {
			head = word;
		}
		else {
			word.setNext(head);
			head = word;
		}
	}
	
	/**
	 * This method allows the program to identify what the head of the linked list is.
	 * 
	 * @return the 'head' word of the list.
	 */
	public Word getHead() {
		return head;
	}
	
	/**
	 * This method is used to convert the linked list to a string where a space separates ones with multiple words.
	 */
	public String toString() {
		Word current = head;
		StringBuffer b1 = new StringBuffer();
		while(current != null) {
			b1.append(current.getWord() + " ");
			current = current.getNext();
		}
		String words = b1.toString();
		return words;
	}
	
}
