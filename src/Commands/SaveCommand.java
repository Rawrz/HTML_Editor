package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;
import Entities.Menu_Option;

public class SaveCommand implements Menu_Option{
	private TheDocument doc;
	public SaveCommand(TheDocument theDocument){
		doc = theDocument;
	}
	@Override
	public void execute() {
		//doc.save();
	}
    @Override
    public void execute(Object obj) {
        // TODO Auto-generated method stub
        
    }

}
