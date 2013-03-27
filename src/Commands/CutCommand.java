package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;
import Entities.Menu_Option;

public class CutCommand implements Menu_Option{
	
	private TheDocument doc;
	
	public CutCommand(TheDocument theDocument){
		doc = theDocument;
	}
	@Override
	public void execute() {
		doc.cut();
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
