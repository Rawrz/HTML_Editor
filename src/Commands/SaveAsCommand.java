package Commands;

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
		setDoc(theDocument);
	}

	@Override
	public void execute() {
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

    public void setDoc(TheDocument doc) {
        this.doc = doc;
    }

    public TheDocument getDoc() {
        return doc;
    }

}
