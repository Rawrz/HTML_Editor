package Commands;

import Entities.TheDocument;
import Entities.Menu_Option;

/**
 * executes the indent command
 * @author Ben Kantor
 *
 */
public class IndentCommand implements Menu_Option{
	private TheDocument doc;
	
	/**
	 * creates an indent command for the doc
	 * @param theDocument
	 */
	public IndentCommand(TheDocument theDocument){
		doc = theDocument;
	}

	@Override
	/**
	 * indents the doc
	 */
	public void execute() {
		doc.indent();		
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
