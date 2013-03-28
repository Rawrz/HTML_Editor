package Commands;

import Entities.Menu_Option;
import Entities.TheDocument;

/**
 * exectes the toggle wrap command
 * @author Ben Kantor
 *
 */
public class ToggleWrapCommand implements Menu_Option {
	
	private TheDocument doc;
	
	/**
	 * creates a toggle wrap command for the doc
	 * @param theDocument
	 */
	public ToggleWrapCommand(TheDocument theDocument){
		doc = theDocument;
	}
	
	@Override
	/**
	 * toggles the wrap for the document
	 */
	public void execute() {
		doc.toggleWrap();
	}

	@Override
	public void execute(Object obj) {}

}
