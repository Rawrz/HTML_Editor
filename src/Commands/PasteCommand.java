package Commands;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 * executes the paste command
 * @author Ben Kantor
 *
 */
public class PasteCommand implements Menu_Option{
	
	private TheDocument doc;
	
	/**
	 * creates a paste command for the doc
	 * @param theDocument
	 */
	public PasteCommand(TheDocument theDocument){
		doc = theDocument;
	}

	@Override
	/**
	 * pastes to the doc
	 */
	public void execute() {
		doc.paste();		
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
