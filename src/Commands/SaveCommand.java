package Commands;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 * executes the save command
 * @author Ben Kantor
 *
 */
public class SaveCommand implements Menu_Option{

	private TheDocument doc;
	
	/**
	 * creates a save command for the doc
	 * @param theDocument
	 */
	public SaveCommand(TheDocument theDocument){
		setDoc(theDocument);
	}

	@Override
	public void execute() {
		//doc.save();
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
