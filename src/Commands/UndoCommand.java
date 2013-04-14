package Commands;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 *  Command Class for undoing editing commands that are called on the document
 * 
 * @author Ben Kantor (bkantor01@gmail.com)
 */
public class UndoCommand implements Menu_Option{
	
	private TheDocument doc;
	
	/**
	 * Executes the command object
	 */
	public void execute() {
		
	}

	/**
	 * Overloaded method that executes the command object with a passed in 
	 * object.
	 */
	public void execute(Object obj) {
		
	}

}
