package Commands;

import javax.swing.text.html.HTML;

import Entities.TheDocument;
import Entities.Menu_Option;

public class InsertCommand implements Menu_Option{
	private TheDocument doc;
	public InsertCommand(TheDocument theDocument){
		doc = theDocument;
	}
	@Override
	public void execute(Object obj) {
		doc.insert((String)obj);
	}

    @Override
    public void execute() {
        
    }

}
