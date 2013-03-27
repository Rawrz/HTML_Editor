package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;
import Entities.Menu_Option;

public class PasteCommand implements Menu_Option{
	
	private TheDocument doc;
	
	public PasteCommand(TheDocument theDocument){
		doc = theDocument;
	}
	@Override
	public void execute() {
		doc.paste();		
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
