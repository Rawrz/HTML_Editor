package Commands;

import Entities.Menu_Option;
import Entities.TheDocument;

/**
 * executes the toggle indent command
 * @author Ben Kantor
 *
 */
public class ToggleIndentCommand implements Menu_Option {
	
	private TheDocument doc;
	
	/**
	 * creates a toggle indent command for the doc
	 * @param theDocument
	 */
	public ToggleIndentCommand(TheDocument theDocument){
		doc = theDocument;
	}

	@Override
	/**
	 * toggles the indent for the doc
	 */
	public void execute() {
		doc.toggleIndent();
	}

	@Override
	public void execute(Object obj) {}

}
