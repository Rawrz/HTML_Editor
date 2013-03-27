package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;
import Entities.Menu_Option;

public class IndentCommand implements Menu_Option{
	private TheDocument doc;
	
	public IndentCommand(TheDocument theDocument){
		doc = theDocument;
	}

	@Override
	public void execute() {
		doc.indent();		
	}

    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
