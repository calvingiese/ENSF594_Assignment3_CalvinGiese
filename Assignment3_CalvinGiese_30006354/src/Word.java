/**
 * Class Name: Word
 * 
 * A Word is a component of the linked list in this program, consisting of a string value and points to the next string in the list.
 * 
 * @author Calvin Giese
 * @version version 1.0
 * @since July 18, 2021
 *
 */

public class Word {

	/**
	 * The word to be included in the linked list.
	 */
	private String word;
	
	/**
	 * The next word in the linked list that the current word points to.
	 */
	private Word next;
	
	/**
	 * Constructs the word with the string that's been passed and sets the pointer to null to begin.
	 * 
	 * @param word
	 */
	public Word(String word) {
		setWord(word);
		setNext(null);
	}
	
	/**
	 * Method used to retrieve the current word.
	 * 
	 * @return the current word.
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Sets the value of the string to the word passed to the class.
	 * 
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * Method to retrieve the value of the next word in the linked list.
	 * 
	 * @return the next word in the list.
	 */
	public Word getNext() {
		return next;
	}
	
	/**
	 * Sets the string value of the next word as the passed argument
	 * 
	 * @param next is the next word in the list.
	 */
	public void setNext(Word next) {
		this.next = next;
	}
}
