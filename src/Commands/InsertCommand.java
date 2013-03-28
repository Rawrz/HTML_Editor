package Commands;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 * executes the insert command
 * @author Ben Kantor
 *
 */
public class InsertCommand implements Menu_Option{

	private TheDocument doc;
	
	/**
	 * creates an insert command for the doc
	 * @param theDocument
	 */
	public InsertCommand(TheDocument theDocument){
		doc = theDocument;
	}
	@Override
	/**
	 * inserts the given string
	 */
	public void execute(Object obj) {
		doc.insert((String)obj);
	}

    @Override
    public void execute() {
        
    }

}
