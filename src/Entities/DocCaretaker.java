package Entities;

import java.util.Stack;
import org.w3c.dom.Node;

/**
 * 
 * @author Ben Kantor (bdk3079@rit.edu)
 *
 */
public class DocCaretaker {	
	private Stack<Node> docStates = new Stack<Node>();
	
	/**
	 * Method: Stores a new document state to the caretaker
	 * @param node Root node of the HTML document tree
	 */
	public void storeState(Node root){
		docStates.push(root);
	}
	
	/**
	 * Method: Returns the most recent saved state of the document
	 */
	public Node returnLastState(){
		if (docStates.size() == 0){
			return null;
		} else {
			return docStates.pop();
		}
	}
}
