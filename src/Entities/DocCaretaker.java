package Entities;

import java.util.Stack;
import org.w3c.dom.Node;

/**
 * 
 * @author Ben Kantor (bdk3079@rit.edu)
 *
 */
public class DocCaretaker {	
	private Stack<String> docStates = new Stack<String>();
	
	/**
	 * Method: Stores a new document state to the caretaker
	 * @param node Root node of the HTML document tree
	 */
	public void storeState(String text){
		docStates.push(text);
	}
	
	/**
	 * Method: Returns the most recent saved state of the document
	 */
	public String returnLastState(){
		if (docStates.size() == 0){
			return null;
		} else {
			return docStates.pop();
		}
	}
}
