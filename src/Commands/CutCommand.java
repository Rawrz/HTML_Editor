package Commands;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 * executes the cut command
 * @author Ben Kantor
 *
 */
public class CutCommand implements Menu_Option{
	
	private TheDocument doc;
	
	/**
	 * creates a cut command for the doc
	 * @param theDocument
	 */
	public CutCommand(TheDocument theDocument){
		doc = theDocument;
	}
	@Override
	/**
	 * cuts the doc
	 */
	public void execute() {
		doc.cut();
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
