package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 * executes the save as command
 * @author Ben Kantor
 *
 */
public class SaveAsCommand implements Menu_Option{

	private TheDocument doc;
	
	/**
	 * creates a save as command for the doc
	 * @param theDocument
	 */
	public SaveAsCommand(TheDocument theDocument){
		doc = theDocument;
	}

	@Override
	public void execute() {
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
